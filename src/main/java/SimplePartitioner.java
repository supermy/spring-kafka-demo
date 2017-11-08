/**
 * Created by moyong on 15/11/27.
 */
import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * 根据key 进行hash 取值到不同的分区;
 * 发送到服务器之前就执行
 */
public class SimplePartitioner implements Partitioner {

    public SimplePartitioner (VerifiableProperties props) {
    }

    @Override
    public int partition(Object key, int numPartitions) {
        int partition = 0;
        String k = (String)key;
        partition = Math.abs(k.hashCode()) % numPartitions;
        System.out.println("******:"+partition);
        return partition;
    }

}
