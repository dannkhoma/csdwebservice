package zw.hitrac.csdwebservice.domain;

import java.util.ArrayList;
import java.util.List;
import zw.co.hitrac.jaxcsd.api.domain.Address;
import zw.co.hitrac.jaxcsd.api.domain.Address.AddressLine;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteAddress {

    private List<LiteAddressLine> addressLines = new ArrayList<>();

    public List<LiteAddressLine> getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(List<LiteAddressLine> addressLines) {
        this.addressLines = addressLines;
    }

    public static LiteAddress valueOf(Address address) {

        LiteAddress liteAddress = new LiteAddress();
        List<AddressLine> addressLines = address.getAddressLines();
        if (address.getAddressLines() != null && !addressLines.isEmpty()) {
            for (AddressLine addressLine : address.getAddressLines()) {
                if (addressLine != null) {
                    liteAddress.getAddressLines().add(LiteAddressLine.valueOf(addressLine));
                }
            }
        }
        return liteAddress;
    }
}
