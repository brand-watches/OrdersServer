package by.brandwatch.orderssevice.service.settings.model;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class ColorDto extends IdentifiedDto {
    public String firstColor;

    public String secondColor;

    public ColorDto(Long id, String name, String firstColor, String secondColor) {
        super(id, name);
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }
}


