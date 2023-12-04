package by.brandwatch.orderssevice.service.settings.model;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import jdk.jfr.DataAmount;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class BodyTypeDto extends IdentifiedDto {
    public BodyTypeDto(Long id, String name) {
        super(id, name);
    }
}
