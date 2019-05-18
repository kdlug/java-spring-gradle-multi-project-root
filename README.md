./gradlew project

./gradlew clean build  bootRun -> runs web (root) application (output jar name will be the same as root project)
./gradlew clean build  console:bootRun -> runs console application
./gradlew clean build  library:bootRun -> should not be run, because it's only a library

Console package depends on root package, it's kind of extension, so should use properties of main but don't run web server.
If we don't override application.properties in hello.console package it will take it from root package (hello.web).