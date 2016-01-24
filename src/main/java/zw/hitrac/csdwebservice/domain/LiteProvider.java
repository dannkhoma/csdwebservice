package zw.hitrac.csdwebservice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.CodedType;
import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.Facility;
import zw.co.hitrac.jaxcsd.api.domain.Name;
import zw.co.hitrac.jaxcsd.api.domain.Organization;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.zhris.csd.adapter.common.domain.WrappedProvider;

/**
 *
 * @author Charles Chigoriwa
 */
public class LiteProvider {

    private String title;
    private String firstName;
    private String lastName;
    private String initial;
    private String gender;
    private Date dateOfBirth;

    private List<LiteContactPoint> contactPoints = new ArrayList();
    private List<LiteAddress> addreses = new ArrayList();

    private List<LiteCredential> credentials = new ArrayList<>();
    private List<LiteCodedType> codedTypes = new ArrayList<>();
    private List<LiteFacility> facilities = new ArrayList<>();
    private List<LiteOrganization> organizations = new ArrayList<>();

    public LiteProvider() {
    }

    public LiteProvider(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<LiteCredential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<LiteCredential> credentials) {
        this.credentials = credentials;
    }

    public List<LiteCodedType> getCodedTypes() {
        return codedTypes;
    }

    public void setCodedTypes(List<LiteCodedType> codedTypes) {
        this.codedTypes = codedTypes;
    }

    public List<LiteFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<LiteFacility> facilities) {
        this.facilities = facilities;
    }

    public List<LiteOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<LiteOrganization> organizations) {
        this.organizations = organizations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<LiteContactPoint> getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(List<LiteContactPoint> contactPoints) {
        this.contactPoints = contactPoints;
    }

    public List<LiteAddress> getAddreses() {
        return addreses;
    }

    public void setAddreses(List<LiteAddress> addreses) {
        this.addreses = addreses;
    }

    public static LiteProvider valueOf(Provider provider) {
        LiteProvider liteProvider = new LiteProvider();
        liteProvider.setFirstName(provider.getTopName().getForename());
        liteProvider.setLastName(provider.getTopName().getSurname());
        List<Credential> credentials = provider.getCredentials();
        if (credentials != null && !credentials.isEmpty()) {
            for (Credential credential : credentials) {
                liteProvider.getCredentials().add(LiteCredential.valueOf(credential));
            }
        }
        return liteProvider;
    }

    public static List<LiteProvider> valueOf(List<WrappedProvider> providers) {

        List<LiteProvider> liteProviders = new ArrayList<>();

        for (WrappedProvider wrappedProvider : providers) {

            Provider provider = wrappedProvider.getProvider();
            LiteProvider liteProvider = new LiteProvider();
            Name name = provider.getTopName();

            liteProvider.setFirstName(name.getForename());
            liteProvider.setLastName(name.getSurname());

            if (name.getHonorific() != null) {
                liteProvider.setTitle(name.getHonorific());
            }

            if (name.getSuffix() != null) {
                liteProvider.setInitial(name.getSuffix());
            }

            if (provider.getDemographic().getDateOfBirth() != null) {
                liteProvider.setDateOfBirth(provider.getDemographic().getDateOfBirth());
            }

            if (provider.getDemographic().getGender() != null) {
                liteProvider.setGender(provider.getDemographic().getGender());
            }

            List<Credential> credentials = provider.getCredentials();
            if (credentials != null && !credentials.isEmpty()) {
                for (Credential credential : credentials) {
                    liteProvider.getCredentials().add(LiteCredential.valueOf(credential));
                }
            }

            List<ContactPoint> contactPoints = provider.getDemographic().getContactPoints();
            if (contactPoints != null && !contactPoints.isEmpty()) {
                for (ContactPoint contactPoint : contactPoints) {
                    liteProvider.getContactPoints().add(LiteContactPoint.valueOf(contactPoint));
                }
            }

            List<Address> addresses = provider.getDemographic().getAddresses();
            if (addresses != null && !addresses.isEmpty()) {
                for (Address address : addresses) {
                    liteProvider.getAddreses().add(LiteAddress.valueOf(address));
                }
            }

            List<CodedType> codedTypes = provider.getCodedTypes();
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

            liteProviders.add(liteProvider);
        }
        return liteProviders;
    }

}
