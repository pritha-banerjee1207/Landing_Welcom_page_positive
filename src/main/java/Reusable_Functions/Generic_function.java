package Reusable_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Generic_function {
	public static WebDriver driver=null;
	public static XSSFWorkbook workbook;
	public static XSSFWorkbook workbook1;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	public static int s=1;
	public static String Locator_value;
	static File file = new File("configuration/config.properties");
	static Properties prop = new Properties();

	/*Loading config.properties file to read driver path,URL etc and For launching the browser*/
	public static WebDriver BrowserLaunch() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		System.setProperty("webdriver.gecko.driver",getDriverPath());
		driver =new FirefoxDriver();
		driver.navigate().to(getURL());
		driver.manage().window().maximize();
		return driver;
	}

	/* Reading chrome driver path from config.properties file */
	public static String getDriverPath() {
		String driverpath= prop.getProperty("Driverpath");
		if(driverpath!=null) return driverpath ;
		else throw new RuntimeException ("Driverpath is not specified in the Config.properties");
	}

	/* Reading URL from config.properties file */
	public static String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}

	/* Reading Excel sheet file path  from config.properties   */
	private static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}
	/*Test Data reader for reading data from excel sheet*/
	public static String td_reader(String fieldname, int iter,String sheetname) throws IOException {
		File src=new File(getFilepath());
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		String td_value = sheet.getRow(findRow(fieldname, sheetname)).getCell(iter).getStringCellValue();
		return td_value;            

	}
	/* return the row for particular field name in excel sheet*/
	public static int findRow(String fieldname,String sheetname) throws IOException {
		File src=new File(getFilepath());
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getRichStringCellValue().getString().trim().equals(fieldname)) {
					return row.getRowNum();  
				}
			}
		}      
		return 0;
	}

	/*  Taking Screenshot of failed test cases  */
	public static  void takeScreenShot(WebDriver driver,String fileName) throws IOException{
		driver.manage().window().maximize();
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
	}

	/*To get directory path of screenshots*/
	public static  String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}

	/*Object Locator reader from Excel sheet*/
	public static  String OR_reader(String sheetname,String Fieldname) throws IOException  {
		File src=new File(getFilepath());
		FileInputStream finput;
		finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		for(int i=1;i<rowCount;i++) {
			cell = sheet.getRow(i).getCell(0);
			CellData = cell.getStringCellValue();
			if(CellData.equals(Fieldname))
			{
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();
				break;
			}
			else
			{
				continue;
			}
		}
		return path;
	}

	/*Generic Click function*/
	public static void click(String objname) throws IOException {
		driver.findElement(By.xpath(OR_reader("Object Locator", objname))).click();

	}

	/*Close the opened driver*/
	public static void driverClose() {
		driver.close(); 
	}
}
