### Following assumptions have been made while designing this API

1. The liquor bars and shops run according to the rules laid down by respective local governments, and may differ from region to region. I created this API adhering to the rules laid down by the local state government of Maharashtra in India. Hence, this API may not be applicable to everyone's use-cases.</br>

2. Each brand can be distributed only by a single distributor. However, single distributor can supply mutliple brands.</br>

3. The brand `status` maybe `false`. This is when you don't intend to buy that brand from the distributor in the near future, either because you see that brand's sales are going down, or you already have a lot. You can query the brand again if you want to see how many bottles are left in the stock and if you want to make the brand active again, you simply add the purchase, and the brand becomes automatically active.</br>

4. While creating the restAPI, I didn't use local database. Instead, I made use of 'remotemysql.com' which provides online database for development and learning use. However, using local database will not be a challenge as you would only update the db values in `db-hibernate.properties`</br>

5. When you add an entry to `Purchase` entity using HTTP `POST` (see `TO-DO.md`), business logic should be such that it updates the `Stock` entity as well. I have not mapped `Stock` entity with `Purchase` entity because, manual modifications might be done to `Stock` using `PUT` to update the stocks after a particular day's sale.

