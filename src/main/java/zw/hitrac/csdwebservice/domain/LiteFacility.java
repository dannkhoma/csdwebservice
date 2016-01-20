package zw.hitrac.csdwebservice.domain;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Facility;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteFacility extends LiteCsdEntity {

    private String primaryName;

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public static LiteFacility valueOf(Facility facility) {

        LiteFacility liteFacility = new LiteFacility();
        liteFacility.setPrimaryName(facility.getPrimaryName());

        List<CodedType> codedTypes = facility.getCodedTypes();
        if (codedTypes != null && !codedTypes.isEmpty()) {
            for (CodedType codedType : codedTypes) {
                liteFacility.getCodedTypes().add(LiteCodedType.valueOf(codedType));
            }
        }

        return liteFacility;
    }

}
