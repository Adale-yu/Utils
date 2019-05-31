package test.designPattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PanServer {
	private static final PanServer pan = new PanServer();
	private Map<String, File> fileSystem;
	private Map<String, Resource> resourceMap;
	
	private PanServer() {
		fileSystem = new HashMap<String, File>();
		resourceMap = new HashMap<String, Resource>();
	}
	
	public static PanServer getInstance() {
		return pan;
	}
	
	public String upload(String owner, LocalFile localFile) {
		long startTime = System.currentTimeMillis();
		String content = localFile.getContent();
		String fileName = localFile.getFileName();
		String hashId = HashUtil.getHashId(content);
		File file = new File(owner, fileName);
		System.out.println(owner + " 上传文件");
		if(resourceMap.containsKey(hashId)) {
			System.out.println(String.format("检测到内容相同的文件《%s》，为了节约空间，重用文件", localFile.getFileName()));
			Resource resource = resourceMap.get(hashId);
			file.setResource(resource);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(String.format("文件《%s》上传中....", localFile.getFileName()));
			Resource resource = new Resource(content, hashId);
			resourceMap.put(hashId, resource);
			file.setResource(resource);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("文件上传完成，共耗费 %s 毫秒\n", endTime - startTime));
		fileSystem.put(file.meteData(), file);
		return file.meteData();
	}
	
	public File download(String fileKey) {
		if(fileSystem.containsKey(fileKey)) {
			 System.out.println("下载文件：" + fileSystem.get(fileKey).meteData());
			return fileSystem.get(fileKey);
		}
		
		System.out.println("文件不存在");
		return null;
	}
	
}
