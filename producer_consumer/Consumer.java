package oneHundred;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *  消费者
 */
public class Consumer implements Runnable{

	private BlockingQueue<ShareData> queue;
	private static final int SLEEPTIME = 1000;
	
	public Consumer(BlockingQueue<ShareData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("start cosumer id="+Thread.currentThread().getId());
		Random r = new Random();
		try {
			while(true) {
				ShareData date = queue.take(); //提取任务
				if(null != date) {
					int re = date.getData() * date.getData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", date.getData(),date.getData(),re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}

}
