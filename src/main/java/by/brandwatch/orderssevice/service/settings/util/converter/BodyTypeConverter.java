package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.orderssevice.service.settings.model.BodyTypeDto;
import by.brandwatch.orderssevice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class BodyTypeConverter extends MultiConverter<BodyTypeEntity, BodyTypeDto> {

    public BodyTypeDto convertToDTO(BodyTypeEntity entity) {
        return new BodyTypeDto(entity.getId(), entity.getName());
    }

    public BodyTypeEntity convertToEntity(BodyTypeDto dto) {
        return new BodyTypeEntity(dto.getId(), dto.getName());
    }
}
