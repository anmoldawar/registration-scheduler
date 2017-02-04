package registrationScheduler.threadMgmt;

import java.io.BufferedReader;
import registrationScheduler.store.Scheduling;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * 
 * @author anmol
 *
 */

public class WorkerThread implements Runnable  {

	private FileProcessor fpobj;
	private BufferedReader br;
	private StdoutDisplayInterface robj;
	private int num_thread;
	private String line=null;
	private String str=null;
	
	Scheduling sc=new Scheduling();
	
	/**
	 * Constructor for WorkerThread
	 * @param i - Thread number
	 * @param brIn - reference to BufferedReader Stream 
	 * @param ms - reference to MusicStore class
	 * @param rbjIn - reference to StdoutDisplayInterface
	 * @param fpIn - reference to FileProcessor class
	 */
	public WorkerThread(int i,FileProcessor fpIn, BufferedReader brIn, StdoutDisplayInterface robjIn){
		Logger.writeMessage("Constructor of WorkerThread called", Logger.DebugLevel.CONSTRUCTOR);
		num_thread = i;
		fpobj = fpIn;
		br = brIn;
		robj = robjIn;
	}

	/**
	 * run() method of WorkerThread class which implements runnable
	 * This method reads from the input file ,allocates the courses
	 * and stores them in data structure of Result class.
	 */
    public void run(){	
    	Logger.writeMessage("Run Method called", Logger.DebugLevel.RUNMETHOD);
    		while((line = fpobj.readFile(br)) != null){
    			str = sc.scheduleCourses(line);
    			robj.addResult(str);
    			Logger.writeMessage("Entry added to result", Logger.DebugLevel.ENTRYTORESULT);
		   }
    }
    
    @Override
	public String toString() {
		return super.toString();
	}
}