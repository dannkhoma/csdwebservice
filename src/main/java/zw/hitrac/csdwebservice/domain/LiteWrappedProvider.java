package zw.hitrac.csdwebservice.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.zhris.csd.adapter.common.domain.WrappedProvider;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteWrappedProvider {

    private LiteProvider liteProvider;

    public LiteProvider getLiteProvider() {
        return liteProvider;
    }

    public void setLiteProvider(LiteProvider liteProvider) {
        this.liteProvider = liteProvider;
    }

    public static List<LiteWrappedProvider> valueOf(List<WrappedProvider> providers) {

        LiteWrappedProvider liteWrappedProvider = new LiteWrappedProvider();
        List<LiteWrappedProvider> liteWrappedProviders = new ArrayList<>();

        for (WrappedProvider wrappedProvider : providers) {

            LiteProvider liteProvider = new LiteProvider();
            liteProvider.setFirstName(wrappedProvider.getProvider().getTopName().getForename());
            liteProvider.setLastName(wrappedProvider.getProvider().getTopName().getSurname());

            List<Credential> credentials = wrappedProvider.getProvider().getCredentials();
            if (credentials != null && !credentials.isEmpty()) {
                for (Credential credential : credentials) {
                    liteProvider.getCredentials().add(LiteCredential.valueOf(credential));
                }
            }

            List<CodedType> codedTypes = wrappedProvider.getProvider().getCodedTypes();
            if (codedTypes != null && !codedTypes.isEmpty()) {
                for (CodedType codedType : codedTypes) {
                    liteProvider.getCodedTypes().add(LiteCodedType.valueOf(codedType));
                }
            }

            List<Facility> facilities = wrappedProvider.getFacilities();
            if (facilities != null && !facilities.isEmpty()) {
                for (Facility facility : facilities) {
                    liteProvider.getFacilities().add(LiteFacility.valueOf(facility));
                }
            }

            List<Organization> organizations = wrappedProvider.getOrganizations();
            if (organizations != null && !organizations.isEmpty()) {
                for (Organization organization : organizations) {
                    liteProvider.getOrganizations().add(LiteOrganization.valueOf(organization));
                }
            }

            liteWrappedProvider.setLiteProvider(liteProvider);
            System.out.println(liteWrappedProvider.getLiteProvider().getFacilities());
            System.out.println(liteWrappedProvider.getLiteProvider().getOrganizations());
            liteWrappedProviders.add(liteWrappedProvider);
        }
        return liteWrappedProviders;
    }
}
