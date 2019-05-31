package test.designPattern.behavior.templateMethod;

public class FECourse extends ACourse {

	private boolean needWriteArticle;
	
	public FECourse(boolean needWirteArticle) {
		this.needWriteArticle = needWirteArticle;
	}
	
	@Override
	protected void packageCourse() {
		System.out.println("4.1 提供前端代码");
		System.out.println("4.2 提供图片等多媒体");
	}

	@Override
	protected boolean needWriteArticle() {
		return this.needWriteArticle;
	}
	
}
