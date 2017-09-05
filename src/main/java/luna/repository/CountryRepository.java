package luna.repository;

import luna.domain.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
    @Query("select c from Country c where lower(c.name) like lower(concat(?1, '%'))" +
            "or lower(c.code) like lower(concat(?2, '%'))")
    List<Country> findAllByNameOrCode(String name, String code);
}