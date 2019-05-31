package test.designPattern.behavior.templateMethod;

public abstract class ACourse {

	final void templateMethod() {
		this.makePPT();
		this.makeVideo();
		if(this.needWriteArticle()) {
			this.writeArticle();
		}
		this.packageCourse();
	}
	
	final void makePPT() {
		System.out.println("1.制作ppt");
	}
	
	final void makeVideo() {
		System.out.println("2.制作视频");
	}
	
	final void writeArticle() {
		System.out.println("3.编写标题笔记");
	}
	
	protected boolean needWriteArticle() {
		return false;
	}
	
	protected abstract void packageCourse();
}
