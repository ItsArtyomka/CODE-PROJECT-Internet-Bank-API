This is the **final project** that has a purpose of being kind of like a dissertation to complete my Java Developer Course.
This is a great project that will go into my cool portfolio _:)_

What makes this project stand out is that it will help develop the proficiency in creating a REST API project.
It utilizes RESTful operation in the form of methods that process data from a structured SQL database.
Those methods will work with SQL database, then the collected data will be processed and outputted in the form of JSON.

The project itself and the code is quite cool as well. The code is written in the Java 17.
For the dependencies management I choose to use Gradle because I use Maven quite a lot and I want to learn how to use gradle again. I have also added a few dependencies that I think will be useful, which includes:
* PostgreSQL Driver
* Lombok
* Spring Web
* JUnit
* Testcontainers

Some of those dependencies have been used in the past in other projects or what not.
However, the Testcontainers, Lombok, and JUnit are dependencies that I want to get better at.

---

**TASK**: Realize a REST API for an Internet Bank that is used to deal with financial operations.

List of the operations that will be realized:
- Find out the person's balance.
- Withdraw of X amount from the account.
- Balance top-up.
- History of bank's financial operations in a period of time.
- Transfer X amount to another person.
  The Answer will be in the form of a JSON.

So-called "Operations API" thus will have these functions:
* getBalance(ID)
* takeMoney(ID, SUM)
* putMoney(ID, SUM)
* getOperationList(ID, START_DATE, END_DATE)
* transferMoney(ID, RECEIVER_ID, SUM)



Useful Research Links:
* [Building RESTful APIs Tutorial](https://medium.com/javarevisited/building-restful-apis-in-java-a-step-by-step-tutorial-e1b9b2d3e6ab)
* [Declaring Dependencies](https://docs.gradle.org/current/userguide/declaring_dependencies.html)
* Working with PostgreSQL in Java:
  * https://stackabuse.com/working-with-postgresql-in-java/
  * https://www.postgresqltutorial.com/postgresql-jdbc/
  * https://www.sqliz.com/posts/java-basic-postgresql/