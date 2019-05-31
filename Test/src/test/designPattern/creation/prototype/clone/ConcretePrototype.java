package test.designPattern.creation.prototype.clone;

public class ConcretePrototype implements Cloneable {
	private int num;
	private String str;
	private OneObject oneObject;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public OneObject getOneObject() {
		return oneObject;
	}
	public void setOneObject(OneObject oneObject) {
		this.oneObject = oneObject;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ConcretePrototype prototype = (ConcretePrototype) super.clone();
		return prototype;
	}
}
