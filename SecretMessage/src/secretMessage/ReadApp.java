package secretMessage;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadApp {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("secret.msg");
		DataInputStream input = new DataInputStream(fis);
		
		int key;
		
		key = input.readInt();
		StringBuilder sb = new StringBuilder(input.readUTF());
		System.out.println(sb.toString());
		
		for(int i = 0; i < sb.length(); i++){
			sb.setCharAt(i, (char)( sb.charAt(i)- key));
		}
		
		System.out.println(sb.toString());

	}

}
