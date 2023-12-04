package by.brandwatch.orderssevice.service.settings.crud;

import by.brandwatch.orderssevice.repository.setting.category.CategoryEntity;
import by.brandwatch.orderssevice.repository.setting.category.CategoryRepository;
import by.brandwatch.orderssevice.service.settings.model.CategoryDto;
import by.brandwatch.orderssevice.service.settings.util.converter.CategoryConverter;
import by.brandwatch.orderssevice.service.util.constants.SettingType;
import by.brandwatch.orderssevice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryCrud extends CrudService<CategoryEntity, CategoryDto> {

    @Autowired
    public CategoryCrud(CategoryRepository categoryRepository) {
        super(new CategoryConverter(), categoryRepository, SettingType.CATEGORY.name());
    }
}
