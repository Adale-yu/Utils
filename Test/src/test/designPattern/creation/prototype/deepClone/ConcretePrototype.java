package test.designPattern.creation.prototype.deepClone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ConcretePrototype implements Cloneable, Serializable {
	private static final long serialVersionUID = 3965074701077914659L;
	
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
	
	protected Object deepClone() throws IOException, ClassNotFoundException {
		//将对象写到流里
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		//从流里读回来
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return ois.readObject();
	}
}
