package by.brandwatch.orderssevice.util.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class IdentifiedEntity{

    private Long id;

    private String name;
}
