package extentReports;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.util.ReadPropertyFile;

public class ExtentManager {
	static ExtentReports extent;
	public static Properties prop;
	public static String reportDirectory;
	static ReadPropertyFile readPro = new ReadPropertyFile();
	 public static String suiteName = "UnknownSuite";
	        
	public static synchronized ExtentReports createInstance() {
		DateFormat dateformat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		
		reportDirectory = System.getProperty("user.dir");
		File reportFolder = new File(reportDirectory + "\\Report");
		
		if (!reportFolder.exists()) {
			reportFolder.mkdirs();
		}
		


        try {
            String suiteFile = System.getProperty("suiteXmlFile");   
            String rawName = suiteFile.replace(".xml", "");    

            if (rawName.toLowerCase().contains("datasetup")) {
                suiteName = "DataSetUp_";
            } 
            else if (rawName.contains("ALT_")) {
                suiteName = rawName.replace("ALT_", "")+"_";        
            } 
            else {
                suiteName = "";                           
            }
        }
        catch (Exception e) {
            suiteName = "UnknownSuite";
        }

		if(System.getProperty("env")!=null) {
			
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportDirectory+
				"\\Report\\" +suiteName+ System.getProperty("env")/* + "-"  +dateformat.format(date) */ +".html") ;
		
		
        sparkReporter.config().setReportName("Automation Testing");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		}
		else {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportDirectory+
					"\\Report\\" +  "New_Report-" +dateformat.format(date)  +".html") ;
			sparkReporter.config().setReportName("Automation Testing");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		return extent;

	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}
}