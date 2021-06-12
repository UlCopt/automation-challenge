# automation-challenge
Java Selenium Cucumber Gradle Docker project

## About


## Prerequisites
Docker installed 
MacOS with Chrome Browser installed (only if run local)
Gradle installed (only if run local)
java 8 (only if run local)

##  How to run on Docker
#### Type on terminal
Clone repo
```
git clone https://github.com/UlCopt/automation-challenge.git
cd automation-challenge
```

Create docker image project
```
docker build -t mydockerimage .
```

Pull selenium chrome docker image 
```
docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:4.0.0-beta-4-20210608  
```

Run tests
```
docker run -d --network="host" mydockerimage gradle cucumber -Dbrowser=docker-chrome 
```

Optional (check logs)
```
docker logs {ID}
```

Copy Screenshots
```
docker cp {CONTAINER-ID}:/home/automation-challenge/src/main/resources/screenshots ./     
```

Copy Screenshots
```
 docker cp {CONTAINER-ID}:/home/automation-challenge/target ./       
```

##  How to run Local (MacOs Chrome Driver)
#### Type on terminal
Clone repo
```
git clone https://github.com/UlCopt/automation-challenge.git
cd automation-challenge
```

Run tests
```
gradle cucumber -Dbrowser=local-chrome
```

Optional (check logs)
```
docker logs {ID}
```

Screenshots
```
automation-challenge/src/main/resources/screenshots    
```

Report
```
automation-challenge/target/cucumber/report.html       
```




