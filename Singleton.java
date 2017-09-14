package oneHundred;
/**
 * ������������һ
 * @author feng-hong-zhang
 * Ϊʲôʹ�õ���ģʽ
 * 1,����Ƶ��ʹ�õĶ���,����ʡ��new�������ѵ�ʱ��.
 * 2,����new�Ĵ�������,���ڴ�ʹ���ʽ���,ͬʱ������GC��ѹ��.
 * 2017��9��13��
 */
public class Singleton {
	private Singleton() {
		System.out.println("���췽��!");
	}
	
	private static class InnerSingleton {
		private static Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance() {
		return InnerSingleton.singleton;
	}
}
