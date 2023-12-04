package by.brandwatch.orderssevice.service.settings.crud;

import by.brandwatch.orderssevice.repository.setting.color.ColorEntity;
import by.brandwatch.orderssevice.service.settings.model.ColorDto;
import by.brandwatch.orderssevice.service.settings.util.converter.ColorConverter;
import by.brandwatch.orderssevice.service.util.constants.SettingType;
import by.brandwatch.orderssevice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class ColorCrud extends CrudService<ColorEntity, ColorDto> {
    @Autowired
    public ColorCrud(CrudRepository<ColorEntity, Long> repository) {
        super(new ColorConverter(), repository, SettingType.COLOR.name());
    }
}
