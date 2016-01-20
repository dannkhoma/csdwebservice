package zw.hitrac.csdwebservice.domain;

import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Organization;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteOrganization extends LiteCsdEntity {

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

        List<CodedType> codedTypes = organization.getCodedTypes();
        if (codedTypes != null && !codedTypes.isEmpty()) {
            for (CodedType codedType : codedTypes) {
                liteOrganization.getCodedTypes().add(LiteCodedType.valueOf(codedType));
            }
        }

        return liteOrganization;
    }

}
