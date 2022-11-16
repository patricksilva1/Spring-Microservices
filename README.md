# Spring-Microservices
Microservices with Spring Boot.

>Microservice architectures are the ‘new normal’. Building small, self-contained, ready to run applications can bring great flexibility and added resilience to your code. Spring Boot’s many purpose-built features make it easy to build and run your microservices in production at scale.

## What are Microservices?
> Microservices are a modern approach to software whereby application code is delivered in small, manageable pieces, independent of others.

## Why build Microservices?
> Their small scale and relative isolation can lead to many additional benefits, such as easier maintenance, improved productivity, greater fault tolerance, better business alignment, and more.

## Microservices with Spring Boot:
> With Spring Boot, your microservices can start small and iterate fast. That’s why it has become the de facto standard for Java™ microservices.

### Microservice Example:
![Microservices](https://raw.githubusercontent.com/patricksilva1/Spring-Microservices/perf/architecture/Microservices.png)

### With DB:
![Microservices2](https://raw.githubusercontent.com/patricksilva1/Spring-Microservices/perf/architecture/Microservices2.png)

### How our architecture will look:
![Microservices3](https://raw.githubusercontent.com/patricksilva1/Spring-Microservices/perf/architecture/Microservices3.png)

I will add more MS later for the MongoDB connection.

## How to Run and Details:
> This was built with JDK 19.

> You always need to start the config-server first, then Eureka-server and then the api-gateway. Because eureka is our discovery service and the configuration server is our server that will provide us with the ports
 
#### Discovery Service
> Name: Eureka-server; 
>
> Running at Port: 9010

#### Gateway Service
> Name: Api-Gateway;
> 
>  Running at Port: 9011

#### Microservices:
> MS1 = MS-People-Controller
>
> server.port = 0 (Eureka will decide the port)

> MS2 = MS-Animals-Controller
>
> server.port = 0 (Eureka will decide the port)

#### How to search 
  
for example: 

> localhost:9011/ms-people-controller/api/people/status 