# stock-management-restapi

## Problem Statement that this project aims to solve:</br>
My father owns a bar selling alcohol and liquor beverages. His daily chores involve taking stock of bottles sold of various brands, keeping a track on their quanitities, so that he can order a new lot from the distributors. He also needs to track the payment needed to be done to the distributors, the purchases made from them, and the bills procured. He has already been using an old desktop-software that runs on Windows XP but it is outdated, slow and painful. Taking cue from there, I wondered if I could create something for him, and in the process, get my hand on creating RestAPIs. So here I am! This is work in progress.

I have used the name "eagle" extensively throughout this project in names of packages, request-mappings etc, as it is the name of the bar that my father runs.

## Technologies used:</br>
Hibernate, Spring MVC, Maven, MySQL

## Request URLs
Following are the request URLs for the API methods, sample answers and their description, as to what they do.

1. `GET /eagle/brands`</br>
Returns the details of all the brands available in the bar.

Example:
`GET /eagle/brands`
```
[
    {
        "brandId": 1,
        "brandName": "McDowells Whiskey",
        "distributor": 1,
        "active": true
    },
    {
        "brandId": 2,
        "brandName": "Officer's Choice Blue Whiskey",
        "distributor": 1,
        "active": true
    },
    ...
    ...
]
```

2. `GET /eagle/brand/{brandId}`</br>
Returns the details of a single brand along with the `distributorId` that supplies that brand; request identified by `brandId`.

Example:
`GET /eagle/2`
```
   {
        "brandId": 2,
        "brandName": "Officer's Choice Blue Whiskey",
        "distributor": 1,
        "active": true
   }
```


3. `GET /eagle/distributors`</br>
Returns the details of all the distributors who provide liquor for sale

Example:
`GET /eagle/distributors`
```
[
    {
        "distributorId": 1,
        "distributorName": "Desh Videsh Traders",
        "city": "Akola",
        "zip": 444002,
        "state": "Maharashtra",
        "contactNumber": 9876543210
    },
    {
        "distributorId": 3,
        "distributorName": "Ashok Traders",
        "city": "Nagpur",
        "zip": 440001,
        "state": "Maharashtra",
        "contactNumber": 99887776655
    },
    ...
    ...
]
```

4. `GET /eagle/distributor/{distributorId}`</br>
Returns the details of a single distributor identified by `{distributorId}`

Example:
`GET /eagle/distributor/4`
```
{
    "distributorId": 4,
    "distributorName": "Swami Samarth Wine Distributors",
    "city": "Akola",
    "zip": 444002,
    "state": "Maharashtra",
    "contactNumber": 9876598765
}
```
5. `GET /eagle/categories`</br>
Returns the details of the categories in which all the brands are available. The `quantity` is in mililiters.

Example:
`GET /eagle/categories`
```
[
    {
        "categoryId": 1,
        "categoryName": "Mini",
        "quantity": 90
    },
    {
        "categoryId": 2,
        "categoryName": "Quarter",
        "quantity": 180
    },
    ...
    ...
]    
```

6. `GET /eagle/category/{categoryId}`</br>
Returns the details of a particular `{categoryId}`

Example:
`GET /eagle/category/4`
```
{
    "categoryId": 4,
    "categoryName": "Full",
    "quantity": 720
}
```
7. `GET /eagle/stocks`</br>
Returns all the `quantity` of the bottles in the bar, along with the `brandId`, `categoryId` and `sellingPrice` of that stock.

Example:
`GET /eagle/stocks`
```
[
    {
        "brand": 1,
        "category": 1,
        "sellingPrice": 90,
        "quantity": 30
    },
    {
        "brand": 1,
        "category": 2,
        "sellingPrice": 170,
        "quantity": 100
    },
    {
        "brand": 2,
        "category": 1,
        "sellingPrice": 90,
        "quantity": 50
    },
    ...
    ...
```

8. `GET /eagle/stock/{brandId}`</br>
Returns the stock available for a particluar `{brandId}`

Example:
`GET /eagle/stock/3`
```
[
    {
        "brand": 3,
        "category": 2,
        "sellingPrice": 340,
        "quantity": 50
    }
]
```

9. `GET /eagle/bills`</br>
Returns the details on all the bills procured from the distributors after they have supplied with some stock.

Example:
`GET /eagle/bills`
```
[
    {
        "billId": 1,
        "receiptNumber": 12345,
        "distributor": 1,
        "billPaid": false
    },
    {
        "billId": 2,
        "receiptNumber": 54321,
        "distributor": 3,
        "billPaid": false
    },
    {
        "billId": 3,
        "receiptNumber": 98765,
        "distributor": 4,
        "billPaid": false
    },
    ...
    ...
]
```

10. `GET /eagle/bill/{billId}`</br>
Returns the details of a single bill, identified by `{billId}`

Example:
`GET /eagle/bill/4`
```
{
    "billId": 4,
    "receiptNumber": 56789,
    "distributor": 5,
    "billPaid": false
}
```

11. `GET /eagle/purchase/{billId}`</br>
Returns the details of all the purchase made under a particular bill, identified by  `{billId}`

Example:
`GET /eagle/purchase/1`
```
[
    {
        "bill": 1,
        "brand": 1,
        "category": 1,
        "quantity": 30,
        "purchasePrice": 50
    },
    {
        "bill": 1,
        "brand": 1,
        "category": 2,
        "quantity": 100,
        "purchasePrice": 140
    },
    {
        "bill": 1,
        "brand": 2,
        "category": 1,
        "quantity": 50,
        "purchasePrice": 40
    },
    {
        "bill": 1,
        "brand": 2,
        "category": 2,
        "quantity": 90,
        "purchasePrice": 130
    }
]
```
