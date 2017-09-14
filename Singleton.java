package oneHundred;
/**
 * 饱汉饥汉二合一
 * @author feng-hong-zhang
 * 为什么使用单例模式
 * 1,对于频繁使用的对象,可以省略new操作花费的时间.
 * 2,由于new的次数减少,对内存使用率降低,同时减轻了GC的压力.
 * 2017年9月13日
 */
public class Singleton {
	private Singleton() {
		System.out.println("构造方法!");
	}
	
	private static class InnerSingleton {
		private static Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance() {
		return InnerSingleton.singleton;
	}
}
