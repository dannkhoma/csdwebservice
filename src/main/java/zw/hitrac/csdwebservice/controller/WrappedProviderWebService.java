package zw.hitrac.csdwebservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.hitrac.zhris.csd.adapter.common.domain.WrappedProvider;
import zw.co.hitrac.zhris.csd.adapter.common.util.ProviderFinder;
import zw.hitrac.csdwebservice.domain.LiteWrappedProvider;
import zw.hitrac.csdwebservice.domain.ResourceNotFoundException;

/**
 *
 * @author Daniel Nkhoma
 */
@RestController
public class WrappedProviderWebService {

    @RequestMapping("/directories/{directoryId}/providers/{nationalId}")
    public List<LiteWrappedProvider> getLiteWrappedProvider(@PathVariable String nationalId, @PathVariable String directoryId) {
        List<WrappedProvider> providers = getProviders(nationalId, directoryId);

        if (providers == null) {
            throw new ResourceNotFoundException();
        } else {
            return LiteWrappedProvider.valueOf(providers);
        }

    }

    public List<WrappedProvider> getProviders(String nationalId, String directoryId) {
//        String httpAddress = "http://zhrisproject.hitrac.co.zw:9094/CSD/csr/" + directoryId + "/careServicesRequest";
        String httpAddress = "http://localhost:8984/CSD/csr/" + directoryId + "/careServicesRequest";

        List<WrappedProvider> wrappedProviders = ProviderFinder.getProviderFromAllDirectories(nationalId, httpAddress);
        return wrappedProviders;
    }

}
