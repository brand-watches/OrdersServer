package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.orderssevice.service.settings.model.MechanismTypeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MechanismTypeConverterTest {
    @InjectMocks
    private MechanismTypeConverter mechanismTypeConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        MechanismTypeEntity entity = MockEntity.createMechanismTypeEntity();
        MechanismTypeDto expectedDto = MockDto.createMechanismTypeDto();

        MechanismTypeDto actualDto = mechanismTypeConverter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        MechanismTypeDto dto = MockDto.createMechanismTypeDto();
        MechanismTypeEntity expectedEntity = MockEntity.createMechanismTypeEntity();

        MechanismTypeEntity actualEntity = mechanismTypeConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
