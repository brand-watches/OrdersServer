package by.brandwatch.orderssevice.mock;

import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import by.brandwatch.orderssevice.service.product.model.ProductDto;
import by.brandwatch.orderssevice.service.product.model.ProductViewDto;
import by.brandwatch.orderssevice.service.settings.model.*;
import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;

import java.util.List;
import java.util.Set;

public class MockDto {
    public static IdentifiedDto createIdentifiedDto() {
        return new IdentifiedDto(
                1L,
                "name"
        );
    }
    public static BodyTypeDto createBodyTypeDto() {
        return new BodyTypeDto(
                1L,
                "bodyType"
        );
    }

    public static BrandDto createBrandDto() {
        return new BrandDto(
                1L,
                "brand"
        );
    }

    public static CategoryDto createCategoryDto() {
        return new CategoryDto(
                1L,
                "category"
        );
    }

    public static ColorDto createColorDto() {
        return new ColorDto(
                1L,
                "color",
                "#000000",
                "#000000"
        );
    }

    public static MechanismTypeDto createMechanismTypeDto() {
        return new MechanismTypeDto(
                1L,
                "mechanismType"
        );
    }

    public static GlobalOptionsDto createGlobalOptionsDto() {
        return new GlobalOptionsDto(
                new CategoryDto[]{createCategoryDto()},
                new BodyTypeDto[]{createBodyTypeDto()},
                new BrandDto[]{createBrandDto()},
                new ColorDto[]{createColorDto()},
                new MechanismTypeDto[]{createMechanismTypeDto()}
        );
    }


    public static ProductViewDto createProductViewDto() {
        return new ProductViewDto(
                1L,
                "product",
                "description",
                List.of("tempImages"),
                createCategoryDto(),
                createBrandDto(),
                createColorDto(),
                createMechanismTypeDto(),
                createBodyTypeDto()
        );
    }

    public static ProductDto createProductDto() {
        return new ProductDto(
                1L,
                "name",
                "description",
                List.of("tempImages"),
                1L,
                1L,
                1L,
                1L,
                1L
        );
    }

    public static List<ProductViewDto> createProductViewDtos() {
        return List.of(createProductViewDto());
    }

    public static OrderViewDto createOrderViewDto() {
        return new OrderViewDto(
                1L,
                "name",
                "phoneNumber",
                List.of(createProductViewDto()),
                "date",
                true
        );
    }

    public static OrderDto createOrderDto() {
        return new OrderDto(
                1L,
                "name",
                "phoneNumber",
                Set.of(1L),
                true
        );
    }
}
