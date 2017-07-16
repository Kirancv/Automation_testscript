package com.sgsoftware.actitime.testscripts;

import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sgsoftware.actitime.driverscript.DriverScript;
import com.sgsoftware.actitime.utility.ApplicationDependent;

public class Users extends DriverScript{
	public static String firstName=null;
	public static String lastName=null;
	/**
	 * Author:
	 * Reviewer:
	 * Reviewed Date:
	 * @param 
	 * @return 
	 * purpose:
	 * Description:
	 */
	public static String createUser(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String arrTestData[]=null;
		String sScriptStatus="Fail";
		try
		{
			log.info("the method createUser execution started here...");
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			firstName=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[0], 2);
			lastName=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[1], 2);
			String email=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[2], 2);
			String username=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[3], 2);
			String password=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[4], 2);
			String passwordCopy=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[5], 2);
			
			
			oBrowser.findElement(By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath(".//*[@id='createUserDiv']/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.name("firstName")).sendKeys(firstName);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("lastName")).sendKeys(lastName);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("email")).sendKeys(email);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("username")).sendKeys(username);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(passwordCopy);
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_commitBtn")).click();
			Thread.sleep(5000);
			String userName=lastName+", "+firstName;
			By by=By.xpath("//span[text()='"+userName+"']");
			if (ApplicationDependent.isObjectPresent(by)==true)
			{
				sScriptStatus="Pass";
			}
			log.info("the method createUser execution ended here...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the createUser ..."+e);
		}
		return sScriptStatus;
	}
	
	/**
	 * Author:
	 * Reviewer:
	 * Reviewed Date:
	 * @param 
	 * @return 
	 * purpose:
	 * Description:
	 */
	public static String modifyUser(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String arrTestData[]=null;
		String sExpected,sActual;
		String sScriptStatus="Fail";
		try
		{
			log.info("the method modifyUser execution started here...");
			sExpected=oExpectedResult.getProperty(sExpectedResultColumn);
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			
			String password=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[1], 2);
			String passwordCopy=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[2], 2);
			
			oBrowser.findElement(By.xpath("//span[text()='User1, demo']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(passwordCopy);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(5000);
			sActual=oBrowser.getTitle();
			if (sExpected.equals(sActual))
			{
				sScriptStatus="Pass";
			}
			log.info("the method modifyUser execution ended here...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the modifyUser ..."+e);
		}
		return sScriptStatus;
	}
	
	/**
	 * Author:
	 * Reviewer:
	 * Reviewed Date:
	 * @param 
	 * @return 
	 * purpose:
	 * Description:
	 */
	public static String deleteUser(WebDriver oBrowser)
	{
		String sScriptStatus="Fail";
		try
		{
			String sExpected=oExpectedResult.getProperty(sExpectedResultColumn);
			String userName=lastName+", "+firstName;
			log.info("the method deleteUser execution started here...");
			oBrowser.findElement(By.xpath("//span[text()='"+userName+"']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			boolean fisrtvalidation=ApplicationDependent.isAlertPresent();
			Alert alert=oBrowser.switchTo().alert();
			String sActual=alert.getText();
			boolean secondvalidation=sExpected.equals(sActual);
			alert.accept();
			Thread.sleep(5000);
					
			if((fisrtvalidation==true) && (secondvalidation==true))
			{
				sScriptStatus="Pass";
			}
			log.info("the method deleteUser execution ended here...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the deleteUser ..."+e);
		}
		return sScriptStatus;
	}

}
