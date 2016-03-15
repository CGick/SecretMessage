package secretMessage;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		
		String message;
		int key;
	
		System.out.println("Enter a message: ");
		message = keyboard.nextLine();
		System.out.println("Enter a number between 1 and 100");
		key = keyboard.nextInt();
		
		StringBuilder sb = new StringBuilder(message);
		
		for(int i = 0; i < sb.length(); i++){
			sb.setCharAt(i, (char)( sb.charAt(i)+ key));
		}
		
		FileOutputStream fos = new FileOutputStream("secret.msg");
		DataOutputStream dos = new DataOutputStream(fos);
		
//		RandomAccessFile raf = new RandomAccessFile("secret.msg", "rw");

		dos.writeInt(key);
		dos.writeUTF(sb.toString());
		dos.close();
	}

}
