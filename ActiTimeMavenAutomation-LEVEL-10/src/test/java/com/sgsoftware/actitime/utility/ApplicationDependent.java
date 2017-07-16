package com.sgsoftware.actitime.utility;

import org.openqa.selenium.By;

import com.sgsoftware.actitime.driverscript.DriverScript;

public class ApplicationDependent extends DriverScript{
	
	/**
	 * Author:
	 * Reviewer:
	 * Reviewed Date:
	 * @param 
	 * @return 
	 * purpose:
	 * Description:
	 */
	public static boolean isObjectPresent(By by)
	{
		try
		{
			oBrowser.findElement(by);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
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
	public static boolean isAlertPresent()
	{
		try
		{
			oBrowser.switchTo().alert();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

}
