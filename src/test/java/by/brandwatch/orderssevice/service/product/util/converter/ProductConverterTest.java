package by.brandwatch.orderssevice.service.product.util.converter;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.product.ProductEntity;
import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.orderssevice.repository.setting.brand.BrandEntity;
import by.brandwatch.orderssevice.repository.setting.category.CategoryEntity;
import by.brandwatch.orderssevice.repository.setting.color.ColorEntity;
import by.brandwatch.orderssevice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.orderssevice.service.product.model.ProductViewDto;
import by.brandwatch.orderssevice.service.settings.model.*;
import by.brandwatch.orderssevice.service.settings.util.converter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductConverterTest {
    @InjectMocks
    private ProductConverter productConverter;

    @Mock
    private CategoryConverter categoryConverter;
    @Mock
    private BrandConverter brandConverter;
    @Mock
    private ColorConverter colorConverter;
    @Mock
    private MechanismTypeConverter mechanismTypeConverter;
    @Mock
    private BodyTypeConverter bodyTypeConverter;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertToViewDTO() {
        ProductEntity entity = MockEntity.createProductEntity();
        ProductViewDto expectedDto = MockDto.createProductViewDto();

        CategoryDto categoryDTO = MockDto.createCategoryDto();
        BrandDto brandDTO = MockDto.createBrandDto();
        ColorDto colorDTO = MockDto.createColorDto();
        MechanismTypeDto mechanismTypeDto = MockDto.createMechanismTypeDto();
        BodyTypeDto bodyTypeDto = MockDto.createBodyTypeDto();


        when(categoryConverter.convertToDTO(entity.getCategory())).thenReturn(categoryDTO);
        when(brandConverter.convertToDTO(entity.getBrand())).thenReturn(brandDTO);
        when(colorConverter.convertToDTO(entity.getColor())).thenReturn(colorDTO);
        when(mechanismTypeConverter.convertToDTO(entity.getMechanismType())).thenReturn(mechanismTypeDto);
        when(bodyTypeConverter.convertToDTO(entity.getBodyType())).thenReturn(bodyTypeDto);

        ProductViewDto actualDto = productConverter.convertToViewDTO(entity);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    public void testConvertToEntity() {
        ProductViewDto dto = MockDto.createProductViewDto();
        ProductEntity expectedEntity = MockEntity.createProductEntity();

        CategoryEntity categoryEntity = MockEntity.createCategoryEntity();
        BrandEntity brandEntity = MockEntity.createBrandEntity();
        ColorEntity colorEntity = MockEntity.createColorEntity();
        MechanismTypeEntity mechanismTypeEntity = MockEntity.createMechanismTypeEntity();
        BodyTypeEntity bodyTypeEntity = MockEntity.createBodyTypeEntity();


        when(categoryConverter.convertToEntity(dto.getCategory())).thenReturn(categoryEntity);
        when(brandConverter.convertToEntity(dto.getBrand())).thenReturn(brandEntity);
        when(colorConverter.convertToEntity(dto.getColor())).thenReturn(colorEntity);
        when(mechanismTypeConverter.convertToEntity(dto.getMechanismType())).thenReturn(mechanismTypeEntity);
        when(bodyTypeConverter.convertToEntity(dto.getBodyType())).thenReturn(bodyTypeEntity);

        ProductEntity actualEntity = productConverter.convertToEntity(dto);

        assertEquals(expectedEntity, actualEntity);
    }
}
