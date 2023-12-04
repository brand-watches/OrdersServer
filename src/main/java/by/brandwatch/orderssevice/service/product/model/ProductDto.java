package by.brandwatch.orderssevice.service.product.model;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto extends IdentifiedDto {
    private final String description;
    private final List<String> images;
    private final Long categoryId;
    private final Long brandId;
    private final Long colorId;
    private final Long mechanismTypeId;
    private final Long bodyTypeId;

    public ProductDto(Long id, String name, String description, List<String> images, Long categoryId, Long brandId, Long colorId, Long mechanismTypeId, Long bodyTypeId) {
        super(id, name);
        this.description = description;
        this.images = images;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.colorId = colorId;
        this.mechanismTypeId = mechanismTypeId;
        this.bodyTypeId = bodyTypeId;
    }
}
