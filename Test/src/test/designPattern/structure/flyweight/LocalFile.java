package test.designPattern.structure.flyweight;

public class LocalFile {

	private String content;
	private String fileName;
	
	public LocalFile(String fileName, String content) {
		this.fileName = fileName;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
