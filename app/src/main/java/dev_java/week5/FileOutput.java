package dev_java.week5;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileOutput {
	public static void main(String[] args) {
		OutputStreamWriter out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("E:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\week5\\test.txt",true);
			out = new OutputStreamWriter(fos, "UTF-8");//한글처리지원
			out.write("hello");
			out.write(" java");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
