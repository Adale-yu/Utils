package test.designPattern.structure.flyweight;

public class Client {

	public static void main(String[] args) {
		
		 String fileContent = "这是一个pdf文件《设计模式：从入门到放弃》";
		
		PanServer pan = PanServer.getInstance();
		
		LocalFile localFile1 = new LocalFile("小明的设计模式.pdf", fileContent);
        String fikeKey1 = pan.upload("小明", localFile1);

        LocalFile localFile2 = new LocalFile("大明的设计模式.pdf", fileContent);
        String fikeKey2 = pan.upload("大明", localFile2);

        pan.download(fikeKey1);
        pan.download(fikeKey2);
		
		
	}
}
