package test.base.classForName;

public class Example implements ExampleInterface {

	@Override
	public void save() {
		System.out.println("保存成功....");
		delete();
	}
	
	public void delete() {
		System.out.println("删除成功......");
	}

}
