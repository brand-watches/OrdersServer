package by.brandwatch.orderssevice.service.settings.crud;


import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeRepository;
import by.brandwatch.orderssevice.service.settings.model.BodyTypeDto;
import by.brandwatch.orderssevice.service.settings.util.converter.BodyTypeConverter;
import by.brandwatch.orderssevice.service.util.constants.SettingType;
import by.brandwatch.orderssevice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BodyTypeCrud extends CrudService<BodyTypeEntity, BodyTypeDto> {

    @Autowired
    public BodyTypeCrud(BodyTypeRepository bodyTypeRepository) {
        super(new BodyTypeConverter(), bodyTypeRepository, SettingType.BODY_TYPE.name());
    }
}
