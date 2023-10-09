package by.brandwatch.orderssevice.repository.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    boolean existsAllByIdIn(Set<Long> ids);
    List<OrderEntity> findAllByIdIn(Set<Long> ids);
    Page<OrderEntity> findBy(Pageable pageable);

    Page<OrderEntity> findAll(Specification<OrderEntity> specification, Pageable pageable);

}
