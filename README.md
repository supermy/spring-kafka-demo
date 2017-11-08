spring-kafka-demo
=================

### 20171108

    kafka 生产与消费测试口令
         kafka-console-consumer.sh --zookeeper 172.16.16.80:2181 --topic test
         kafka-console-producer.sh --broker-list 172.16.16.80:9092 --topic test 

    kafka 外网配置
        host.name=172.16.16.80
        listeners=PLAINTEXT://0.0.0.0:9092
        advertised.listeners=PLAINTEXT://0.0.0.0:9092
        zookeeper.connect=0.0.0.0:2181

### 测试docker-kafka-spring
kafka-topics.sh --create --zookeeper 192.168.99.101:2181 --replication-factor 1 --partitions 1 --topic metadata
kafka-topics.sh --create --zookeeper 192.168.99.101:2181 --replication-factor 1 --partitions 1 --topic test
