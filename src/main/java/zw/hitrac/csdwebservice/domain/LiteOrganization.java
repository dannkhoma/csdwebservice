package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.Organization;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteOrganization {

    private String primaryName;

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public static LiteOrganization valueOf(Organization organization) {
        LiteOrganization liteOrganization = new LiteOrganization();
        liteOrganization.setPrimaryName(organization.getPrimaryName());
        return liteOrganization;
    }

}
