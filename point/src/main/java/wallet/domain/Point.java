package wallet.domain;

import wallet.domain.PointsDeducted;
import wallet.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Point_table")
@Data

public class Point  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String holder;
    
    
    
    
    
    private Long amount;

    @PostPersist
    public void onPostPersist(){


        PointsDeducted pointsDeducted = new PointsDeducted(this);
        pointsDeducted.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }



    public void use(UseCommand useCommand){
    }

    public static void usePoint(CouponPurchased couponPurchased){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponPurchased.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }
    public static void compensatePoint(CouponCancelled couponCancelled){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponCancelled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }


}
