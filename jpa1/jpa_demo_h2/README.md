# jpa_demo-h2

Demonstration of a REST service that interfaces with an [H2 database](https://www.h2database.com/)<sup>1</sup>

## Features

* Starts an embedded H2 in-memory database
* Seeds an empty "customer" database table, either with `data.sql` and/or with `CommandLineRunner`
* Provides a web-based H2 console at [localhost:8080/h2-console](localhost:8080/h2-console]),
or at the port specified in `application.properties`

## Configuration

See the following:
* `application.properties` file
* `data.sql` file

## References

* [Configure build.gradle](https://dev.to/baso53/configuring-gradle-and-spring-boot-with-h2-for-local-development-8fp)
* [Launch H2 from a Spring application](https://www.code4copy.com/java/using-h2-db-spring-boot-jpa/)
* [Lombok Plugin](https://plugins.gradle.org/plugin/io.freefair.lombok)
* [Spring Boot Initializr](start.spring.io)

## Noteworthy

* Notice the use of annotations throughout. Think about the role they play.
* Note the use of dependency injection. Can you identify where this pattern is taking place?

## Practice

* Attempt to build a `order` table and relate it to the `customer` table.
* Add additional REST services for querying orders. (Hint: Research @OneToMany and @ManyToOne annotations, and make use of them.)

## Endnotes

1. You do not need to install a separate H2 executable.