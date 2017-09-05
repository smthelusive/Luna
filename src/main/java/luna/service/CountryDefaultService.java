package luna.service;

import luna.domain.Airport;
import luna.domain.Country;
import luna.domain.Runway;
import luna.repository.CountryRepository;
import luna.repository.CountrySpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CountryDefaultService implements CountryService {

    private CountryRepository countryRepository;
    private CountrySpecialRepository countrySpecialRepository;

    @Autowired
    public CountryDefaultService(CountryRepository countryRepository,
                                 CountrySpecialRepository countrySpecialRepository) {
        this.countryRepository = countryRepository;
        this.countrySpecialRepository = countrySpecialRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findWithSurfaces() {
        List<Object[]> result = new ArrayList<>();
        for (Country c : countryRepository.findAll()) {
            Set runways = new HashSet<String>();
            String[] row = new String[2];
            row[0] = c.getName();
            for (Airport a : c.getAirports()) {
                for (Runway r : a.getRunways()) {
                    runways.add(r.getSurface());
                }
            }
            String runwaysStr = "";
            for (String runway : (Iterable<String>) runways) {
                if (runway!= null && !runway.toLowerCase().equals("null"))
                    runwaysStr += runway + "; ";
            }
            if (!runwaysStr.trim().equals("")) {
                row[1] = runwaysStr;
            } else {
                row[1] = "no information";
            }
            result.add(row);
        }
        return result;
    }

    @Override
    public List<Object[]> findWithMaxAirports() {
        return countrySpecialRepository.findWithMaxAirports();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> findWithMinAirports() {
        return countrySpecialRepository.findWithMinAirports();
    }

    @Override
    public List<Country> findAllByNameOrCode(String name) {
        return countryRepository.findAllByNameOrCode(name, name);
    }
}
