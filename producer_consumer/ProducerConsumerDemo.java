package oneHundred;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 运行测试
 * @author feng-hong-zhang
 * 这中模式内部使用了锁,可能会降低性能.
 * 在实际环境中,可以考虑使用disruptor并发框架.
 * 2017年9月14日
 */
public class ProducerConsumerDemo {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<ShareData> queue = new LinkedBlockingDeque<>(10);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(producer1);
		es.execute(producer2);
		es.execute(producer3);
		es.execute(consumer1);
		es.execute(consumer2);
		es.execute(consumer3);
		Thread.sleep(10000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		
		Thread.sleep(3000);
		es.shutdown();
		
	}
}
