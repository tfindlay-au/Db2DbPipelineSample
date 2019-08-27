# Db 2 Db Pipeline Sample

### Objective
This project will provide an example of transferring data from a RDBMS to and RDBMS via Apache Spark.

In this sample, we will use a Postgres DB as the source and the target.
We will use a JDBC connection with Apache Spark and use SQL to extract the data and write it back in.

The transformation logic will be contained in Scala functions which can be tested and version controlled.

This program should generate documentation via ScalaDoc to document what is happening.


### Using
This application will be a runnable JAR, alternatively it could be executed as a spark-submit application
```
$ java -jar ...
or
$ spark-submit ...
```

