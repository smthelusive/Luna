package luna.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RunwayRepositoryImpl implements RunwaySpecialRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findMostCommonRunwayIdents() {
        return em.createNativeQuery("select r.le_ident " +
                "from Runways r " +
                "group by r.le_ident " +
                "order by count(*) desc " +
                "limit 10").getResultList();
    }
}
