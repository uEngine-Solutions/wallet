package wallet.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "point", url = "${api.url.point}")
public interface PointService {
    @RequestMapping(method= RequestMethod.PUT, path="/points/{id}/use")
    public void use(@PathVariable("id") Long id, @RequestBody UseCommand useCommand );
}

