# Spring-Boot-Peliculas


# Requirements: 
```
Java version: 17.0.4.1
Apache Maven 3.8.6
```

## Setting up Java and Maven:

Download Java jdk and Maven from oficial websites

* [Maven](https://maven.apache.org/download.cgi)
* [Java](https://www.oracle.com/java/technologies/downloads/)

After downloading both file, extract them in ``C:\Program Files\Java\jdk-17.0.4.1`` and ``C:\maven``

Now create a enviroment variable for each directory, if you dont have them already:

**_Enviroment variables -> New ..._**

Java variable:
```
Variable name: JAVA_HOME
Variable value: C:\Program Files\Java\jdk-17.0.4.1
```
Maven variable:
```
Variable name: MAVEN_HOME
Variable value: C:\maven
```
Add **JAVA_HOME** and **MAVEN_HOME** to **path** variable at the end separated by **;**
```
Variable name: path
Variable value: ... ;%JAVA_HOME%\bin;%MAVEN_HOME%\bin;
```
Verify that maven java are installed:
```
$> java -version
java version "17.0.4.1" 2022-08-18 LTS
...
$> mvn -version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\maven
...
```
