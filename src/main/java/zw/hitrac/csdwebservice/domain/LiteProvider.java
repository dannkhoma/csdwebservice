package zw.hitrac.csdwebservice.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Credential;
import zw.co.hitrac.jaxcsd.api.domain.Provider;

/**
 *
 * @author Charles Chigoriwa
 */
public class LiteProvider {

    private String firstName;
    private String lastName;

    private List<LiteCredential> credentials = new ArrayList<>();

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

}
