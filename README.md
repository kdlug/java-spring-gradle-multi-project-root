./gradlew project

./gradlew clean build  bootRun -> runs web (root) application (output jar name will be the same as root project)
./gradlew clean build  console:bootRun -> runs console application
./gradlew clean build  library:bootRun -> should not be run, because it's only a library
