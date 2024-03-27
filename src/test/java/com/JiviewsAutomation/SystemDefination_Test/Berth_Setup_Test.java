package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Berth_Setup;

public class Berth_Setup_Test extends BaseClass {

	private static final Logger logger = Logger.getLogger(Berth_Setup_Test.class.getName());
	public Berth_Setup bt;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateBerth() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyCreateBerth");
		bt=new Berth_Setup(driver);
		bt.createBerth();
		logger.info("Test System_Defination_VerifyCreateBerth is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyEditBerth() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyEditBerth");
		bt.editBerth();
		logger.info("Test System_Defination_VerifyEditBerth is successful");
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeleteBerth() throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyDeleteBerth");
		bt.deleteBerth();
		logger.info("Test System_Defination_VerifyDeleteBerth is successful");
	}

	@Test(priority = 4)
	public void System_Defination_VerifyReActivate()throws Exception
	{
		logger.info("Starting test: System_Defination_VerifyReActivate");
		bt.reActivate();
		logger.info("Test System_Defination_VerifyReActivate is successful");
	}



}
