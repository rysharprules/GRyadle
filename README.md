# G-Ry-adle
Notes associated with learning Gradle



## Installing Gradle

[Gradle download page](https://gradle.org/releases/)

## Running Gradle for the First Time
_See 01-gradle-build-tool-fundamentals_

To run the "hello" Groovy build file:

```
cd 01-gradle-build-tool-fundamentals
gradle hello
```

For Kotlin alternative, `cd 01-gradle-build-tool-fundamentals/kotlin`

## Tasks

To see a list of Gradle tasks
```
gradle tasks
```

## Plugins

### Java plugin
_See 01-gradle-build-java_

```
apply plugin: 'java'
```
or
```
plugins {
    id 'java'
}
```
You can run this with
```
gradle build
```

This will build based on default Java src locations. `.class` files will be placed in `/build` folder.

For more info run with `-i`

Demo can be run with
```
java -cp build\classes\java\main Hello
```

## Resources

[Gradle 7 Build Tool Fundamentals](https://app.pluralsight.com/library/courses/gradle-build-tool-fundamentals/table-of-contents)