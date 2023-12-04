package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.repository.setting.brand.BrandEntity;
import by.brandwatch.orderssevice.service.settings.model.BrandDto;
import by.brandwatch.orderssevice.util.converter.MultiConverter;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter extends MultiConverter<BrandEntity, BrandDto> {
    public BrandDto convertToDTO(BrandEntity entity) {
        return new BrandDto(entity.getId(), entity.getName());
    }

    public BrandEntity convertToEntity(BrandDto dto) {
        return new BrandEntity(dto.getId(), dto.getName());
    }
}
