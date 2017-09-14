package oneHundred;
/**
 * 不变模式
 * @author feng-hong-zhang
 * 使用场景
 * 1,对象创建后,其内部的内容与数据不发生变化.
 * 2,对象需要被多线程访问,被多线程频繁访问.
 * 
 * 如何创建一个不变模式
 * 1,出去setter方法及修改属性的方法.
 * 2,讲所有属性都设为私有 用final标记.
 * 3,确保没有子类可以重载它的行为.
 * 4,有一个创建完整对象的构造函数.
 *
 * 2017年9月14日
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
