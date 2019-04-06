# RNGesus

## Overview
The MVP for my project is to create an app will generate Dungeons & Dragons characters for users. When I was in high school I bought a program that was able to generate characters. I cannot convey the amount of happiness that brought my friends and I, let alone the time saved. However, not long after they brought out a new ruleset (3.5) that made my program obsolete. Keep in mind, this was 2003 and updating software over the internet wasn't really a big thing back then. So, some stuff worked and some stuff didn't, but I eventually bought a Mac and the program was incompatible.

Flash forward to today and I've been playing Dungeons & Dragons with a new group of friends. There are three character creators that I know of and they all generate basic characters quite efficiently. So why bother? Well, my friends live across the nation: Florida, Maryland, New York and of course, Missouri. We can't just get together and play. Not only that, these existing character creators don't have the capacity for custom content, which is really the soul of Dungeons & Dragons. It's a game that's played on paper, the adventure is all in your mind. So I want to take it a step further and have a character creator that can create persistent, custom characters that can actually play campaigns with one another over the internet.
### Features
- User signup: Users will be able to create accounts, login and have an account page.
- User-generated content: users will be able to create custom races and (hopefully) classes.
- Persistence: Characters will be stored in a database, able to be recalled and updated.
- Ways to share content: Ways to share your custom content.
- Character life cycles: Ways to create and level a character from level 1 to level 20, not just spit out a static list of data.
- Support for character racial and class abilities: I don't just want to create something that will show me a list of abilities like every other character creator. I want abilities that can be used.
- Fun: I want a game that gives a more accurate depiction of playing Dungeons & Dragons. Did your character fail horribly or achieve greatly? Have the Gods (your friend) decided to smite you for eating the last Cheeto? That needs to be in there (eventually).
## In This Application
Dependencies are managed by [Gradle](https://gradle.org/features/)
- [Thymeleaf 3](https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html)
- [Spring-Boot 2.0.2](https://spring.io/projects/spring-boot)
- [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [FontAwesome 5.3.1](https://fontawesome.com/how-to-use/on-the-web/referencing-icons/basic-use)
- [Bootstrap 4](https://getbootstrap.com/docs/4.3/getting-started/introduction/)
- [Hibernate](http://hibernate.org/orm/)
## Setup
#### Initializing
First and foremost it's important to make sure you're using [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) as I've been warned that newer versions of Java may not function as expected with a Spring-Boot web application such as this one. 

Next, I find the easiest way to import the application is by selecting the [build.gradle](../rngesus/build.gradle) file when opening the project for the first time.
#### Database Settings
Settings for the database can be found in [application.properties](../rngesus/src/main/resources/application.properties) file. This is where you can specify the location of the desired database as well as the username and password for the admin account. **If this were a production application you would want to include this file in your .gitignore file to ensure these credentials weren't publicly available.**

It is also in this file where you could specify the query language you desired, however mine is currently configured to work with [MySQL](https://dev.mysql.com/doc/). I use [MAMP](https://www.mamp.info/en/) and [phpMyAdmin](https://www.phpmyadmin.net) as they offer free solutions for setting up MySQL databases.

As long as the database settings are correct [Hibernate](http://hibernate.org/orm/) will generate all subsequent tables automatically.
## Running the Application
#### Using IntellJ
To run the application using [IntelliJ](https://www.jetbrains.com/idea/) select the Gradle tab and navigate to `Tasks > application > bootRun`. Once the application has successfully started it can be reached at `http://localhost:8080`. 