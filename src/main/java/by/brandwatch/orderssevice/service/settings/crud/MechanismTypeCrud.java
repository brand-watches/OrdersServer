package by.brandwatch.orderssevice.service.settings.crud;

import by.brandwatch.orderssevice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.orderssevice.service.settings.model.MechanismTypeDto;
import by.brandwatch.orderssevice.service.settings.util.converter.MechanismTypeConverter;
import by.brandwatch.orderssevice.service.util.constants.SettingType;
import by.brandwatch.orderssevice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class MechanismTypeCrud extends CrudService<MechanismTypeEntity, MechanismTypeDto> {
    @Autowired
    public MechanismTypeCrud(CrudRepository<MechanismTypeEntity, Long> repository) {
        super(new MechanismTypeConverter(), repository, SettingType.MECHANISM.name());
    }
}
