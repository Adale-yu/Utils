package test.designPattern.structure.flyweight;

public class Resource {

	private String content;
	private int length;
	private String hashId;
	
	public Resource(String content, String hashId) {
		this.content = content;
		this.length = content.length();
		this.hashId = hashId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}
	
	
}
