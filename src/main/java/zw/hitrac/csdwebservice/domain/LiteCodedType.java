package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.CodedType;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteCodedType {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static LiteCodedType valueOf(CodedType codedType) {
        LiteCodedType liteCodedType = new LiteCodedType();
        liteCodedType.setValue(codedType.getValue());
        return liteCodedType;
    }

}
