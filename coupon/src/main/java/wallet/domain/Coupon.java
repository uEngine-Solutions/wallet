package wallet.domain;

import wallet.domain.CouponPurchased;
import wallet.domain.CouponCancelled;
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


    }

    public static CouponRepository repository(){
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(CouponRepository.class);
        return couponRepository;
    }



    public void cancelCoupon(){


        setStatus("CANCELLED");

        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();
    }



}
