# wallet

```
http :8082/points holder="jjy" amount=10000
http :8081/coupons price=1000 buyer="jjy"
http :8082/points    # 9000

http PUT :8081/coupons/1/cancel-coupon
http :8082/points    # 10000

```
