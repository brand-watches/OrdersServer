package by.brandwatch.orderssevice.util.converter;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdentifiedConverterTest {
    @InjectMocks
    private IdentifiedConverter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        IdentifiedEntity entity = new IdentifiedEntity(1L, "EntityName");
        IdentifiedDto expectedDto = new IdentifiedDto(1L, "EntityName");

        IdentifiedDto actualDto = converter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        IdentifiedDto dto = new IdentifiedDto(1L, "DtoName");
        IdentifiedEntity expectedEntity = new IdentifiedEntity(1L, "DtoName");

        IdentifiedEntity actualEntity = converter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
