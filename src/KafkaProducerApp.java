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
