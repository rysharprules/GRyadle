tasks.register("hello") {
    doFirst {
        print("Hel")
    }
    doLast {
        print("lo")
    }
}

tasks.register("world") {
    // run 'gradle world', and it will run the "hello" task first as that is a dependency
    dependsOn("hello")
    doLast {
        println(", World from Kotlin")
    }
}