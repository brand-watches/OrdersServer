package by.brandwatch.orderssevice.repository.setting.brand;

import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
