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
// @RequestMapping(value="/coupons")
@Transactional
public class CouponController {
    @Autowired
    CouponRepository couponRepository;




    @RequestMapping(value = "coupons/{id}/cancel-coupon",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Coupon cancelCoupon(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /coupon/cancelCoupon  called #####");
            Optional<Coupon> optionalCoupon = couponRepository.findById(id);
            
            optionalCoupon.orElseThrow(()-> new Exception("No Entity Found"));
            Coupon coupon = optionalCoupon.get();
            coupon.cancelCoupon();
            
            couponRepository.save(coupon);
            return coupon;
            
    }
    



}
