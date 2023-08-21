# The main Purpose of this project is to build a automation suite for a Single Page Application
This is a hybrid framework project, hybrid of cucumber(BDD) and data driven.
This project uses gradle as build system and selenium automation tool.

# You can run this project with the help of following command
* Navigate to the the project directory
* If gradle is installed in your system use this command
* Run gradle build or .\gradlew build
  gradle -Dorg.gradle.project.testTags=TestTags -Dorg.gradle.project.browser=chrome testauto
* If you want to run using a gradle wrapper use
  .\gradlew -Dorg.gradle.project.testTags=TestTags -Dorg.gradle.project.browser=chrome testAuto
* Sample TestTag is @Test3

##### Note:- Before running the test make sure that react app should be running on your local machine

# This project is best compatible with gradle 7.2 version
* The java version used is JDK 8

# After the run the report is available under target folder