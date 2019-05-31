package test.net.nio.fileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel
{
	public static void method() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("data/test.txt","rw");
			FileChannel fileChannel = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			int count = fileChannel.read(buf);
			while(count != -1) {
				buf.flip();
				while(buf.hasRemaining()) {
					System.out.println((char)buf.get());
				}
				buf.compact();
				count = fileChannel.read(buf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		method();
	}
}
