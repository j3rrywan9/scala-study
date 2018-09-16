# Package Objects

Each package is allowed to have one package object.
Any definitions placed in a package object are considered members of the package itself.

Package objects are frequently used to hold package-wide type aliases and implicit conversions.
The top-level `scala` package has a package object, and its definitions are available to all Scala code.

Package objects are compiled to class files named `package.class` that are located in the directory of the package that they augment.
