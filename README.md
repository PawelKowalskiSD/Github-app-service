# GitHub Application
Application for searching github user repositories.

## Table of Contents
* [Introduction](#introduction)
* [Features](#features)
* [Technologies](#technologies)
* [Setup](#setup)

## Introduction
A simple application for searching user repositories on Github.
Thanks to this application, we can easily search for all user repositories that are not forks.
We get the name of the repository, who is the owner,
the name of the branch and the last commit saved in sha.
## Features

*  Search user repositories

## Technologies
* Spring Boot 3.2.2
* Gradle
* Mockito
* JUnit
* Swagger

## Setup
To get started with this project, you will need to have the fallowing installed on your local machine:
* JDK 21
* Gradle 8.6

To build and run project, fallow these steps:
* Clone the repository: 'git clone https://github.com/PawelKowalskiSD/Github-app-service.git'
* Navigate to the project directory: cd Github-app-service
* Build the project: gradle build
* Run the project: ./gradlew bootRun

The application will be available at: http://localhost:8080/swagger-ui/index.html#/