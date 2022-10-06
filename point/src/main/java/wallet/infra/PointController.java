package wallet.infra;
import wallet.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/points")
@Transactional
public class PointController {
    @Autowired
    PointRepository pointRepository;



    @RequestMapping(value = "points/{id}/use",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Point use(@PathVariable(value = "id") Long id, @RequestBody UseCommand useCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /point/use  called #####");
            Optional<Point> optionalPoint = pointRepository.findById(id);
            
            optionalPoint.orElseThrow(()-> new Exception("No Entity Found"));
            Point point = optionalPoint.get();
            point.use(useCommand);
            
            pointRepository.save(point);
            return point;
            
    }
    



}
