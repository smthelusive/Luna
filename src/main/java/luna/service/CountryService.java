package luna.service;

import luna.domain.Country;

import java.util.List;

public interface CountryService {
    /**
     * finds countries with all runway surfaces per country
     * @return List<Object[]> where each Object[] = Object[2]
     * where:
     * [0] - country name,
     * [1] - list of runway surfaces
     */
    List<Object[]> findWithSurfaces();

    /**
     * finds 10 countries with maximum number of airports
     * @return List<Object[]> where each Object[] = Object[2]
     * where:
     * [0] - country name
     * [1] - count of airports
     */
    List<Object[]> findWithMaxAirports();
    /**
     * finds 10 countries with minimum number of airports
     * @return List<Object[]> where each Object[] = Object[2]
     * where:
     * [0] - country name
     * [1] - count of airports
     */
    List<Object[]> findWithMinAirports();

    /**
     * finds all Countries by name or code
     * @param name String name or code or part
     * @return List<Country>
     */
    List<Country> findAllByNameOrCode(String name);
}
