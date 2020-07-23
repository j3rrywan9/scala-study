# Spark

## RDD Programming Guide

### Overview

At a high level, every Spark application consists of a *driver program* that runs the user's `main` function and executes various *parallel operations* on a cluster.
The main abstraction Spark provides is a *resilient distributed dataset* (RDD), which is a collection of elements partitioned across the nodes of the cluster that can be operated on in parallel.
RDDs are created by starting with a file in the Hadoop file system (or any other Hadoop-supported file system), or an existing Scala collection in the driver program, and transforming it.
Users may also ask Spark to persist an RDD in memory, allowing it to be reused efficiently across parallel operations.
Finally, RDDs automatically recover from node failures.

### Linking with Spark

Spark 3.0.0 is built and distributed to work with Scala 2.12 by default.
(Spark can be built to work with other versions of Scala, too.)
To write applications in Scala, you will need to use a compatible Scala version (e.g. 2.11.X).

To write a Spark application, you need to add a Maven dependency on Spark.
Spark is available through Maven Central at:
```
groupId = org.apache.spark
artifactId = spark-core_2.12
version = 3.0.0
```
In addition, if you wish to access an HDFS cluster, you need to add a dependency on `hadoop-client` for your version of HDFS.
```
groupId = org.apache.hadoop
artifactId = hadoop-client
version = <your-hdfs-version>
```

### Initializing Spark

The first thing a Spark program must do is to create a `SparkContext` object, which tells Spark how to access a cluster.
To create a `SparkContext` you first need to build a `SparkConf` object that contains information about your application.

Only one `SparkContext` may be active per JVM.
You must `stop()` the active `SparkContext` before creating a new one.
```scala
val conf = new SparkConf().setAppName(appName).setMaster(master)
new SparkContext(conf)
```

### Using the Shell

In the Spark shell, a special interpreter-aware `SparkContext` is already created for you, in the variable called `sc`.
Making your own `SparkContext` will not work.

### RDDs

Spark revolves around the concept of a *resilient distributed dataset* (RDD), which is a fault-tolerant collection of elements that can be operated on in parallel.
There are two ways to create RDDs: *parallelizing* an existing collection in your driver program, or referencing a dataset in an external storage system, such as a shared filesystem, HDFS, HBase, or any data source offering a Hadoop InputFormat.

#### Parallelized Collections

#### External Datasets

### RDD Operations

RDDs support two types of operations: *transformations*, which create a new dataset from an existing one, and *actions*, which return a value to the driver program after running a computation on the dataset.
For example, `map` is a transformation that passes each dataset element through a function and returns a new RDD representing the results.
On the other hand, `reduce` is an action that aggregates all the elements of the RDD using some function and returns the final result to the driver program (although there is also a parallel `reduceByKey` that returns a distributed dataset).

All transformations in Spark are *lazy*, in that they do not compute their results right away.
Instead, they just remember the transformations applied to some base dataset (e.g. a file).
The transformations are only computed when an action requires a result to be returned to the driver program.
This design enables Spark to run more efficiently.
For example, we can realize that a dataset created through `map` will be used in a `reduce` and return only the result of the `reduce` to the driver, rather than the larger mapped dataset.

By default, each transformed RDD may be recomputed each time you run an action on it.
However, you may also persist an RDD in memory using the `persist` (or `cache`) method, in which case Spark will keep the elements around on the cluster for much faster access the next time you query it.
There is also support for persisting RDDs on disk, or replicated across multiple nodes.

#### Basics

#### Passing Functions to Spark

#### Understanding closures

#### Working with Key-Value Pairs

## Spark SQL, DataFrames and Datasets Guide

Spark SQL is a Spark module for structured data processing.
Unlike the basic Spark RDD API, the interfaces provided by Spark SQL provide Spark with more information about the structure of both the data and the computation being performed.
Internally, Spark SQL uses this extra information to perform extra optimizations.
There are several ways to interact with Spark SQL including SQL and the Dataset API.
When computing a result, the same execution engine is used, independent of which API/language you are using to express the computation.
This unification means that developers can easily switch back and forth between different APIs based on which provides the most natural way to express a given transformation.

All of the examples on this page use sample data included in the Spark distribution and can be run in the `spark-shell`, `pyspark` shell, or `sparkR` shell.

### SQL

### Datasets and DataFrames

A Dataset is a distributed collection of data.
Dataset is a new interface added in Spark 1.6 that provides the benefits of RDDs (strong typing, ability to use powerful lambda functions) with the benefits of Spark SQL's optimized execution engine.
A Dataset can be constructed from JVM objects and then manipulated using functional transformations (`map`, `flatMap`, `filter`, etc.).
The Dataset API is available in Scala and Java.
Python does not have the support for the Dataset API.
But due to Python's dynamic nature, many of the benefits of the Dataset API are already available (i.e. you can access the field of a row by name naturally row.columnName).
The case for R is similar.

A DataFrame is a *Dataset* organized into named columns.
It is conceptually equivalent to a table in a relational database or a data frame in R/Python, but with richer optimizations under the hood.
DataFrames can be constructed from a wide array of sources such as: structured data files, tables in Hive, external databases, or existing RDDs.
The DataFrame API is available in Scala, Java, Python, and R.
In Scala and Java, a DataFrame is represented by a Dataset of Rows.
In the Scala API, DataFrame is simply a type alias of `Dataset[Row]`.
While, in Java API, users need to use `Dataset<Row>` to represent a DataFrame.

Throughout this document, we will often refer to Scala/Java Datasets of Rows as DataFrames.

### Starting Point: `SparkSession`

The entry point into all functionality in Spark is the SparkSession class.
To create a basic `SparkSession`, just use `SparkSession.builder()`:

### Creating DataFrames

### Creating Datasets

Datasets are similar to RDDs, however, instead of using Java serialization or Kryo they use a specialized Encoder to serialize the objects for processing or transmitting over the network.
While both encoders and standard serialization are responsible for turning an object into bytes, encoders are code generated dynamically and use a format that allows Spark to perform many operations like filtering, sorting and hashing without deserializing the bytes back into an object.

### Interoperating with RDDs
