package wallet.domain;

import wallet.domain.*;
import wallet.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CouponPurchased extends AbstractEvent {

    private Long id;
    private String buyer;
    private Long price;
    private String name;
}


