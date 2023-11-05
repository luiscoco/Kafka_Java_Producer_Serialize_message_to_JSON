# Kafka Java Producer Serialize message to JSON

## Project structure

![image](https://github.com/luiscoco/Kafka_Java_Producer_Serialize_message_to_JSON/assets/32194879/9783002d-c3cf-4105-81c0-0bca044eb90f)

## Source Code

**YourMessageClass.java**
```java
public class YourMessageClass {
    private String content;

    public YourMessageClass() {
        // Default constructor for Jackson
    }

    public YourMessageClass(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

**KafkaProducerApp.java**
```java
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;

public class KafkaProducerApp {
    public static void main(String[] args) {
        // Set up producer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(properties);

        // Create ObjectMapper for JSON serialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Produce a message
        String topic = "your-topic";
        String key = "key1";
        YourMessageClass message = new YourMessageClass("Hello, Kafka!"); // Create a class for your message
        String value;

        try {
            // Serialize the message object to JSON
            value = objectMapper.writeValueAsString(message);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

        // Send the message
        producer.send(record);

        // Close the producer
        producer.close();
    }
}
```

**log4j.properties**
```
log4j.rootLogger=INFO, stdout

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

```

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
