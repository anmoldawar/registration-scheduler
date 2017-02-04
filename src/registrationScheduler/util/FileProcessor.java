package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileProcessor {
	private String str=null;
	
	public synchronized String readFile(BufferedReader br2){
		try {
			str = br2.readLine();
		} catch (IOException e) {
			System.out.println("Error while reading file");
			System.exit(1);
		}
		return str;
	}

	public synchronized void writeFile(BufferedWriter bw, String outputFile,String data){
		
		try{
			bw.write(data);
			
		}catch(IOException e){
				e.printStackTrace();	
		}
	}

	
	@Override
	public String toString() {
		return super.toString();
	}
	
}