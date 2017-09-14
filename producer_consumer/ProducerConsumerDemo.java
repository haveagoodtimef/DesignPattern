package oneHundred;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * ���в���
 * @author feng-hong-zhang
 * ����ģʽ�ڲ�ʹ������,���ܻή������.
 * ��ʵ�ʻ�����,���Կ���ʹ��disruptor�������.
 * 2017��9��14��
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
