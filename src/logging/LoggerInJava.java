package logging;
import java.util.logging.Level;
import java.util.logging.Logger;

// logger class
class SampleLogger{
	// create a logger in java
	static Logger logger = Logger.getLogger(LoggerInJava.class.getName());
	// method to use log
	public void createSampleLog() {
		logger.log(Level.WARNING, "Warning from SampleLogger class...");
		logger.info("Logger info in SmapleLogger class...");
	}
	
	// log handlers - 1. FileHandler to write a log to file and 2. consoleHanlder to write to console
	
}

public class LoggerInJava {
		// define a generic array creation method
	public static int[] createArray(int[] arr) {
		return arr;
	}

	public static void main(String[] args) {
		// call logger class
		SampleLogger logger = new SampleLogger();
		logger.createSampleLog();
	}
}

