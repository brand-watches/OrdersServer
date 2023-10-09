package by.brandwatch.orderssevice.util.crud;

import by.brandwatch.orderssevice.exception.DuplicateEntityException;
import by.brandwatch.orderssevice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.orderssevice.util.converter.MultiConverter;
import by.brandwatch.orderssevice.util.model.dto.IdentifiedDto;
import by.brandwatch.orderssevice.util.model.entity.IdentifiedEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class CrudService<Entity extends IdentifiedEntity, DTO extends IdentifiedDto> {

    protected final MultiConverter<Entity, DTO> converter;

    protected final CrudRepository<Entity, Long> repository;

    protected final String entityName;

    @Transactional
    public void update(DTO[] dtos) {
        List<Entity> entitiesToInsert = converter.convertToEntities(Arrays.asList(dtos));
        Iterable<Entity> existingEntities = repository.findAll();
        List<Long> existingEntitiesIds = new ArrayList<>();
        for (Entity entity : existingEntities) {
            existingEntitiesIds.add(entity.getId());
        }
        List<Long> entitiesToUpdateIds = entitiesToInsert.stream().map(IdentifiedEntity::getId).toList();
        this.checkIfPossibleToUpdateByIds(existingEntitiesIds, entitiesToUpdateIds);
        List<Long> idsToDelete = existingEntitiesIds.stream().filter(id -> !entitiesToUpdateIds.contains(id)).toList();
        if (!idsToDelete.isEmpty() && idsToDelete.get(0) != null) {
            repository.deleteAllById(idsToDelete);
        }

        try {
            repository.saveAll(entitiesToInsert);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityException(entityName);
        }
    }

    public List<DTO> getAll() {
        Iterable<Entity> entities = repository.findAll();
        return converter.convertToDTOs(StreamSupport.stream(entities.spliterator(), false)
                .collect(Collectors.toList()));
    }

    public List<DTO> getEntitiesByIds(Set<Long> ids) {
        Iterable<Entity> entities = repository.findAllById(ids);
        List<Long> entityIds = StreamSupport.stream(entities.spliterator(), false).map(Entity::getId).toList();
        this.checkIfAllEntitiesFound(ids.stream().toList(), entityIds);
        return converter.convertToDTOs(StreamSupport.stream(entities.spliterator(), false)
                .collect(Collectors.toList()));
    }

    public Entity getEntityById(Long id) {
        Entity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new EntitiesNotFoundByIdsException(List.of(id), entityName);
        }
        return entity;
    }

    private void checkIfPossibleToUpdateByIds(List<Long> existingEntitiesIds, List<Long> newEntitiesIds) {
        List<Long> invalidIds = newEntitiesIds.stream().filter(id -> !existingEntitiesIds.contains(id)).toList();
        if (!invalidIds.isEmpty() && invalidIds.get(0) != null) {
            throw new EntitiesNotFoundByIdsException(invalidIds, entityName);
        }
    }

    private void checkIfAllEntitiesFound(List<Long> ids, List<Long> entitiesIds) {
        List<Long> invalidIds = ids.stream().filter(id -> !entitiesIds.contains(id)).toList();
        if (!invalidIds.isEmpty() && invalidIds.get(0) != null) {
            throw new EntitiesNotFoundByIdsException(invalidIds, entityName);
        }
    }
}
