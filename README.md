# spectrum-rewards
Sample Spring Boot 3 Application - Shopping Rewards 

This is a sample Spring Boot 3 Web application that stores purchase history and calculates
rewards given to the customer for their purchases.

### Rewards Calculation

A customer receives 1 reward pt for every dollar spent between $50 - $100 per transaction
plus 2 reward points for every dollar spent over $100 for the same transaction.
(e.g $120 purchase = 1x$50 + 2X$20 = 90 points)


## Application Features

* Spring Boot 3 - Webflux (rather than WebMVC)
* Spring Data JPA
* H2 in-memory DB for persistence
* Developed using Azul Open JDK 17
* Maven 3.8.4
* Open API v3 Documentation (formly known as swagger)

## Outstanding Application TODO's
    - Application API currently does not provide POST, PUT or DELETE API. 
        (NOTE: All data is loaded to H2 in-memory on application start)
    - More unti tests
    - API validation
    - Error and exception handling

## Application start-up and Usage instructions

1) Clone repository
2) Open terminal and navigate to project root directory
3) Execute the following command to start application: 'mvn springboot:run'
4) API Docs: http://localhost:8080/webjars/swagger-ui/index.html
    * Transaction API
      - /transaction/list - returns all transactions
      - /transaction/{transactionId} - return single transaction by 'transactionId'
    * Customer API
      - /customer/list - returns all customers
    * Product API
      - /product/list - returns all products
    * Rewards API
      - /rewards/{customerId} - returns last 30 days reward information for customer by 'customerId'