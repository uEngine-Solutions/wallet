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

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        wallet.external.UseCommand useCommand = new wallet.external.UseCommand();
        // mappings goes here
        CouponApplication.applicationContext.getBean(wallet.external.PointService.class)
            .use(/* get???(), */ useCommand);



        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

<<<<<<< HEAD

=======
>>>>>>> origin/template
    }

    public static CouponRepository repository(){
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(CouponRepository.class);
        return couponRepository;
    }



    public void cancelCoupon(){
<<<<<<< HEAD


        setStatus("CANCELLED");

        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();
=======
        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();

>>>>>>> origin/template
    }



}
