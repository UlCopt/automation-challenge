FROM gradle:jdk8 AS build

COPY --chown=gradle:gradle . /home/gradle/src

COPY src /home/automation-challenge/src

COPY build.gradle /home/automation-challenge

COPY build.gradle /home/automation-challenge

COPY settings.gradle /home/automation-challenge

WORKDIR /home/automation-challenge

RUN gradle build -x test
