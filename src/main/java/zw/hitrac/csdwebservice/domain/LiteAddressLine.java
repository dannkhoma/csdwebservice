package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteAddressLine {

    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public static LiteAddressLine valueOf(AddressLine addressLine) {
        LiteAddressLine liteAddressLine = new LiteAddressLine();
        liteAddressLine.setLine(addressLine.getLine());
        return liteAddressLine;
    }

}
