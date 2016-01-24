package zw.hitrac.csdwebservice.domain;

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

        return liteFacility;
    }

}
