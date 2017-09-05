package luna.repository;

import luna.domain.Runway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RunwayRepository extends CrudRepository<Runway, Long> {
    List<Runway> findAll();
}