package wallet.domain;

import wallet.domain.CouponPurchased;
import wallet.external.PointService;
import wallet.external.UseCommand;
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

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        UseCommand useCommand = new UseCommand();
        useCommand.setAmount(getPrice());

        PointService pointService = CouponApplication.applicationContext.getBean(PointService.class);
        pointService.use(getBuyer(), useCommand);

        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

    
    }



    public void cancelCoupon(){


        setStatus("CANCELLED");

        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();
    }



}
