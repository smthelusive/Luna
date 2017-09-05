package luna.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountrySpecialRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findWithMaxAirports() {
        return em.createNativeQuery("select c.name, count(*) as cnt " +
                "from countries c, airports a " +
                "where c.code = a.iso_country " +
                "group by c.name " +
                "order by cnt desc " +
                "limit 10").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findWithMinAirports() {
        return em.createNativeQuery("select c.name, count(*) as cnt " +
                "from countries c, airports a " +
                "where c.code = a.iso_country " +
                "group by c.name " +
                "order by cnt " +
                "limit 10").getResultList();
    }
}