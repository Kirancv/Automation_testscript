package com.sgsoftware.actitime.testscripts;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sgsoftware.actitime.driverscript.DriverScript;
import com.sgsoftware.actitime.utility.ApplicationDependent;

public class LoginLogout extends DriverScript{
	/**
	 * Author:
	 * Reviewer:
	 * Reviewed Date:
	 * @param 
	 * @return 
	 * purpose:
	 * Description:
	 */
	public static String login(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String arrTestData[]=null;
		String arrObjectMap[]=null;
		String sScriptStatus="Fail";
		try
		{
			log.info("the method login execution started here...");
			String sExpected=oExpectedResult.getProperty(sExpectedResultColumn);
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			arrObjectMap=pattern.split(sObjectMapColumn);
			
			String user=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[0], 2);
			String pwd=oDatatable.getCellData(sScenarioExcelFile, "testdata", arrTestData[1], 2);
			
			oBrowser.findElement(oObjectMap.getLocator(arrObjectMap[0])).sendKeys(user);
			oBrowser.findElement(oObjectMap.getLocator(arrObjectMap[1])).sendKeys(pwd);
			oBrowser.findElement(oObjectMap.getLocator(arrObjectMap[2])).click();
			Thread.sleep(5000);
			By by=By.xpath("//td[text()='"+sExpected+"']");
			if (ApplicationDependent.isObjectPresent(by)==true)
			{
				sScriptStatus="Pass";
			}
			log.info("the method login execution ended here...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the login ..."+e);
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
	public static String logout(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String arrObjectMap[]=null;
		String sExpected,sActual;
		String sScriptStatus="Fail";
		try
		{
			log.info("the method logout execution started here...");
			sExpected=oExpectedResult.getProperty(sExpectedResultColumn);
			pattern=Pattern.compile(",");
			
			arrObjectMap=pattern.split(sObjectMapColumn);
			oBrowser.findElement(oObjectMap.getLocator(arrObjectMap[0])).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			sActual=oBrowser.getTitle();
			if (sExpected.equals(sActual))
			{
				sScriptStatus="Pass";
			}
			log.info("the method logout execution ended here...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the logout ..."+e);
		}
		return sScriptStatus;
	}

}
