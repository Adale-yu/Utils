package test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class IOTest {
	
	private static final String annotation = "#";
	private static final String eq = "=";
	
	public static void main(String[] args) {
		String config = "conf" + File.separator + "config.txt";
		File file = new File(config);
		Map<String, String> map = loadFile(file, "utf-8");
		System.err.println(map.toString());
	}
	
	public static Map<String, String> loadFile(File file, String charsetName){
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(file == null || charsetName == null) {
				throw new NullPointerException();
			}
			if(!file.exists()) {
				throw new FileNotFoundException();
			}
			if(!file.isFile() || !file.canRead()) {
				return null;
			}
			InputStream is = new FileInputStream(file);
			InputStreamReader isd = new InputStreamReader(is, charsetName);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(isd);
			String info = null;
			while((info = br.readLine()) != null) {
				String[] kv = parse(info);
				if(kv != null) {
					map.put(kv[0], kv[1]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
	public static String[] parse(String info) {
		if(info==null || info.equals("")) {
			return null;
		}
		
		info = info.trim();
		
		int mpos = info.indexOf(annotation);
		if(mpos == 0) {
			return null;
		}
		
		int epos = info.indexOf(eq);
		if((mpos!=-1 && mpos<epos) || epos == 0) {
			return null;
		}
		String[] kv = new String[2];
		kv[0] = info.substring(0, epos).trim();
		kv[1] = info.substring(epos+1, info.length()).trim();
		
		return kv;
	}
}
