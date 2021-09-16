package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			//기반 스트림 - 타겟 연결
			FileOutputStream fos = new FileOutputStream("buffered_outputstream_test");
					
			//보조 스트림 - 기반스트림 연결
			bos = new BufferedOutputStream(fos);
			
			for(int i = 'a'; i <= 'z'; i++) {
				bos.write(i);	//버퍼에 쓴 데이터의 길이가 buf.length이상일 때 flush(실제 타겟 파일에 output) 			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
