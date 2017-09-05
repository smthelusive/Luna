package luna.service;

import java.util.List;

public interface RunwayService {
    /**
     * finds 10 most common runway identities (le_ident column)
     * @return List<String> list of identites
     */
    List<String> findMostCommonLeIdent();
}
