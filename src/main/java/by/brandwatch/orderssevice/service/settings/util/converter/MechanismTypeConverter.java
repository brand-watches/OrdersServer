package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.orderssevice.service.settings.model.MechanismTypeDto;
import by.brandwatch.orderssevice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class MechanismTypeConverter extends MultiConverter<MechanismTypeEntity, MechanismTypeDto> {

    public MechanismTypeDto convertToDTO(MechanismTypeEntity entity) {
        return new MechanismTypeDto(entity.getId(), entity.getName());
    }

    public MechanismTypeEntity convertToEntity(MechanismTypeDto dto) {
        return new MechanismTypeEntity(dto.getId(), dto.getName());
    }
}
