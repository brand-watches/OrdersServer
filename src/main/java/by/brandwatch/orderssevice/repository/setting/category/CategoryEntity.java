package by.brandwatch.orderssevice.repository.setting.category;

import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CategoryEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
