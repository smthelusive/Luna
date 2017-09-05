package luna.service;

import luna.repository.RunwaySpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunwayDefaultService implements RunwayService {

    private RunwaySpecialRepository runwaySpecialRepository;

    @Autowired
    public RunwayDefaultService(RunwaySpecialRepository runwaySpecialRepository) {
        this.runwaySpecialRepository = runwaySpecialRepository;
    }

    @Override
    public List<String> findMostCommonLeIdent() {
        return runwaySpecialRepository.findMostCommonRunwayIdents();
    }
}
