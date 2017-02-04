package registrationScheduler.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import registrationScheduler.store.Results;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * This class has the driver code
 * @author anmol
 *
 */

public class Driver{

	public static void main(String args[]) throws IOException, InterruptedException {

		int[] counter = new int[7];
		for(int i=0;i<counter.length;i++){
			counter[i]=60;
		}
		if(args.length < 4){
			System.out.println("Please enter all 4 arguments");
			System.exit(1);
		}else if(args.length > 4){
			System.out.println("Too many arguments!Please enter 4 arguments only");
			System.exit(1);
		}

		String inputFile = args[0];
		String outputFile = args[1];
		int NUM_THREADS=0;
		int debug_value=0;
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileInputStream is;
		InputStreamReader isr;
		
		try {
				is = new FileInputStream(inputFile);
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
		} catch (FileNotFoundException e){
			System.err.println("input.txt file is not present");
			System.exit(1);
		} 
		try{
			FileWriter fileWriter = new FileWriter(outputFile);
			bw = new BufferedWriter(fileWriter);
		}catch(IOException e){
			System.exit(1);
		}
		
		
		if(isInteger(args[2])){
			NUM_THREADS = Integer.parseInt(args[2]);
			if( NUM_THREADS < 1 || NUM_THREADS > 3){
				System.err.println("NUM_THREADS should be between 1 to 3");
				System.exit(1);
			}
		}
		else{
			System.err.println("NUM_THREADS should be an Integer");
			System.exit(1);
		}

		if(isInteger(args[3])){
			debug_value = Integer.parseInt(args[3]);
			if(debug_value < 0 || debug_value > 4){
				System.err.println("Debug value should be between 0 to 4");
				System.exit(1);
			}
		}
		else{
			System.err.println("Debug Value should be an Integer");
			System.exit(1);
		}
			
		FileProcessor fpobj = new FileProcessor();
		Logger.setDebugValue(debug_value);
		
		Results rsobj = new Results();
		
		CreateWorkers cw = new CreateWorkers(fpobj,br,rsobj);
		cw.startWorker(NUM_THREADS);
		
		if(0==debug_value){
			rsobj.averagePrint();
		}
		
		rsobj.writeScheduleToScreen();
		rsobj.writeScheduleToFile(bw,fpobj,outputFile);
		bw.close();
		
	} // end main(...)

	public static boolean isInteger(String s)
	{
		try{
			Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
} // end public class Driver
