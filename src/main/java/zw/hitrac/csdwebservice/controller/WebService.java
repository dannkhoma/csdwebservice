package zw.hitrac.csdwebservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.hitrac.jaxcsd.api.domain.CSD;
import zw.co.hitrac.jaxcsd.api.domain.OtherID;
import zw.co.hitrac.jaxcsd.api.domain.Provider;
import zw.co.hitrac.jaxcsd.api.query.CallOptions;
import zw.co.hitrac.jaxcsd.api.query.CsdQueryClient;
import zw.co.hitrac.jaxcsd.api.query.RequestParams;
import zw.hitrac.csdwebservice.domain.LiteProvider;
import zw.hitrac.csdwebservice.domain.ResourceNotFoundException;

/**
 *
 * @author Charles Chigoriwa
 */
@RestController
public class WebService {

    @RequestMapping("/providers")
    public LiteProvider getProvider() {
        return new LiteProvider("Charles", "Chigoriwa");
    }

    @RequestMapping("/directories/{directoryId}/providers/{authorityName}/{code}")
    public LiteProvider getLiteProvider(@PathVariable String directoryId, @PathVariable String authorityName, @PathVariable String code) {
        Provider provider = getProvider(directoryId, authorityName, code);
        if (provider == null) {
            throw new ResourceNotFoundException();
        } else {
            return LiteProvider.valueOf(provider);
        }

    }

    public Provider getProvider(String directoryId, String authorityName, String code) {
        CsdQueryClient csdQueryClient = new CsdQueryClient();
        RequestParams requestParams = new RequestParams();

        OtherID otherID = new OtherID();
        otherID.setAssigningAuthorityName(authorityName);
        otherID.setCode(code);
        requestParams.setOtherID(otherID);
        String functionId = "urn:ihe:iti:csd:2014:stored-function:provider-search";
        String httpAddress = "http://zhrisproject.hitrac.co.zw:9094/CSD/csr/" + directoryId + "/careServicesRequest";
        CallOptions callOptions = new CallOptions();
        CSD csd = csdQueryClient.callStandardStoredFunction(requestParams, functionId, httpAddress, callOptions);
        List<Provider> providers = csd.getProviderDirectory().getProviders();
        if (providers.isEmpty()) {
            return null;
        } else {
            Provider $provider = providers.get(0);
            return $provider;
        }

    }

}
