package test.net.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Url2
{
	public static void main(String[] args) {
		
		try {
			//使用URL读取网页内容
			//创建一个URL实例
    		URL url = new URL("http://resource.yinshouhn.com/391/servers/game1/test.server");
    		//通过openStream方法获取资源的字节输入流
    		InputStream is = url.openStream(); 
    		//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
    		InputStreamReader isd = new InputStreamReader(is,"UTF-8");
    		//为字符输入流添加缓冲，提高读取效率
    		BufferedReader br = new BufferedReader(isd);
    		StringBuffer sb = new StringBuffer();
    		String data = br.readLine();
    		while(data != null) {
    			sb.append(data);
    			sb.append("\r\n");
    			data = br.readLine();
    		}
    		System.out.println(sb);
    		br.close();
    		is.close();
    		isd.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
