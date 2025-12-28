# RabbitMQ with SpringBoot

https://www.youtube.com/playlist?list=PLGRDMO4rOGcMh2fAMOnwuBMDa8PxiKWoN

Rabbit MQ Core Concepts and Architecture
    - Producer
    - Consumer
    - Queue
    - Exchange
    - Binding
    - Routing Key
    - Message

Producer --> (message) --> RabbitMQ Message Broker --> (message) --> Consumer

Spring Boot + RabbitMQ Integration using Spring AMQP (Advanced Message Queuing Protocol)


Producer --> (JSON Message) --> Exchange --> Queue --> (JSON Message) --> Consumer

What is a message queue?
Message queuing allows applications to communicate by sending messages to each other. The message queue provides temporary message storage when the destination program is busy or not connected.
A message queue is made up for a producer, a broker (the message queue software), and a consumer
A message queue provides an asynchronous communication between applications.

Producer --> (message) --> Message Broker --> (message) --> Consumer

RabbitMQ is an example of a message broker.
There are several alternatives to RabbitMQ like Apache Kafka for high-throughput streaming, Redis Streams/Pub/Sub for fast caching/queues, cloud-native options like AWS SQS/SNS, Google Pub/Sub, Azure Service Bus, and enterprise brokers like IBM MQ with choices depending on need for streaming, low-latency, or cloud integration. For traditional messaging, Active MQ is also a strong contender.


Streaming & High Throughput
Apache Kafka: Excellent for massive event streams, data pipelines, and log aggregation; persists data and allows replay.
Redpanda: A Kafka-compatible, high-performance streaming platform, often a drop-in replacement for Kafka.

Cloud-Native (Managed Services)
Amazon SQS/SNS: AWS's managed queues (SQS) and pub/sub (SNS) for serverless, scalable messaging.
Google Cloud Pub/Sub: Google's global, real-time messaging service.
Azure Service Bus/Event Hubs/Grid: Microsoft's robust offerings for enterprise messaging and event handling.

Lightweight & High Performance (Microservices)
NATS: Extremely fast, lightweight messaging for microservices and IoT, with low latency.
Redis Streams/Pub/Sub: In-memory data store offering fast message queues and publish/subscribe capabilities, great for real-time apps.

Enterprise & Traditional MQ
IBM MQ: A battle-tested, highly reliable enterprise message queuing system.
Apache ActiveMQ: Supports many protocols (AMQP, MQTT, etc.), good for diverse environments.

How to Choose?
- For streaming/big data: Kafka, Redpanda.
- For cloud-native apps: AWS SQS/SNS, Google Pub/Sub, Azure Service Bus.
- For microservices (speed): NATS, Redis Streams.
- For traditional enterprise reliability: IBM MQ, ActiveMQ.


Producer --> (message) --> <Exchange> --> Queue (RabbitMQ) --> (message) --> Consumer

Producer
Producer is an application that sends messages. It does not send messages directly to the consumer. It sends message only to the RabbitMQ broker.

Consumer
Consumer is an application that reads messages from the RabbitMQ broker.

Queue
QUeue is a buffer or storage in a RabbitMQ broker to store the messages.
The messages are put into a queue by a producer and read from it by a consumer. Once a message is read, it is consumed and removed from the queue. A message can thus only be processed exactly once.

Message
Information that is sent from the producer to a consumer through RabbitMQ.

Exchange
Basically, it acts as an intermediary between the producer and a queue. Instead of sending messages directly to a queue, a producer can send them to an exchange instead. The exchange then sends those messages to one or more queues following a specified set of rules. Thus, the produer does not need to know the queues that eventually receive those messages.

Routing Key
The routing key is a key that the exchange looks at to decide how to route the message to queues. The routing key is like an address for the message.

Binding
A binding is a link between a queue and an exchange.

Setup ActiveMQ in Windows
https://prashant007.medium.com/setup-activemq-on-windows-98240db18698


Run RabbitMQ Docker Image:
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:latest


Spring Boot Auto configuration for Spring AMQP (RabbitMQ) (Advanced Message Queue Protocol)

We get a connection our RabbitMQ broker on port 5672 using the default username and password: guest/guest

Define these properties in a application.properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest


Lets use RabbitTemplate to send the messages. Spring Boot automatically configure RabbitTemplate for us. We just need to inject and use it.

