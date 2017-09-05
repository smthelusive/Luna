package luna;

import luna.domain.Country;
import luna.service.CountryService;
import luna.service.RunwayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LunaApplication.class)
public class LunaApplicationTests {

    @Autowired
    private CountryService countryService;
    @Autowired
    private RunwayService runwayService;

    /**
     * test getting right country by code and name and part of name
     * @throws Exception
     */
    @Test
    public void testSearchByNameOrCode() throws Exception {
        List<Country> countries = countryService.findAllByNameOrCode("us");
        for (Country c : countries) {
            assertEquals(c.getName(), "United States");
        }
        countries = countryService.findAllByNameOrCode("zimb");
        for (Country c : countries) {
            assertEquals(c.getName(), "Zimbabwe");
        }
    }
    /**
     * test getting 10 not null records of countries with highest number of airports
     * @throws Exception
     */
    @Test
    public void testCountryWithMaximumAirports() throws Exception {
        List<Object[]> result = countryService.findWithMaxAirports();
        assertTrue(result.size() == 10);
        for (Object[] row : result) {
            assertFalse(row == null);
            assertFalse(row[0] == null || row[1] == null);
        }
    }
    /**
     * test getting 10 not null records of countries with lowest number of airports
     * @throws Exception
     */
    @Test
    public void testMinimumAirports() throws Exception {
        List<Object[]> result = countryService.findWithMinAirports();
        assertTrue(result.size() == 10);
        for (Object[] row : result) {
            assertFalse(row == null);
            assertFalse(row[0] == null || row[1] == null);
        }
    }
    /**
     * test getting all surfaces not null and not empty
     * (null or empty records must show "no information" instead)
     * @throws Exception
     */
    @Test
    public void testSurfaces() throws Exception {
        List<Object[]> result = countryService.findWithSurfaces();
        for (Object[] row : result) {
            assertTrue(row[1] != null && !row[1].toString().toLowerCase().equals("null")
                    && !row[1].toString().trim().equals(""));
        }
    }
    /**
     * test getting 10 not null records of most common runway identifications
     * @throws Exception
     */
    @Test
    public void testRunways() throws Exception {
        List<String> result = runwayService.findMostCommonLeIdent();
        assertTrue(result.size() == 10);
        for (String ident : result) {
            assertFalse(ident == null || ident.toLowerCase().equals("null"));
        }
    }

}
