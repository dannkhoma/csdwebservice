package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.Credential;

/**
 *
 * @author Charles Chigoriwa
 */
public class LiteCredential {

    private String issueDate;
    private String renewalDate;
    private String issueAuthority;
    private String number;

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(String renewalDate) {
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
        liteCredential.setIssueDate(credential.getCredentialIssueDate().toString());
        liteCredential.setRenewalDate(credential.getCredentialRenewalDate().toString());
        return liteCredential;
    }

}
