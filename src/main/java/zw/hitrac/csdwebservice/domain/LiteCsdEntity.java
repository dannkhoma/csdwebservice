package zw.hitrac.csdwebservice.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Nkhoma
 */
public abstract class LiteCsdEntity {

    protected List<LiteCodedType> codedTypes = new ArrayList<>();

    public List<LiteCodedType> getCodedTypes() {
        return codedTypes;
    }

    public void setCodedTypes(List<LiteCodedType> codedTypes) {
        this.codedTypes = codedTypes;
    }
}
