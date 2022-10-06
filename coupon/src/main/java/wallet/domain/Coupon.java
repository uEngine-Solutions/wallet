package wallet.domain;

import wallet.domain.CouponPurchased;
import wallet.CouponApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Coupon_table")
@Data

public class Coupon  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String buyer;
    
    
    
    
    
    private Long price;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

        // Get request from Point
        //wallet.external.Point point =
        //    Application.applicationContext.getBean(wallet.external.PointService.class)
        //    .getPoint(/** mapping value needed */);

    }

    public static CouponRepository repository(){
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(CouponRepository.class);
        return couponRepository;
    }



    public void cancelCoupon(){
        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();

    }



}
