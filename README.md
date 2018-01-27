## Math-Expression Calculator 
### Simple console calculator app   
_(Working in Progress)_

_Gradle_ project for a simple console calculator, coded in _Groovy_, initially derived from the example 
presented in the [Diseño Ágil con TDD](http://www.carlosble.com/libro-tdd/) book by [Carlos Blé](http://www.carlosble.com).

The project showcases the layout and coding discipline proposed by [Uncle Bob](http://blog.cleancoder.com/) 
in his great [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) model.

The project layout present these modules:
* *Domain*, is the module containing three layers (shown as packages):
    * *entity*, the business model layer, just entities in this case
    * *usecase*, the use cases layer for this application
    * *service*, the gateway layer with abstract interfaces used by the use cases
* *Double*, module with implementations for the services layer:
    * *FactoryService*, for creating entities
    * *ExpressionParserService*, for parsing math expressions
    * *DataService*, _DAL_(Data Access Layer) mocked service 
* *Detail*, the external layers with implementation and adapters to framework specific:
    * Features a simple MVP console app using the use cases.  
* *Core*, just some common API to other projects