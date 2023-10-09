package by.brandwatch.orderssevice.service.settings.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GlobalOptionsDto {
    public CategoryDto[] categoryDtos;
    public BodyTypeDto[] bodyTypeDtos;
    public BrandDto[] brandDtos;
    public ColorDto[] colorDtos;
    public MechanismTypeDto[] mechanismTypeDtos;
}
