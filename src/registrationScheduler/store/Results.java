package registrationScheduler.store;

import java.io.BufferedWriter;
import java.util.Vector;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * 
 * @author anmol
 *
 */
public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	
	private Vector <String> res = new Vector<String>();

	/**
	 * Method to print the result on screen
	 */
	public void writeScheduleToScreen() {
	
		for(int i=0; i < res.size(); i++) {  
			Logger.writeMessage(""+res.get(i), Logger.DebugLevel.CONTENTSRESULT);
			
		}
    }

	/**
	 * Method to add every line processed to the vector
	 */
	
	public void addResult(String s) {
		res.add(s);
	}
	
	/**
	 * Method to print the average preference score of all students
	 */
	public void averagePrint(){
		String intValue = null;
		int sum = 0;
		for(int i=0;i<res.size();i++){
			String line = res.get(i);
			intValue = line.substring(12).replaceAll("[^0-9]", "");
			int val = Integer.parseInt(intValue);
			sum = sum + val;
		}
		float average = (float)(sum/80);
		Logger.writeMessage("Average score is:"+average, Logger.DebugLevel.AVERARGESCORE);
	}
	
	/**
	 * Method to write the contents of result to file
	 */
	
	public void writeScheduleToFile(BufferedWriter bw ,FileProcessor fp, String outputFile) {
		for(int i=0; i < res.size(); i++) {
			fp.writeFile(bw,outputFile,res.get(i));
		}
	}
} 