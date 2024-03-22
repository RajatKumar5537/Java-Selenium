package com.JiviewsAutomation.SystemDefination_Test;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2639_SystemDefinationSCRPage;

public class System_Defination_SCRTest extends BaseClass
{

	E10_2639_SystemDefinationSCRPage scr;

	@Test(priority = 1)
	public void E10_3131_VerifyCreateSCR() throws Exception 
	{

		scr= new E10_2639_SystemDefinationSCRPage(driver);
		scr.createSCR();
	}

	@Test(priority = 2)
	public void E10_3132_VerifyUpdateSCR() throws Exception 
	{
		scr.setUpdateSCR();
	}

	@Test(priority = 3) 
	public void E10_3133_VerifyDeactivateSCR() throws Exception 
	{
		scr.setDeactivateSCR();
	}

	@Test(priority = 4)
	public void E10_3134_VerifyReactivateSCR() throws Exception 
	{
		scr.setReactivateSCR();
	}
}
