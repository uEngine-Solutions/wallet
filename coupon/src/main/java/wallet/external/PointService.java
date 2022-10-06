package wallet.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "point", url = "${api.url.point}")
public interface PointService {
<<<<<<< HEAD
    @RequestMapping(method= RequestMethod.PUT, path="/points/{holder}/use")
    public void use(@PathVariable("holder") String holder, @RequestBody UseCommand useCommand );
=======
    @RequestMapping(method= RequestMethod.GET, path="/points/{id}")
    public Point getPoint(@PathVariable("id") Long id);
>>>>>>> origin/template
}

