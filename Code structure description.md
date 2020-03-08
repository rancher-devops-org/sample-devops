### Spring Boot Code Skeleton:

| api        | description                                                  |
| ---------- | ------------------------------------------------------------ |
| api        | User defined API interface, MSI will help you generate API interface based OpenAPI specification definition |
|            |                                                              |
| config     | Save every config there, RestTemplate, Redis, etc.           |
|            |                                                              |
| constant   | Save user defined constant                                   |
|            |                                                              |
| controller | Usually the real API implementation wil be there, you only need to implement the interfances that MSI auto generated |
|            |                                                              |
| dto.mapper | Suggested to use MapStruct for the DTO processing, we provide a sample how to use that, you need to install the application before debugging, it will auto generate the dto implementation classes |
|            |                                                              |
| dto.model  | Define the models that will be used for the DTO here         |
|            |                                                              |
| entity     | Define your DB entities here                                 |
|            |                                                              |
| exception  | MSI provide a general exception, you can just use it like: throw new MSIException() |
|            |                                                              |
| facade     | As microservice has common scenarios that on service will call other microservice internally, so store the client api here |
|            |                                                              |
| model      | Please store the value object or other models here           |
|            |                                                              |
| service    | Server layer code to implement the business logic            |
|            |                                                              |
| util       | Useful utils here                                            |

