package by.brandwatch.orderssevice.repository.setting.mechanismType;

import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "mechanism_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class MechanismTypeEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}