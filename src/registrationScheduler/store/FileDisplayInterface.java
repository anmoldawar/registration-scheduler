package registrationScheduler.store;

import java.io.BufferedWriter;

import registrationScheduler.util.FileProcessor;

/**
 * @author anmol
 */

public interface FileDisplayInterface {
    public void writeScheduleToFile(BufferedWriter bw,FileProcessor fp ,String s);
}
