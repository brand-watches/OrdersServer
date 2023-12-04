package by.brandwatch.orderssevice.repository.setting.bodyType;

import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Entity(name = "body_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class BodyTypeEntity extends IdentifiedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
