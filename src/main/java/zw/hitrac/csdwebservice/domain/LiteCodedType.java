package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.CodedType;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteCodedType {
    
    private String code;
    private String codingScheme;
    private String value;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCodingScheme() {
        return codingScheme;
    }
    
    public void setCodingScheme(String codingScheme) {
        this.codingScheme = codingScheme;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public static LiteCodedType valueOf(CodedType codedType) {
        LiteCodedType liteCodedType = new LiteCodedType();
        liteCodedType.setCode(codedType.getCode());
        liteCodedType.setCodingScheme(codedType.getCodingScheme());
        liteCodedType.setValue(codedType.getValue());
        return liteCodedType;
    }
    
}
