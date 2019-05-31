package test.designPattern.behavior.templateMethod;

public class JavaCourse extends ACourse {

	@Override
	protected void packageCourse() {
		System.out.println("4.提供java代码");
	}
	
	@Override
	protected boolean needWriteArticle() {
		return true;
	}

}
