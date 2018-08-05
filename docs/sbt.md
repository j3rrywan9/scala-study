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

You know that the task has executed because you have the value.

### Working with Scala

#### Cross-compilation for multiple Scala versions

Scala (the library) is binary-compatible between minor version releases.

sbt has built-in options for this sort of thing.
You can tell sbt to cross-compile directly in the build definition.

#### Lots more classes in Scala

The Scala compiler tends to generate more classes (.class files) than would be generated by the equivalent program written in Java.
This is due to how Scala generates code for closures and other constructs that aren't supported directly in the JVM, which it must simulate.
The concrete effect is that the JVM takes longer to get up and running with Scala code—and not only on compilation but on test startup as well.

### Multiproject builds

sbt is also designed specifically for multiproject (sometimes called multimodule) builds.

### Dependency resolution

sbt uses Ivy for its dependency resolution.

## Setting up a build

Every project using sbt should have two files:
* project/build.properties
* build.sbt

The build.properties file is used to inform sbt which version it should use for your build, and the build.sbt file defines the actual settings for your build.

### Tasks

Tasks are things that sbt build can do for you, like compiling a project, creating documentation, or running tests.

### Running code

### Testing code

#### Make sure to reload

Any change to the build.sbt file or files in the project/ directory won't be immediately available within the sbt console.
The `reload` command tells sbt to re-examine the project definition and rewire the project.
When you edit an sbt build, you’ll need to reload.

## Core concepts

### Creating builds

### Defining settings

Settings are the bread and butter of sbt builds.
They’re the mechanism by which you configure sbt to perform the work you need for your build.
sbt reads all the settings defined in your build at load time and runs their initializations, which produce the final setting values used for your build.

A setting consists of three parts: a key, an initialization, and an operator that associates the key and initialization.
A setting is used to change an aspect of the build or add functionality.

#### Typesafe settings

In sbt, every key has one and only one type.
Any value placed into a setting must match the exact type.
This prevents mismatched data from being passed around the build.

#### Defining dependencies

sbt provides a convenient syntax for defining dependencies on remote artifacts using the `%` method.
This method is used to create `ModuleID` instances.
To define a `ModuleID` in sbt, write `"groupId" % "artifactId" % "version"` and it will automatically become an instance of a `ModuleID`.
