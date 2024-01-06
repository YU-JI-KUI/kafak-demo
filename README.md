# Kafka-Demo

学习 Kafka 的记录，开箱即用的代码和配置。

## Case1
向 Topic 中发送 String 的 Message，并且 producer 和 consumer 的配置都是通过代码实现。

测试路径 http://localhost:8080/send?message=Hello_Kafka

## Case2
向 Topic 中发送 Avro Message，并且 producer 和 consumer 的配置都是通过代码实现。

测试路径 http://localhost:8080/sendUser?name=Kris

## Tech Stack
- JDK 17
- Spring Boot
- Kafka
- Avro Schema
- Gradle

## 出现的问题
- 当使用 Avro 是必须添加 schema.registry.url 并且需要配置 KafkaAvroSerializer 和 KafkaAvroDeserializer
- 当出现多个 ConcurrentKafkaListenerContainerFactory 的时候，需要在 KafkaListener 注解中指定当前 consumer 使用的是哪一个。
- consumer 需要设置 specific.avro.reader = true 才能正确反序列化 avro 对象

## Reference Docs
- [Windows 本地搭建 Kafka](https://www.cnblogs.com/asd14828/p/13529487.html)
- [Spring Boot & Kafka 基础集成，Message 是 String](https://medium.com/@abhishekranjandev/a-comprehensive-guide-to-integrating-kafka-in-a-spring-boot-application-a4b912aee62e)
- [Linux 上安装 Kafka 环境](https://r08kdwv0y3.feishu.cn/docx/GPfRdnbfooazKPxTTEecoZs3nCg?from=from_copylink)