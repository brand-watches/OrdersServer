package by.brandwatch.orderssevice.service.settings.crud;

import by.brandwatch.orderssevice.repository.setting.brand.BrandEntity;
import by.brandwatch.orderssevice.service.settings.model.BrandDto;
import by.brandwatch.orderssevice.service.settings.util.converter.BrandConverter;
import by.brandwatch.orderssevice.service.util.constants.SettingType;
import by.brandwatch.orderssevice.util.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class BrandCrud extends CrudService<BrandEntity, BrandDto> {

    @Autowired
    public BrandCrud(CrudRepository<BrandEntity, Long> repository) {
        super(new BrandConverter(), repository, SettingType.BRAND.name());
    }
}
