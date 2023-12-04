package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.setting.brand.BrandEntity;
import by.brandwatch.orderssevice.service.settings.model.BrandDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandConverterTest {
    @InjectMocks
    private BrandConverter brandConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        BrandEntity entity = MockEntity.createBrandEntity();
        BrandDto expectedDto = MockDto.createBrandDto();

        BrandDto actualDto = brandConverter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        BrandDto dto = MockDto.createBrandDto();
        BrandEntity expectedEntity = MockEntity.createBrandEntity();

        BrandEntity actualEntity = brandConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
