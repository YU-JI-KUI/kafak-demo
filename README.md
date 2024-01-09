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
- Spring Boot 3.2.1
- Kafka
- Avro Schema
- Gradle
- Kafka SASL/SCRAM
- Mongo DB

SASL/SCRAM 的全称是 "Simple Authentication and Security Layer/Salted Challenge Response Authentication Mechanism"。这是一种基于挑战响应机制的认证方法，用于提供更安全的认证方式。

SASL (Simple Authentication and Security Layer): 是一个独立于协议的认证框架，用于添加认证支持到各种网络协议中。SASL 支持多种认证机制，允许客户端和服务器进行协商，选择一个双方都支持的最佳机制。

SCRAM (Salted Challenge Response Authentication Mechanism): 是一种 SASL 认证机制，它使用密码的散列值来进行安全的认证，而不是传输未加密的密码。SCRAM 还包括对抗重放攻击的措施，并可选地支持双向认证。

在 Apache Kafka 中，SASL/SCRAM 是一种常用的认证方式，它提供比基本的 SASL/PLAIN 更强的安全性，因为它不需要在网络中传输明文密码。Kafka 支持多种 SCRAM 方法，如 SCRAM-SHA-256 和 SCRAM-SHA-512。

## 出现的问题
- 当使用 Avro 时必须添加 schema.registry.url 并且需要配置 KafkaAvroSerializer 和 KafkaAvroDeserializer
- 当出现多个 ConcurrentKafkaListenerContainerFactory 的时候，需要在 KafkaListener 注解中指定当前 consumer 使用的是哪一个。
- consumer 需要设置 specific.avro.reader = true 才能正确反序列化 avro 对象
- 如何 schema 中有什么必填的字段，但是在传入 message 的时候没有满足，此时 producer 的序列化就会报错。例如 “Field remark type:STRING pos:3 not set and has no default value”

## Reference Docs
- [Windows 本地搭建 Kafka](https://www.cnblogs.com/asd14828/p/13529487.html)
- [Spring Boot & Kafka 基础集成，Message 是 String](https://medium.com/@abhishekranjandev/a-comprehensive-guide-to-integrating-kafka-in-a-spring-boot-application-a4b912aee62e)
- [Linux 上安装 Kafka 环境](https://r08kdwv0y3.feishu.cn/docx/GPfRdnbfooazKPxTTEecoZs3nCg?from=from_copylink)
- [Linux 上安装 Mongo DB](https://r08kdwv0y3.feishu.cn/docx/WC9yd4mcTopWGpxtkTxcWbfanqe)