package by.brandwatch.orderssevice.service.settings.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.setting.category.CategoryEntity;
import by.brandwatch.orderssevice.service.settings.model.CategoryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryConverterTest {
    @InjectMocks
    private CategoryConverter categoryConverter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToDTO() {
        CategoryEntity entity = MockEntity.createCategoryEntity();
        CategoryDto expectedDto = MockDto.createCategoryDto();

        CategoryDto actualDto = categoryConverter.convertToDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        CategoryDto dto = MockDto.createCategoryDto();
        CategoryEntity expectedEntity = MockEntity.createCategoryEntity();

        CategoryEntity actualEntity = categoryConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
