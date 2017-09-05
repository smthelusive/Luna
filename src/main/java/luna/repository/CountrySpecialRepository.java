package luna.repository;

import java.util.List;

public interface CountrySpecialRepository {
    List<Object[]> findWithMaxAirports();
    List<Object[]> findWithMinAirports();
}
