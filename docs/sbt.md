# sbt

## Why sbt?

### How sbt works

#### sbt tasks

sbt is built around tasks.

You want to do something, you execute a task.
You want to ensure that a task runs after another task, you add an explicit dependency between the tasks.

If you want to use the results of a task in another task, you push the output from one task into another.
The results of one task are automatically available in dependent tasks.
The output of an sbt task is a value (which can be of any type), so this can be passed around with ease.
Multiple tasks can depend on the output of the same task.

sbt puts in place a default structure and layout.
Out of the box you get your `compile` task, `test` task, and `publish` task, and these work as expected: if you run the `test` task, sbt will run the `compile` task beforehand.
The `compile` task compiles Scala and Java by default.
The layout is similar to that of a standard Maven project.

A task in sbt is Scala code.
You write the code directly in your build configuration.

#### sbt settings

A setting in sbt is just a value.

### Passing information around your build

In sbt, you can simply return the information from the first task as the return value fo the task.

YOu know that the task has executed because you have the value.

### Working with Scala

#### Cross-compilation for multiple Scala versions

Scala (the library) is binary-compatible between minor version releases.

sbt has built-in options for this sort of thing.
You can tell sbt to cross-compile directly in the build definition.

### Multiproject builds

### Dependency resolution

sbt uses Ivy for its dependency resolution.

## Setting up a build

Every project using sbt should have two files:
* project/build.properties
* build.sbt

The build.properties file is used to inform sbt which version it should use for your build, and the build.sbt file defines the actual settings for your build.

### Tasks

## Running code


