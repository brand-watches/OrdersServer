package by.brandwatch.orderssevice.service.settings.model;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDto extends IdentifiedDto {
    public BrandDto(Long id, String name) {
        super(id, name);
    }
}
