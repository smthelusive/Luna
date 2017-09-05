package luna.repository;

import java.util.List;

public interface RunwaySpecialRepository {
    List<String> findMostCommonRunwayIdents();
}
