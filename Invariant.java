package oneHundred;
/**
 * ����ģʽ
 * @author feng-hong-zhang
 * ʹ�ó���
 * 1,���󴴽���,���ڲ������������ݲ������仯.
 * 2,������Ҫ�����̷߳���,�����߳�Ƶ������.
 * 
 * ��δ���һ������ģʽ
 * 1,��ȥsetter�������޸����Եķ���.
 * 2,���������Զ���Ϊ˽�� ��final���.
 * 3,ȷ��û�������������������Ϊ.
 * 4,��һ��������������Ĺ��캯��.
 *
 * 2017��9��14��
 */
public final class Invariant {
	private final String name;
	private final int age;
	
	public Invariant(String name , int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
	
}
