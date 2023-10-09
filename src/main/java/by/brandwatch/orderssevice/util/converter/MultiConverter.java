package by.brandwatch.orderssevice.util.converter;

import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MultiConverter<Entity extends IdentifiedEntity, DTO extends IdentifiedDto> {

    public List<DTO> convertToDTOs(List<Entity> entities) {
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<Entity> convertToEntities(List<DTO> dtos) {
        return dtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    public DTO convertToDTO(Entity entity) {
        throw new MethodNotAllowedException("Method not allowed", null);
    }

    public Entity convertToEntity(DTO dto) {
        throw new MethodNotAllowedException("Method not allowed", null);
    }
}
