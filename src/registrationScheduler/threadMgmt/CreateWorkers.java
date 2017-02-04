package registrationScheduler.threadMgmt;

import java.io.BufferedReader;

//import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * 
 * @author anmol
 *
 */
public class CreateWorkers  {

	private FileProcessor fp;
	private BufferedReader br;
	private StdoutDisplayInterface robj;
	/**
	* Constructor of CreateWorker
	* @param fpobjIn  - reference to FileProcessor class
	* @param brIn - reference to BufferedReader stream
	* @param rsobjIn - reference to StdoutDisplayInterface
	*/
	public CreateWorkers(FileProcessor fpobjIn, BufferedReader brIn, StdoutDisplayInterface rsobjIn){
		Logger.writeMessage("Constructor of CreateWorker called", Logger.DebugLevel.CONSTRUCTOR);
		fp = fpobjIn;
		br = brIn;
		robj = rsobjIn;
	}
	
	/**
	* Method for making n number of threads and joining them
	* @param n - number of threads 
	*/
	public void startWorker(int n) throws InterruptedException{
		Thread[] t = new Thread[n];
		for(int i=0;i<n;i++){
			WorkerThread wtobj = new WorkerThread(i,fp,br,robj);
			t[i] = new Thread(wtobj);
			t[i].start();
		}
		
		for(int i=0;i<n;i++){
			try {
				t[i].join();
			}catch (InterruptedException e) {
				System.exit(1);
			}
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}