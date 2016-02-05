

    HOME
    COMPANY
    PROJECTS
    BLOG
    CONTACT US
    GRAIN FRAMEWORK

    SysGears Blog Posts by Oleg Yermolaiev 

Building REST service with Scala

Posted by: Oleg Yermolaiev
August 01, 2013
Rest
Scala
Spray

Enterprise application might be developed using a variety of architectural styles. And REST is one of the most powerful of them. It allows us to build simple, scalable, highly productive APIs with independent components on the basis of widespread standards like HTTP, MIME etc, engaging their true potential.

Let's discuss how to create a lightweight, but full-featured RESTful service from scratch.

Consider building REST [1] service that doesn't contain any complicated functionality, but provide basic CRUD operations and have following HTTP endpoints as an API:

    POST /customer/ to create Customer.
    GET /customer/<id>/ to retrieve specific Customer.
    PUT /customer/<id>/ to update specific Customer.
    DELETE /customer/<id>/ to delete specific Customer.
    GET /customer/ to search for Customers with specific parameters.

Technology stack

Scala was chosen as the foundation for the REST service we are going to implement. On the Scala website [2] it is described as a "general purpose programming language designed to express common programming patterns in a concise, elegant and type-safe way. Also, it smoothly integrates features of object-oriented and functional languages."

Despite the fact that Scala is a relatively new language and may have some drawbacks, there are several attractive elements, that made it not just an "another new programming language":

    Operating on the JVM. It is known fact that Java is de facto the most popular programming language for enterprise. Many libraries are written in Java. A variety of tools are designed for JVM. Environments have been stable for years. It can be rather risky to change the entire programming stack even if this step may provide apparent benefits. But Scala has a great interoperability with existing Java code because it still operates on the JVM, has compatible byte code and allows Scala applications to use most of the JVM libraries. Furthermore, developers are able to apply their existing Java skills after migration. Therefore, Scala could be integrated into enterprise infrastructure quite smoothly.
    Functional programming. Except that Scala is a pure object-oriented language it provides syntactic sugar for functional programming. Like a pattern matching, anonymous and higher-order functions, carrying, immutable collections, etc.
    Concise and powerful syntax. Code size is reduced significantly compared to an equivalent application written in Java. This may improve development performance: less key-strokes to make, easier code review and testing. Moreover, many features like function passing and type inference can reduce syntactic overhead.
    Static typing. Scala is equipped with a rich and balanced type system. It provides compile time constraints that could help to avoid certain erroneous scenarios. On the other hand, a local type inference mechanism allows developers not to annotate the program with redundant type information.

The following software was also used:

    SBT (Simple Build Tool) - Build tool for Scala and Java projects. Maven or Gradle with appropriate Scala plug-ins can be used as well, however, SBT became de facto the number one build tool for Scala. It is easy-to-use but quite powerful utility. [3]
    Akka - Asynchronous event-driven middleware framework implemented in Scala, for building high performance and reliable distributed applications. Akka decouples business logic from low-level mechanisms such as threads, locks and non-blocking IO. [4]
    Spray - Scala framework for building RESTful web services on top of Akka: lightweight, asynchronous, non-blocking, actor-based, modular, testable. [5]
    Slick - Database query and access library for Scala. It provides a toolkit to work with stored data almost as using Scala collections. Features an extensible query compiler which can generate code for different backends. [6]
    MySQL - Well-known open-source RDBMS. [7]
    Lift-json - Parsing and formatting utilities library for JSON. [8]
    Logback - Fast and stable logging utility. Considered as a successor to the log4j project. Natively implements the SLF4J API. [9]

Build configuration

Let's start with build configuration for application. The file called build.sbt with the following content should be placed to the root directory of application example. Link to the complete source code repository is given at the end of this article.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22

	

name := "rest"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
    "io.spray" % "spray-can" % "1.1-M8",
    "io.spray" % "spray-http" % "1.1-M8",
    "io.spray" % "spray-routing" % "1.1-M8",
    "com.typesafe.akka" %% "akka-actor" % "2.1.4",
    "com.typesafe.akka" %% "akka-slf4j" % "2.1.4",
    "com.typesafe.slick" %% "slick" % "1.0.1",
    "mysql" % "mysql-connector-java" % "5.1.25",
    "net.liftweb" %% "lift-json" % "2.5.1",
    "ch.qos.logback" % "logback-classic" % "1.0.13"
)

resolvers ++= Seq(
    "Spray repository" at "http://repo.spray.io",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

It is an example of build definition file for SBT. Application name, version and target version of Scala are specified at the top of the file. Managed dependencies can be added by simply listing them in the libraryDependencies setting. Dependency declaration can look like this:

libraryDependencies += "groupID" % "artifactID" % "revision"

It is allowed to add a list of dependencies at once, like in build.sbt example above.

SBT uses the standard Maven2 repository by default. However, additional repositories could be added using the following pattern:

resolvers += "name" at "location"

See resolvers setting in build.sbt example above.

In addition to this, project build definition might be extended by using plugins. They add new settings that could be new SBT tasks. For example, let's add sbt-idea [10] plugin to be able to generate IntelliJ IDEA project files (with gen-idea task) and sbt-assembly plugin [11] to be able to build assembly jar for the project (using assembly task). To make them available in the project, create plugins.sbt file (the name of *.sbt files doesn't matter, they're called build.sbt or plugins.sbt just by convention) in the /project subdirectory with the following content:

1
2
3
4
5
6
7
8

	

resolvers ++= Seq(
    "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
    "Sonatype releases"  at "https://oss.sonatype.org/content/repositories/releases/"
)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.0-SNAPSHOT")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.0")

For further information on using SBT, please, refer to the documentation. [12]

Before focusing on service implementation consider the common application structure. Scala sources should be placed in /src/main/scala directory. Resources directory is /src/main/resources, various configuration files should be placed there by default. /src/test/scala and /src/test/resources should be used to store test sources/configs.
Application configuration

All required configuration settings are stored in Configuration.scala trait and retrieved from application.conf file at application startup. It is placed in /src/main/resources directory and contains most important settings:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17

	

akka {
  loglevel = DEBUG
  event-handlers = ["akka.event.slf4j.Slf4jEventHandler"]
}

service {
    host = "localhost"
    port = 8080
}

db {
    host = "localhost"
    port = 3306
    name = "rest"
    user = "root"
    password = null
}

Service-related settings are grouped in service entry and hold host/port of application. Host/port of database server as well as database name and credentials are grouped in db configuration entry. Basic configuration of Akka actors logging is also provided in application.conf file. You can find more settings for Akka and Spray with their default values in the reference.conf files placed in corresponding dependency jars, assembly jar or in the documentation.

Values are being retrieved from config using the following code:

1
2
3
4
5
6
7
8
9

	

  /** Application config object. */
  val config = ConfigFactory.load()
  ...
  /** Port to start service on. */
  lazy val servicePort = Try(config.getInt("service.port")).getOrElse(8080)
  ...
  /** User name used to access database. */
  lazy val dbUser = Try(config.getString("db.user")).toOption.orNull
  ...

Logback configuration file (logback.xml) is placed into the same directory and looks like this:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16

	

<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <target>System.out</target>
        <encoder>
            <pattern>
                %date{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{1} - %msg%n
            </pattern>
        </encoder>
    </appender>
    <logger name="akka" level="INFO"/>
    <logger name="scala.slick" level="INFO"/>
    <root level="DEBUG">
        <appender-ref ref="CONSOLE"/>
    </root>
</configuration>

Refer to Logback documentation for details.[13]

Logging can be enabled by mixing in akka.event.slf4j.SLF4JLogging trait wherever you need it. Then methods of inherited instance log of available SLF4J logger (powered by Logback in this application) might be used.
Domain Model

MySQL database with customers table is used as a data source. Table contains the following fields:

    id (BIGINT, PRIMARY KEY) - Unique id of the Customer.
    first_name (VARCHAR) - Customer's first name.
    last_name (VARCHAR) - Customer's last name.
    birthday (DATE) - Customer's date of birth. Could be NULL.

Now let's discuss implementing a service logic. First of all, create domain class for Customer entity as a Scala case class that should contain all fields of the customers table:

1
2
3
4

	

case class Customer(id: Option[Long],
                    firstName: String,
                    lastName: String,
                    birthday: Option[java.util.Date])

This example application uses Slick's lifted embedding. It is the standard API for type-safe queries and updates in Slick.[14] In order to use it, Slick's Table objects for database tables should be defined. It is a mapped Table object Customers for MySQL table customers . It uses a custom type Customer for its projection by adding a bi-directional mapping. Default projection is defined as "*" method; mapping is set through "<>" one.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23

	

import scala.slick.driver.MySQLDriver.simple._

object Customers extends Table[Customer]("customers") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def birthday = column[java.util.Date]("birthday", O.Nullable)

  def * = id.? ~ firstName ~ lastName ~ birthday.? <> (Customer, Customer.unapply _)

  implicit val dateTypeMapper = MappedTypeMapper.base[java.util.Date, java.sql.Date](
  {
    ud => new java.sql.Date(ud.getTime)
  }, {
    sd => new java.util.Date(sd.getTime)
  })

  val findById = for {
    id <- Parameters[Long]
    c <- this if c.id is id
  } yield c
}

All the table columns are defined as a def through the column method with proper Scala type and column name for database. In addition to this, several column options are specified after column name parameter. They're available through the Tables' O object. Next settings are used in the example:

    PrimaryKey - Mark the column as a (non-compound) primary key.
    AutoInc - Mark the column as an auto-incrementing key.
    Nullable - Explicitly mark the column as a nullable (otherwise, Option[T] type could be defined to enable nullability).

An implicit dateTypeMapper was added due to default date mapping limitations. Slick supports only java.sql._ dates out of the box, but java.util.Date type is used to define birthday property of Customer objects.

findById is a Slick's Query Template - parametrized query. A template works like a function that takes some parameters and returns a Query for them except that template is more efficient, because it doesn't require complete query recompilation at each run.
Data Access Layer

Since domain model is defined, we can focus on main points of DAL implementation.

Create Database object which specifies how to connect to the MySQL database.

1
2

	

val db = Database.forURL(url = "jdbc:mysql://%s:%d/%s".format(dbHost, dbPort, dbName),
    user = dbUser, password = dbPassword, driver = "com.mysql.jdbc.Driver")

After that, create table customers. DDL statements can be generated with ddl method of Customers table object and executed with create and drop ones. It looks strange but Slick can't generate SQL code to check whether table is already exists. However, it is quite easy to bypass this restriction using table's metadata. Code snippet below shows the most suitable solution for this case. Also notice that all database-related code is running within session (or transaction).

1
2
3
4
5

	

db.withSession {
  if (MTable.getTables("customers").list().isEmpty) {
    Customers.ddl.create
  }
}

There are several methods of Customer DAO that are responsible for interactions with database. Specifically, Customer entities could be:

    created (with returning an actual record id):

1
2
3

	

db.withSession {
  Customers returning Customers.id insert customer
}

    updated by id with new Customer entity:

1
2
3

	

db.withSession {
  Customers.where(_.id === id) update customer.copy(id = Some(id))
}

    deleted by id:

1
2
3

	

db.withSession{
  Customers.where(_.id === id) delete
}

    retrieved by id:

1
2
3

	

db.withSession {
  Customers.findById(id).firstOption
}

    retrieved using specified search parameters. List of customers that match given parameters returned.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15

	

db.withSession {
  val query = for {
    customer <- Customers if {
    Seq(
      params.firstName.map(customer.firstName is _),
      params.lastName.map(customer.lastName is _),
      params.birthday.map(customer.birthday is _)
    ).flatten match {
      case Nil => ConstColumn.TRUE
      case seq => seq.reduce(_ && _)
    }
  }} yield customer

  query.run
}

HTTP Layer

Spray framework is used for building REST/HTTP-based integration layer which is responsible for serving HTTP requests. You can review Spray documentation and examples ([5],[15]) to understand basics.

REST service is running inside an Akka actor. But service logic (with a Spray route structure) is implemented separately. This fact allows us to test its logic independently from an actor behavior.

Let's consider complete Spray route structure (list of available endpoints is described at the beginning of an article).

1
2

	

val rest = respondWithMediaType(MediaTypes.`application/json`) {
...

Route definition starts with an directive that sets response media type to application/json for all inner routes. It's only applicable for success responses, not for rejections.

The following code shows route structure for POST (create new customer) and GET (search for customers with specified parameters) endpoints.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29

	

...
path("customer") {
  post {
    entity(Unmarshaller(MediaTypes.`application/json`) {
      case httpEntity: HttpEntity =>
        read[Customer](httpEntity.asString(HttpCharsets.`UTF-8`))
    }) {
      customer: Customer =>
        ctx: RequestContext =>
          handleRequest(ctx, StatusCodes.Created) {
            log.debug("Creating customer: %s".format(customer))
            customerService.create(customer)
          }
    }
  } ~
    get {
      parameters('firstName.as[String] ?, 'lastName.as[String] ?, 'birthday.as[Date] ?).
        as(CustomerSearchParameters) {
          searchParameters: CustomerSearchParameters => {
            ctx: RequestContext =>
              handleRequest(ctx) {
                log.debug("Searching for customers with parameters: %s".format(searchParameters))
                customerService.search(searchParameters)
              }
          }
        }
    }
} ~
...

On POST request to the /customer/, the content of request payload is deserialized to Customer entity. Lift-json library is used to provide JSON marshalling/unmarshalling functionality.

If any failure detected, request will be rejected with an error description. Rejection handler is presented below. It is a custom JSON wrapper that stores rejection details in "error" field. This is a simple example, but much more complicated logic could be implemented here. For instance, it may have different behavior for several rejection types.

1
2
3
4
5
6
7
8
9

	

implicit val customRejectionHandler = RejectionHandler {
  case rejections => mapHttpResponse {
    response =>
      response.withEntity(HttpEntity(ContentType(MediaTypes.`application/json`),
        write(Map("error" -> response.entity.asString))))
  } {
    RejectionHandler.Default(rejections)
  }
}

But back to the route structure definition. For GET /customer/ endpoint, the most interesting thing is parameters directive. It checks existence of query parameters in the request and extracts their values into Tuple or case class. Each value could be passed as a String or converted to the specified type. Parameter can be made optional by appending ? to the matcher. In the provided example, optional request parameters firstName, lastName and birthday compose a search parameters entity, which is passed to DAL to build proper search query. Implicit conversions are used to build date in proper format from birthday request parameter value.

All remaining endpoints extract Customer id parameter value contained in the request URI. It is handled by Spray's LongNumber directive and passed to inner routes. PUT /customer/<id>/ endpoint (update Customer with new entity by given id) looks similar to POST /customer/ endpoint. It requires Customer JSON entity in the request payload, deserializes it into Customer case class and sends it to update DAO function together with an id of the Customer to be updated. Structure of GET /customer/<id>/ (retrieve by id) and DELETE /customer/<id>/ (delete by id) endpoints is pretty simple: they only pass Customer id value to the corresponding DAO function, that manages Customer retrieving or removing functionality.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32

	

...
path("customer" / LongNumber) {
customerId =>
  put {
    entity(Unmarshaller(MediaTypes.`application/json`) {
      case httpEntity: HttpEntity =>
        read[Customer](httpEntity.asString(HttpCharsets.`UTF-8`))
    }) {
      customer: Customer =>
        ctx: RequestContext =>
          handleRequest(ctx) {
            log.debug("Updating customer with id %d: %s".format(customerId, customer))
            customerService.update(customerId, customer)
          }
    }
  } ~
    delete {
      ctx: RequestContext =>
        handleRequest(ctx) {
          log.debug("Deleting customer with id %d".format(customerId))
          customerService.delete(customerId)
        }
    } ~
    get {
      ctx: RequestContext =>
        handleRequest(ctx) {
          log.debug("Retrieving customer with id %d".format(customerId))
          customerService.get(customerId)
        }
    }
}
...

All responses are generated in handleRequest method of RestService trait. Service responds with 2xx status code and entity JSON in the response payload if operation completed without any troubles. Otherwise, it returns JSON with error description and one of 4xx or 5xx HTTP response codes.

There are abilities to add caching, authenticating and validation via other Spray directives. You can also compose more complicated routes, add new rejection handlers and implicit/explicit conversions to serialize/deserialize data, etc. It depends only on your needs. Moreover, Spray's route structure looks self-documenting and scalable enough to provide any changes in less time and without much overhead.
Running the Service

Application startup code does not seem too complicated:

1
2
3
4
5
6
7
8
9
10
11

	

object Boot extends App with Configuration {

  // create an actor system for application
  implicit val system = ActorSystem("rest-service-example")

  // create and start rest service actor
  val restService = system.actorOf(Props[RestServiceActor], "rest-endpoint")

  // start HTTP server with rest service actor as a handler
  IO(Http) ! Http.Bind(restService, serviceHost, servicePort)
}

Trait App is mixed to turn Boot object into executable program whereas Configuration trait provide access to the startup settings like host name and port number to run on.

Notice, that MySQL database for the service should be created manually before running the application. By default its name is rest, but you can override this value with db.name entry of application.conf file, as well as user name and password to access it with db.user and db.password settings. Database user must have enough rights to be able to create new tables and perform CRUD operations.

You need SBT installed in your system to build this example. For SBT installation instructions, please, refer to SBT setup page [16]. If it has already installed, just execute the following command to run the example of rest service

1

	

$ sbt run

... from the root directory of the project.

Or build an assembly jar with

1

	

$ sbt assembly

... and then run

1

	

$ java -jar <path-to-assembly.jar>

Once application is launched we can use curl utility to test it:

When creating customer with:

1
2

	

$ curl -v -X POST http://localhost:8080/customer -H "Content-Type: application/json" -d '{"firstName":
"First", "lastName":"Last", "birthday":"1990-01-01"}'

... the server returns HTTP 201 response with following JSON payload:

1

	

{"id":1,"firstName":"First","lastName":"Last","birthday":"1990-01-01"}

When trying to get it by id:

1

	

$ curl -v -X GET http://localhost:8080/customer/1

... service returns HTTP 200 with customer entity with id=1 in JSON payload:

1

	

{"id":1,"firstName":"First","lastName":"Last","birthday":"1990-01-01"}

but, if we request it with id for which customer doesn't exist:

1

	

$ curl -v -X GET http://localhost:8080/customer/1000

... service returns HTTP 404 with the following error description in JSON payload:

1

	

{"error":"Customer with id=1000 does not exist"}

Other endpoints could be checked in a similar way.

All sources are available on GitHub repository.

  1. R.T. Fielding's dissertation "Architectural Styles and the Design of Network-based Software Architectures", Chapter 5 (REST): http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm ⇑
  2. Scala official website: http://www.scala-lang.org/ ⇑
  3. SBT project website: http://www.scala-sbt.org/ ⇑
  4. Akka project website: http://akka.io ⇑
  5. Spray project website: http://spray.io ⇑
  6. Slick project website: http://slick.typesafe.com/ ⇑
  7. MySQL official website: http://www.mysql.com/ ⇑
  8. Lift-json library on GitHub: https://github.com/lift/framework/tree/master/core/json ⇑
  9. Logback project website: http://logback.qos.ch/ ⇑
10. SBT-idea plugin on GitHub: https://github.com/mpeltonen/sbt-idea ⇑
11. SBT-assembly plugin on GitHub: https://github.com/sbt/sbt-assembly ⇑
12. SBT documentation: http://scala-sbt.org/release/docs/index.html ⇑
13. Logback documentation: http://logback.qos.ch/documentation.html ⇑
14. Slick lifted embedding documentation page: http://slick.typesafe.com/doc/1.0.1/lifted-embedding.html ⇑
15. Spray Examples: https://github.com/spray/spray/tree/release/1.1/examples ⇑
16. SBT installation instructions: http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html ⇑

Hope you find this helpful,
Oleg Yermolaiev

Scala Developer & Technical Lead

Have a question, cooperation offer or something to add?
Don't hesitate to contact me.
Tweet
inShare12
You also may like:
Managing configuration of a distributed system with Apache ZooKeeper

by Oleg Yermolaiev

Table existence check using Slick

by Oleg Yermolaiev

How to update entire database record using Slick

by Oleg Yermolaiev

Comments

    Oleg Yermolaiev

    Scala Developer & Technical Lead

Stay Connected

Join our mailing list and receive the latest blog posts.
_
Copyright © 2010 - 2016 SysGears. All rights reserved.
This site is powered by Grain
ABOUT US

SysGears is a software development company focused on building custom web applications. We provide full-cycle development services, starting from research and prototyping, design and implementation, testing and optimization, and to deployment and maintenance. We are a team of Scala, Groovy and JavaScript developers, and use Play, Grails and AngularJS frameworks to create software that meets high availability and robustness requirements.

Also, being truly passionate about our work, we devote a part of our efforts to improve software technology by creating open source products and tools such as the Grain Framework.
CONTACT

    Sichovykh Striltsiv,
    Dnipropetrovsk, Ukraine
    info@sysgears.com
    sysgears

Head office

    2 Plataion, Paphos, Cyprus
    +357 96 744 850

LATEST TWEETS

    about 29 days ago
    Moving a page element without affecting its scope in AngularJS sysgears.com/articles/movin… #angularjs pic.twitter.com/aeCj91et66
    about 42 days ago
    Thread synchronization in Grails application using Hazelcast sysgears.com/articles/threa… #Grails #Hazelcast pic.twitter.com/zxaA1L4OX5

To Top
