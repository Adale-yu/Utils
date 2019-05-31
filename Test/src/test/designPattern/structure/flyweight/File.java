package test.designPattern.structure.flyweight;

public class File {

	private String owner;
	private String fileName;
	private Resource resource;
	
	public File(String owner, String fileName) {
		this.owner = owner;
		this.fileName = fileName;
	}

	public String meteData() {
		return owner + "__" + fileName + "__" + resource.getHashId();
	}
	
	public void display() {
		System.out.println("这是" + meteData() + "上传的文件，内容为：" + resource.getContent());
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	
}
