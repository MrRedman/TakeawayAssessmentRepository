package com.takeaway.assessment.runner.Steps;

import com.takeaway.assessment.Utility.LoggerClass;
import com.takeaway.assessment.Utility.PropertiesReader;
import com.vimalselvam.cucumber.listener.Reporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.takeaway.assessment.BusinessLogic.Accessors;
import com.takeaway.assessment.BusinessLogic.CommonMethod;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ParentStep extends PropertiesReader{

	CommonMethod common = new CommonMethod();	
	Accessors accessors = new Accessors();
	Logger log = Logger.getLogger(LoggerClass.class);
	static Properties currProp;
	static Properties prop;
	private static String execId;
	public static String executionId = execId;
	public static String TCList;
	public static String environment;
	public static int count=0;
	public static String PrevTCID = "";
	public static List<String> TestSuite = new ArrayList<String>();
	
	
	//Dont need this
	public ParentStep() {
		prop = new Properties();
		prop = PropertiesReader.loadProperties("Environment_"+environment);			
	}
	
	@Before
	public static Properties loadEnvironment() {
		currProp = new Properties();
		return PropertiesReader.loadProperties("Environment_"+environment);	
	}
	
	
	@Before("@Counter")
	public void initialSetup(Scenario scenario) {
		int i = 0;

		for(String tag : scenario.getSourceTagNames()){
			if(tag.contains("TC")){
			System.setProperty("TestID", tag.substring(1));
			accessors.setTestCaseName(tag.substring(1));
			}

	           i++;
	       }
	
	//initialise iteration counter	
	countScenarioOutlineRows();
	int iterLog=0;
	iterLog = count + 1;
	log.info("##########################################################################################################");
	log.info("Scenario Name : " + scenario.getName());
	log.info("Test Case Id : " + accessors.getTestCaseName());
	log.info("Iteration : " + iterLog );
	log.info("##########################################################################################################");
	Reporter.addScenarioLog("Scenario Name : " + scenario.getName());
	Reporter.addScenarioLog("Test Case Id : " + accessors.getTestCaseName());
	Reporter.addScenarioLog("Iteration : " + iterLog);
	
	//initialise step number
	accessors.setParentStepNo(1);
		

	}
	
	public void countScenarioOutlineRows() {	
		
		//set iteration counter
		if(System.getProperty("PrevTCID")==null) System.setProperty("PrevTCID", PrevTCID);
		if (System.getProperty("PrevTCID").equals(accessors.getTestCaseName())) {
			count++;
			//System.setProperty("iteration",""+ count+"");.
			accessors.setIterationId(count);
		}
	    else{
	    	count = 0;
	    	//initialize iteration counter	       	
	    	accessors.setIterationId(count);
		}

	}
	
	@After
	public void cleanup(Scenario scenario) {
		common.closeBrowser();
		System.setProperty("PrevTCID", accessors.getTestCaseName());
		log.info("Scenario Status : " + (scenario.getStatus()).toUpperCase());
		accessors.setStatus((scenario.getStatus()).toUpperCase());
		log.info("##########################################################################################################");
		TestSuite.add(accessors.getApplicationName()+","+accessors.getReleaseNumber()+","+accessors.getTestCaseName()+","+accessors.getIteration()+","+accessors.getStepId()+","+accessors.getStatus());
	}
	
	public static String getProperty(String string) {
		// TODO Auto-generated method stub
		return prop.getProperty(string);
	}
	
}
