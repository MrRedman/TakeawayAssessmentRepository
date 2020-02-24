package com.takeaway.assessment.runner;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.takeaway.assessment.BusinessLogic.CommonMethod;
import com.takeaway.assessment.BusinessLogic.ProjectAccessors;
import com.takeaway.assessment.runner.Steps.*;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/*
 * 
 * Runner class - Running using TestNG
 * 
 * Cucumber options can be set here - if you want to run selective tests locally, tags option can be utilised
 * 
 * current tag option - will only execute TC_01 and TC_02
 * 
 * */

@CucumberOptions(tags={"@TC_01,@TC_02"},features = "src/test/java/com/takeaway/assessment/runner/Features/", 
glue = {"com.takeaway.assessment.runner.Steps"},plugin= {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}, strict=true, dryRun=false, monochrome = true)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
	

	ExtentProperties extentProperties = ExtentProperties.INSTANCE;	
	ProjectAccessors pAccessor = new ProjectAccessors();
	CommonMethod commonMethod = new CommonMethod();
	

	@BeforeClass
	public void setUp() {
				
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\CurrentExecution.properties")));
			
		} catch (FileNotFoundException e) {
			System.out.println("CurrentExecution.properties file is not found. " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception in file handling. " + e.getMessage());
			e.printStackTrace();
		}

		ParentStep.environment = properties.getProperty("Environment");

	
		String sTimeStamp = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());
		String sReportPath = System.getProperty("user.dir") + "\\Reports" + "\\Run_"+ sTimeStamp;
		File reportDir = new File(sReportPath);
		System.setProperty("ReportPath", sReportPath);
		System.setProperty("logfile.name",sReportPath + "\\Logger.log");
		if(!reportDir.exists()) {
			reportDir.mkdir();
		}
		pAccessor.setApplicationName(properties.getProperty("ApplicationName"));
		extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(reportDir + "\\Run_" + sTimeStamp + ".html");
		extentProperties.setProjectName(pAccessor.getApplicationName());
		extentProperties.setProjectName("Takeaway");
		
	}
	
	@AfterClass
	public void writeReport() throws IOException {
	
		Reporter.loadXMLConfig(System.getProperty("user.dir") + "/src/test/resources/extentReportConfig/extentConfig.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", InetAddress.getLocalHost().getHostName());
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File((System.getProperty("user.dir") + "/src/test/resources/propertiesFile/maven.properties"))));

		Reporter.setSystemInfo("Maven", properties.getProperty("maven.compiler.version"));
		Reporter.setSystemInfo("Java Version", properties.getProperty("java.version"));
		Reporter.setSystemInfo("Selenium Version", properties.getProperty("selenium.version"));
		Reporter.setSystemInfo("Cucumber Version", properties.getProperty("cucumber.version"));
	}

}
