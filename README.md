# G-Ry-adle
Notes associated with learning Gradle



## Installing Gradle

[Gradle download page](https://gradle.org/releases/)

## Running Gradle for the First Time
_See 01-gradle-fundamentals_

To run the "hello" Groovy build file:

```
cd 01-gradle-fundamentals
gradle hello
```

For Kotlin alternative, `cd 01-gradle-fundamentals/kotlin`

## Tasks

To see a list of Gradle tasks
```
gradle tasks
```

### Phases

1. Initialization
2. Configuration
3. Execution

#### Execution Phase

- dependsOn - Dependency which must run before
- doFirst
- doLast

## Plugins

Extend project's capabilities

### Java plugin
_See 01-build-java_

This is built in.

Groovy
```
apply plugin: 'java'
```
Groovy (preferred)
```
plugins {
    id 'java'
}
```
Kotlin
```
plugins { java }
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

### Community plugin

Use fully qualified name and a version.
```
plugins {
    id 'java'
    id 'org.flywaydb.flyway' version '6.3.2'
}
```
Run `gradle tasks` to see tasks that added plugins provide.

## Resources

[Gradle 7 Build Tool Fundamentals](https://app.pluralsight.com/library/courses/gradle-build-tool-fundamentals/table-of-contents)