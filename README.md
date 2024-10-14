This project aims to support the study of how to implement
tests using cucumber and JAVA.
Will it be used Selenium to UI testing.

Cucumber is the tool that allows us to connect .feature files with Java so it is possible to make the test happens

# Install
Install Java and Maven. This project uses JAVA 11 and Maven 3.9.9

This project has been developed in macOS, there so, to install Maven, Chat GPT says:
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install maven
```

# How to create a Cucumber project
Please pay attention to the version of cucumber, check the version you want to use at the official source
https://mvnrepository.com/artifact/io.cucumber/cucumber-java

```
mvn archetype:generate "-DarchetypeGroupId=io.cucumber" "-DarchetypeArtifactId=cucumber-archetype" "-DarchetypeVersion=7.20.1" "-DgroupId=hcbc.informatics" "-DartifactId=init_cucumber" "-Dpackage=init_cucumber" "-Dversion=1.0.0" "-DinteractiveMode=false"
```


# Running
In order to run the tests on command line, please edit and follow the example:
```
mvn clean test 
```