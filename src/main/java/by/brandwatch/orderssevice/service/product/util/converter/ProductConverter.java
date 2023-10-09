package by.brandwatch.orderssevice.service.product.util.converter;

import by.brandwatch.orderssevice.repository.product.ProductEntity;
import by.brandwatch.orderssevice.service.product.model.ProductViewDto;
import by.brandwatch.orderssevice.service.settings.util.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public final CategoryConverter categoryConverter;
    public final BrandConverter brandConverter;
    public final ColorConverter colorConverter;
    public final MechanismTypeConverter mechanismTypeConverter;
    public final BodyTypeConverter bodyTypeConverter;

    @Autowired
    public ProductConverter(CategoryConverter categoryConverter, BrandConverter brandConverter,
        ColorConverter colorConverter, MechanismTypeConverter mechanismTypeConverter, BodyTypeConverter bodyTypeConverter) {
        this.categoryConverter = categoryConverter;
        this.brandConverter = brandConverter;
        this.colorConverter = colorConverter;
        this.mechanismTypeConverter = mechanismTypeConverter;
        this.bodyTypeConverter = bodyTypeConverter;
    }

    public ProductViewDto convertToViewDTO(ProductEntity entity) {
        return new ProductViewDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImages(),
                categoryConverter.convertToDTO(entity.getCategory()),
                brandConverter.convertToDTO(entity.getBrand()),
                colorConverter.convertToDTO(entity.getColor()),
                mechanismTypeConverter.convertToDTO(entity.getMechanismType()),
                bodyTypeConverter.convertToDTO(entity.getBodyType())
        );
    }

    public ProductEntity convertToEntity(ProductViewDto dto) {
        return new ProductEntity(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getImages(),
                categoryConverter.convertToEntity(dto.getCategory()),
                brandConverter.convertToEntity(dto.getBrand()),
                colorConverter.convertToEntity(dto.getColor()),
                mechanismTypeConverter.convertToEntity(dto.getMechanismType()),
                bodyTypeConverter.convertToEntity(dto.getBodyType())
        );
    }
}
