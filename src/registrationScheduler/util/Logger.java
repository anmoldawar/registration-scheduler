package registrationScheduler.util;

/**
 * 
 * @author anmol
 *
 */

public class Logger{
    public static enum DebugLevel {CONSTRUCTOR , RUNMETHOD,ENTRYTORESULT,CONTENTSRESULT, AVERARGESCORE 
                                   };

    private static DebugLevel debugLevel;

    /**Method to set the debuglevel to thier corresponding enum
     * 
     * @param levelIn - integer value taken from command line
     */
   
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
    		case 3: debugLevel = DebugLevel.RUNMETHOD; break;
    		case 2: debugLevel = DebugLevel.ENTRYTORESULT; break;
    		case 1: debugLevel = DebugLevel.CONTENTSRESULT; break;
    		case 0: debugLevel = DebugLevel.AVERARGESCORE; break;
		}
    }

    /**Method to set the debug level value
     * 
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }
    
    /**
     * 
     * @param message- message to be printed
     * @param levelIn- enum value corresponding to that integer
     */
    public synchronized static void writeMessage (String message  , DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
