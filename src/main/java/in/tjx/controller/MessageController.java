package in.tjx.controller;

import in.tjx.publisher.RabbitMQProducer;
import org.springframework.amqp.AmqpException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    // http://localhost:8080/api/v1/publish?message=HelloWorld
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) throws AmqpException {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok().body("Message sent successfully");
    }

}
