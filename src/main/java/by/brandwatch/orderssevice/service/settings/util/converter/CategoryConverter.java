package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.repository.setting.category.CategoryEntity;
import by.brandwatch.orderssevice.service.settings.model.CategoryDto;
import by.brandwatch.orderssevice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends MultiConverter<CategoryEntity, CategoryDto> {

    public CategoryDto convertToDTO(CategoryEntity entity) {
        return new CategoryDto(entity.getId(), entity.getName());
    }

    public CategoryEntity convertToEntity(CategoryDto dto) {
        return new CategoryEntity(dto.getId(), dto.getName());
    }
}
