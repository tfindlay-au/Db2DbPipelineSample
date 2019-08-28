# Db 2 Db Pipeline Sample

### Objective
This project will provide an example of transferring data from a RDBMS to and RDBMS via Apache Spark.
~~~~
   _____________         _____________
  |             | ----> |             |
  |  Relational |       |  Apache     |
  |   Database  | <---- |  Spark      |
  |_____________|       |_____________|
~~~~

In this sample, we will use a Postgres DB as the source and the target.
We will use a JDBC connection with Apache Spark and use SQL to extract the data and write it back in.

The transformation logic will be contained in Scala functions which can be tested and version controlled.

This program should generate documentation via ScalaDoc to document what is happening.

### Documentation
This project include developer documentation in the code, this can be used by analysts or data scientists to leverage
the transformations in place. This can be generated (in HTML) from source via:
```
$ sbt doc
$ firefox ./target/scala-2.12/api/index.html
```

If configured documentation can be uploaded to a target web server via:
```
$ sbt publish
```

### Building
You can choose between 2 artifacts:
* Fat JAR - This includes all dependencies and is runnable via any JRE
* Stand alone JAR - This needs dependencies to be supplied and might be better used with `spark-submit`
```
# To generate a fat JAR:
$ sbt assembly

# To generate a stand alone JAR:
$ sbt package
```

### Testing
The core objective of unit tests is to validate the correct behaviour of the transformations. This can be done simply
using the `spark-testing-base` framework like so:
```
$ sbt test
```
*Note* : The quality of the tests still relies on good discipline from developers. Poorly written tests do not add much value and can be misleading.

### Using
This application will be a runnable JAR, alternatively it could be executed as a spark-submit application.

Before you get started you will need to start a database, in this case postgres and I would recommend running everything in a docker container like so:
```
$ docker-compose up
```

Alternatively, you can package as a fat JAR (include dependencies) and run with JRE like so:
```
$ sbt assembly
$ java -jar ./target/scala-2.12/Db2DbPipelineSample-assembly-0.1.jar

or via spark-submit

$ sbt package
$ spark-submit ./target/scala-2.12/db2dbpipelinesample_2.12-0.1.jar
```
*Note* : This code is not (yet) compatible with Java > 1.8 due to dependencies with the testing framework. This works fine in the docker container, but may not work on other systems with a newer JRE. 
