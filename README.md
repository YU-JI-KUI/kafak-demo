# Kafka-Demo

学习 Kafka 的记录，开箱即用的代码和配置。

## Case1
向 Topic 中发送 String 的 Message，并且 producer 和 consumer 的配置都是通过代码实现。

测试路径 http://localhost:8080/send?message=Hello_Kafka

## Case2
向 Topic 中发送 Avro Message，并且 producer 和 consumer 的配置都是通过代码实现。

测试路径 http://localhost:8080/sendUser?name=Kris

## Reference Docs
- [Windows 本地搭建 Kafka](https://www.cnblogs.com/asd14828/p/13529487.html)
- [Spring Boot & Kafka 基础集成，Message 是 String](https://medium.com/@abhishekranjandev/a-comprehensive-guide-to-integrating-kafka-in-a-spring-boot-application-a4b912aee62e)
