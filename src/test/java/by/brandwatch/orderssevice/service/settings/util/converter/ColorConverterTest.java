package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.setting.color.ColorEntity;
import by.brandwatch.orderssevice.service.settings.model.ColorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorConverterTest {
    @InjectMocks
    private ColorConverter colorConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        ColorEntity entity = MockEntity.createColorEntity();
        ColorDto expectedDto = MockDto.createColorDto();

        ColorDto actualDto = colorConverter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        ColorDto dto = MockDto.createColorDto();
        ColorEntity expectedEntity = MockEntity.createColorEntity();

        ColorEntity actualEntity = colorConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
