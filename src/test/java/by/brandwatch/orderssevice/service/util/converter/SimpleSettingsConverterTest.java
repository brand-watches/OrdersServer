package by.brandwatch.orderssevice.service.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSettingsConverterTest {
    @InjectMocks
    private SimpleSettingConverter simpleSettingConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDto() {
        IdentifiedEntity entity = MockEntity.createIdentifiedEntity();
        IdentifiedDto expectedDto = MockDto.createIdentifiedDto();

        IdentifiedDto actualDto = simpleSettingConverter.convertToDto(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        IdentifiedDto dto = MockDto.createIdentifiedDto();
        IdentifiedEntity expectedEntity = MockEntity.createIdentifiedEntity();

        IdentifiedEntity actualEntity = simpleSettingConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
