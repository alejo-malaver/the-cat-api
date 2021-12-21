# qa-serenity-example

[![gradle](https://img.shields.io/badge/gradle-v7.3.X-yellow.svg)](https://gradle.org/install/)


>A simple Gradle project to test with Java, Serenity && Cucumber.
## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)
* [Java v11](https://www.java.com)


## Installation

We use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow.
If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* ´git clone https://github.com/alejo-malaver/the-cat-api` this repository
##  Executing the tests
the parameter **-Denvironment** can to take values like:
* dev: development environment.
- stg: staging environment.
+ pro: production environment.
By default, the tests will execute the pro environment, generating report in html and executing only the @Timezone tags test cases:
```bash
./gradlew clean test aggregate
```

For specific tags, use the param -Dcucumber.filter.tags with value of tag or tags to execute

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@CatBreeds"
```

The test results will be recorded in the `target/site/serenity` directory, open the index.html file.

The file will detail the results from the latest execution.

To run sonarqube analysis:

```bash
./gradlew sonar -x test
```

A code formatter is included that allows you to sort your code after any change, to use it you can run:
```bash
./gradlew spotlessApply
```

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _stg_ and _pro_, with different starting URLs for each:
```json
environments {
    default {
      base.url = "https://api.thecatapi.com"
    }
    dev {
      base.url = "https://dev.thecatapi.com"
    }
    stg {
      base.url = "https://stg.thecatapi.com"
    }
    pro {
      base.url = "https://api.thecatapi.com"
    }
    
    all {
      listBreeds.path="/v1/breeds"
    }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ ./gradlew test aggregate -Denvironment=pro
```
In the following link you can view the project running locally, so I suggest executing the project locally to validate the real execution times:
[Execution Video](https://youtu.be/SF1BcX9kE5M)
