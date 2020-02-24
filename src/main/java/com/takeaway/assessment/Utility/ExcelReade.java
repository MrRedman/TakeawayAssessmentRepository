package com.takeaway.assessment.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.takeaway.assessment.BusinessLogic.Accessors;

public class ExcelReade {

	String data;
	Sheet sheet;
	File file;
	FileInputStream fis;
	Workbook workbook;
	static Accessors accessors = new Accessors();
    public Row row = null;


	public static Map<String, String> readDataFromSheet(String FileName,String sheetname, String testcaseID) throws IOException{

	       FileInputStream fio = new FileInputStream(new File(System.getProperty("user.dir")+ "/src/test/resources/TestData/" + FileName + ".xlsx"));

	       XSSFWorkbook workbook = new XSSFWorkbook(fio);
	       
	       Map<String, String> book = new HashMap<String, String>();
	       DataFormatter formatter = new DataFormatter();
	       
	    
	       XSSFSheet sheet = workbook.getSheet(sheetname);
	       
	       boolean flag=false;
	       for(int i=0;i<=sheet.getLastRowNum();i++)
	       {
	              String TCId = formatter.formatCellValue(sheet.getRow(i).getCell(0));
	              if(TCId.equalsIgnoreCase(testcaseID)) {
	            		
	            	  i = i + accessors.getIteration();
	            	  
	              for(int j=1 ; j<=sheet.getRow(0).getLastCellNum() ; j++){
	                    
	                    if (!formatter.formatCellValue(sheet.getRow(i).getCell(j)).equals("")){

	                    	 book.put(formatter.formatCellValue(sheet.getRow(0).getCell(j)), formatter.formatCellValue(sheet.getRow(i).getCell(j)));
	                    }
	                    else{
	                           flag=true;
	                           break;
	                    }
	              }
	              if(flag){
	                    break;
	              }
	              
	       }
	       }
	    return book;
	    }

}
