package zw.hitrac.csdwebservice.domain;

import java.util.Date;
import zw.co.hitrac.jaxcsd.api.domain.Credential;

/**
 *
 * @author Charles Chigoriwa
 */
public class LiteCredential {

    private Date issueDate;
    private Date renewalDate;
    private String issueAuthority;
    private String number;

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getIssueAuthority() {
        return issueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static LiteCredential valueOf(Credential credential) {
        LiteCredential liteCredential = new LiteCredential();
        liteCredential.setIssueAuthority(credential.getIssuingAuthority());
        liteCredential.setNumber(credential.getNumber());
        liteCredential.setIssueDate(credential.getCredentialIssueDate());
        liteCredential.setRenewalDate(credential.getCredentialRenewalDate());
        return liteCredential;
    }

}
