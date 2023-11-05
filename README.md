# Kafka_Java_Producer_Serialize_message_to_JSON

## Download the application dependencies (JAR file)

Navigate to the Apache Kafka web page URL, and download the **Kafka** JAR file

https://kafka.apache.org/downloads

Download the Scala 2.13 file: **kafka_2.13-3.6.0.tgz**

Donwload the **Jackson Databind** and **Jackson Core** JAR files

https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.15.3

https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.15.3

Create a new **lib** folder in your Java application and place all the dependencies (JAR files)




## Compiling the application

Run the command

```
javac -cp ".;lib/*" src/YourMessageClass.java src/KafkaProducerApp.java
```

## Running the application

```

```
