# Spark

## Overview

Apache Spark is a fast and general-purpose cluster computing system.
It provides high-level APIs in Java, Scala, Python and R, and an optimized engine that supports general execution graphs.
It also supports a rich set of higher-level tools including Spark SQL for SQL and structured data processing, MLlib for machine learning, GraphX for graph processing, and Spark Streaming.

## RDD Programming Guide

At a high level, every Spark application consists of a *driver program* that runs the user’s main function and executes various *parallel operations* on a cluster.
The main abstraction Spark provides is a *resilient distributed dataset* (RDD), which is a collection of elements partitioned across the nodes of the cluster that can be operated on in parallel.

### Linking with Spark

Spark 2.2.0 is built and distributed to work with Scala 2.11 by default.
(Spark can be built to work with other versions of Scala, too.)
To write applications in Scala, you will need to use a compatible Scala version (e.g. 2.11.X).

To write a Spark application, you need to add a Maven dependency on Spark.
Spark is available through Maven Central at:
```
groupId = org.apache.spark
artifactId = spark-core_2.11
version = 2.2.0
```

### Initializing Spark

The first thing a Spark program must do is to create a `SparkContext` object, which tells Spark how to access a cluster.
To create a `SparkContext` you first need to build a `SparkConf` object that contains information about your application.

Only one `SparkContext` may be active per JVM.
You must `stop()` the active `SparkContext` before creating a new one.

### Using the Shell

In the Spark shell, a special interpreter-aware `SparkContext` is already created for you, in the variable called `sc`.
Making your own `SparkContext` will not work.

### RDDs

Spark revolves around the concept of a *resilient distributed dataset* (RDD), which is a fault-tolerant collection of elements that can be operated on in parallel.
There are two ways to create RDDs: parallelizing an existing collection in your driver program, or referencing a dataset in an external storage system, such as a shared filesystem, HDFS, HBase, or any data source offering a Hadoop InputFormat.

## SQL Programming Guide
