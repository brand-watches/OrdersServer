package by.brandwatch.orderssevice.filter;

import by.brandwatch.orderssevice.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Value("${app.validation.validationServer.validate.url}")
    private String validationUrl;

    private final RestTemplate restTemplate;

    private final Map<String, List<String>> UNSECURE_ENDPOINTS = new HashMap<>() {
        {
            put("/api/v1/orders", new ArrayList<>(List.of("GET", "POST")));
        }
    };

    @Autowired
    public AuthenticationFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, UnauthorizedException {
        String jwtToken = extractJwtToken(request);
        HttpEntity<String> requestEntity = this.createRequestEntity(jwtToken);
        restTemplate.postForObject(validationUrl, requestEntity, Void.class);
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        String method = request.getMethod();
        List<String> methods = UNSECURE_ENDPOINTS.get(this.findKeyURI(path));
        if (methods != null) {
            return methods.contains(method);
        } else {
            return false;
        }
    }

    private String extractJwtToken(HttpServletRequest request) throws UnauthorizedException {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        } else {
            throw new UnauthorizedException();
        }
    }

    private String findKeyURI(String fullPath) {
        for (String key : this.UNSECURE_ENDPOINTS.keySet()) {
            if (fullPath.contains(key)) {
                return key;
            }
        }
        return null;
    }

    private HttpEntity<String> createRequestEntity(String jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);
        return new HttpEntity<>(headers);
    }
}