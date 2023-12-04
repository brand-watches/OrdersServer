package by.brandwatch.orderssevice.mock;

import by.brandwatch.orderssevice.repository.order.OrderEntity;
import by.brandwatch.orderssevice.repository.product.ProductEntity;
import by.brandwatch.orderssevice.repository.setting.bodyType.BodyTypeEntity;
import by.brandwatch.orderssevice.repository.setting.brand.BrandEntity;
import by.brandwatch.orderssevice.repository.setting.category.CategoryEntity;
import by.brandwatch.orderssevice.repository.setting.color.ColorEntity;
import by.brandwatch.orderssevice.repository.setting.mechanismType.MechanismTypeEntity;
import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MockEntity {

    public static IdentifiedEntity createIdentifiedEntity() {
        return new IdentifiedEntity(1L, "name");
    }

    public static CategoryEntity createCategoryEntity() {
        return new CategoryEntity(
                1L,
                "category"
        );
    }

    public static BodyTypeEntity createBodyTypeEntity() {
        return new BodyTypeEntity(
                1L,
                "bodyType"
        );
    }

    public static BrandEntity createBrandEntity() {
        return new BrandEntity(
                1L,
                "brand"
        );
    }

    public static ColorEntity createColorEntity() {
        return new ColorEntity(
                1L,
                "color",
                "#000000",
                "#000000"
        );
    }

    public static MechanismTypeEntity createMechanismTypeEntity() {
        return new MechanismTypeEntity(
                1L,
                "mechanismType"
        );
    }

    public static ProductEntity createProductEntity() {
        return new ProductEntity(
                1L,
                "product",
                "description",
                List.of("tempImages"),
                createCategoryEntity(),
                createBrandEntity(),
                createColorEntity(),
                createMechanismTypeEntity(),
                createBodyTypeEntity()
        );
    }

    public static List<ProductEntity> createProductEntities() {
        return List.of(createProductEntity());
    }

    public static OrderEntity createOrderEntity() {
        return new OrderEntity(
                1L,
                "name",
                "phoneNumber",
                "date",
                 List.of(createProductEntity()),
                true
        );
    }
}
