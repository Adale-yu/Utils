package test.designPattern.behavior.templateMethod;

public class ClientTest {

	public static void main(String[] args) {
		ACourse course = new JavaCourse();
		course.templateMethod();
		
		ACourse fe = new FECourse(false);
		fe.templateMethod();
	}
}
