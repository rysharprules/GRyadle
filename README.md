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

## Java projects

The Java plugins expect to find the source code in a standard location.

Standard code layout example:
```
    src
        main
            java
            kotlin
            resources
        test
            java
            kotlin
            resources
```
This can be changed using SourceSets:
```Groovy DSL
sourceSets {
    main {
        java  {
            srcDir 'src/java'
        }
        resources {
            srcDir 'src/resources'
        }
    }
}
```

### application plugin
_See 03-java-project_

This is derived from the `java` plugin. It includes a task named `run`. To use this, we need to tell Gradle what the main
class name is (the class which contains a runnable `main` method):

`mainClassName = 'com.gryadle.security.Hash'`

Run it with:
```
cd 03-java-project
gradle run
```

### Version
_See 03-java-project_

You can set the Java source version with:

```Groovy DSL
java {
    sourceCompatibility = JavaVersion.VERSION_17
}
```

You can also set target compatibility with `targetCompatibility`. If you do not set this, it will automatically take the source compatibility value.

## Kotlin projects
_See 03-kotlin-project_

## Dependencies

We can add dependencies with the `dependencies` block
```
dependencies {
    implementation group: 'log4j', name: 'log4j', version: '1.2.17'
    implementation group: 'javax.xml.bind', name: 'jaxb-api', version: '2.3.1'
    testImplemtation 'junit:junit:4.12'
}
```

can be satisfied from:

1. Other projects
2. File system
Specify with `files` in `dependencies` block
```
    dependencies {
        implementation files ('lib/log4j-1.2.8.jar', 'lib/jaxb-api-2.3.1.jar')
        testImplementation files ('lib/junit-3.8.1.jar')
    }
```
or alternatively specify the file directory within the `repositories` block
```
    repositories {
        flatDir {
            dirs 'lib'
        }
    }
```
3. Maven repositories

local
```
repositories {
    mavenLocal()
}
```

custom
```
repositories {
    maven {
        url "http://repo.mycompany.com/maven2"
    }
}
```

4. Ivy repositories

```
repositories {
    ivy {
        url "http://repo.mycompany.com/repo"
    }
}
```

5. Multiple

```
repositories {
    maven {
        url "http://repo.mycompany.com/maven2"
    }
    ivy {
        url "http://repo.mycompany.com/repo"
    }
}
```

### Configuration (scopes):
- Compilation `compileOnly` (implementation)
- Runtime `runtimeOnly` (implementation)
- Test compilation `testCompileOnly` (testImplementation)
- Test runtime `testRuntimeOnly` (testImplementation)

We can list all dependencies or via configuration
```
gradle -q dependencies
gradle -q dependencies --configuration implementation
```
(`-q` means quiet)

### Properties

You can store variables in a properties file:

gradle.properties
```
junit_version = 3.8.1
```

build.gradle.kts
```
val junit_version: String by project

dependencies {
    testImplementation("junit:junit:$junit_version")
}
```

build.gradle
```
buildscript {
    ext {
        junit_version = 3.8.1
    }
}

dependencies {
    testImplementation "junit:junit:$junit_version"
}
```

## Multi-project build

settings.gradle
```
include 'Repository', 'JacketService'
```

build.gradle
```
allprojects {
    apply plugin: 'java'
}
version = '1.0.SNAPSHOT'
project(':Repository'){}
project(':JacketService'){
    dependencies {
        implementation project(':Repository')
    }
}
```

build.gradle.kts
```
allprojects {
    apply(plugin="java")
    version = "1.0.SNAPSHOT"
}
project(":Repository"){}
project(":JacketService"){
    dependencies {
        "implementation"(project(":Repository")
    }
}
```

## Resources

[Gradle 7 Build Tool Fundamentals](https://app.pluralsight.com/library/courses/gradle-build-tool-fundamentals/table-of-contents)