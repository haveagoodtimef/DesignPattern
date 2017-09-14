package oneHundred;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * �����߹������ݶ���,�����뵽BlockingQueue��.
 * @author feng-hong-zhang
 *
 * 2017��9��14��
 */
public class Producer implements Runnable{

	private volatile boolean isRunning = true;
	//�ڴ滺��
	private BlockingQueue<ShareData> queue;
	//����
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	
	public Producer(BlockingQueue<ShareData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		ShareData date = null;
		Random r = new Random();
		
		System.out.println("statr Producter Id :"+ Thread.currentThread().getId());
		while(isRunning) {
			try {
				Thread.sleep(r.nextInt(SLEEPTIME));
				
				date = new ShareData(count.incrementAndGet()); //������������
				System.out.println(date+"is put into queue");
				if(!queue.offer(date,2,TimeUnit.SECONDS)) {
					System.out.println("failed to put date :" + date);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	public void stop() {
		isRunning = false;
	}

}
