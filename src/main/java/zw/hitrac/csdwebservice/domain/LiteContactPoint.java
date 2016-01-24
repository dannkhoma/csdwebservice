package zw.hitrac.csdwebservice.domain;

import zw.co.hitrac.jaxcsd.api.domain.ContactPoint;

/**
 *
 * @author Daniel Nkhoma
 */
public class LiteContactPoint {

    private LiteCodedType liteCodedType;

    public LiteCodedType getLiteCodedType() {
        return liteCodedType;
    }

    public void setLiteCodedType(LiteCodedType liteCodedType) {
        this.liteCodedType = liteCodedType;
    }

    public static LiteContactPoint valueOf(ContactPoint contactPoint) {
        LiteContactPoint liteContactPoint = new LiteContactPoint();
        liteContactPoint.setLiteCodedType(LiteCodedType.valueOf(contactPoint.getCodedType()));
        return liteContactPoint;
    }

}
