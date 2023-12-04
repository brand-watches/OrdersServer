package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.orderssevice.service.settings.model.BodyTypeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyTypeConverterTest {
    @InjectMocks
    private BodyTypeConverter bodyTypeConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        BodyTypeEntity entity = MockEntity.createBodyTypeEntity();
        BodyTypeDto expectedDto = MockDto.createBodyTypeDto();

        BodyTypeDto actualDto = bodyTypeConverter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        BodyTypeDto dto = MockDto.createBodyTypeDto();
        BodyTypeEntity expectedEntity = MockEntity.createBodyTypeEntity();

        BodyTypeEntity actualEntity = bodyTypeConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
