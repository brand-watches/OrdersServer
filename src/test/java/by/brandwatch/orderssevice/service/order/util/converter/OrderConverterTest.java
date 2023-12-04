package by.brandwatch.orderssevice.service.order.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.order.OrderEntity;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import by.brandwatch.orderssevice.service.product.util.converter.ProductConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OrderConverterTest {
    @InjectMocks
    private OrderConverter orderConverter;

    @Mock
    private ProductConverter productConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDto() {
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(MockEntity.createOrderEntity());

        when(productConverter.convertToViewDTO(ArgumentMatchers.any())).thenReturn(MockDto.createProductViewDto());

        List<OrderViewDto> orderViewDtos = orderConverter.convertToDto(orderEntities);

        assertNotNull(orderViewDtos);
        assertEquals(1, orderViewDtos.size());
        assertEquals("name", orderViewDtos.get(0).getNameOfCustomer());
    }

    @Test
    public void testConvertToEntity() {
        List<OrderViewDto> orderViewDtos = new ArrayList<>();
        orderViewDtos.add(MockDto.createOrderViewDto());

        when(productConverter.convertToEntity(ArgumentMatchers.any())).thenReturn(MockEntity.createProductEntity());

        List<OrderEntity> orderEntities = orderConverter.convertToEntity(orderViewDtos);

        assertNotNull(orderEntities);
        assertEquals(1, orderEntities.size());
        assertEquals("name", orderEntities.get(0).getNameOfCustomer());
    }
}
