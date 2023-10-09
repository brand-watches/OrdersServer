package by.brandwatch.orderssevice.service.product.model;

import by.brandwatch.orderssevice.service.settings.model.*;
import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class ProductViewDto extends IdentifiedDto {
    private final String description;
    private final List<String> images;
    private final CategoryDto category;
    private final BrandDto brand;
    private final ColorDto color;
    private final MechanismTypeDto mechanismType;
    private final BodyTypeDto bodyType;

    public ProductViewDto(Long id, String name, String description, List<String> images, CategoryDto category, BrandDto brand, ColorDto color, MechanismTypeDto mechanismType, BodyTypeDto bodyType) {
        super(id, name);
        this.description = description;
        this.images = images;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.mechanismType = mechanismType;
        this.bodyType = bodyType;
    }
}

