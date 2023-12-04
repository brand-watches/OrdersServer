package by.brandwatch.orderssevice.repository.setting.color;

import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "color")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ColorEntity extends IdentifiedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstColor;

    @Column()
    private String secondColor;
}
