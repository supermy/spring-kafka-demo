/**
 * Created by moyong on 15/11/27.
 */
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 现在用一个生产者示例（PartitionerProducer），向Topic mydebug中发送消息。该生产者使用的分区规则，就是上面的SimplePartitioner。
 * 从0-10一共11条消息，每条消息的key为”key”+index，消息内容为”key”+index+”–value”+index。比如：key0–value0、key1–value1、、、
 * key10–value10。
 *
 * 理论上来说，生产者在发送消息的时候，会按照SimplePartitioner的规则，将key0做hashcode，然后和分区数（4）做模运算，得到分区索引：
 *
 * hashcode(”key0”) % 4 = 1
 *
 * hashcode(”key1”) % 4 = 2
 *
 * hashcode(”key2”) % 4 = 3
 *
 * hashcode(”key3”) % 4 = 0
 * ...
 *
 * 对应的消息将会被发送至相应的分区中。
 */
public class PartitionerProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.168.99.101:9092,192.168.99.101:9093,192.168.99.101:9094");
        props.put("partitioner.class", "SimplePartitioner");
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(props));
        System.out.println("producer......"+producer.toString());
        String topic = "mydebug";
        for(int i=0; i<=10; i++) {
            String k = "key" + i;
            String v = k + "--value" + i;
            producer.send(new KeyedMessage<String, String>(topic,k,v));
        }
        producer.close();
    }
}