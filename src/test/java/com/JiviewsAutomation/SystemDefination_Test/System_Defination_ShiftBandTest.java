package com.JiviewsAutomation.SystemDefination_Test;


import java.util.logging.Logger;

import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2606_SystemDefinationShiftBandPage;


public class System_Defination_ShiftBandTest extends BaseClass
{
	private static final Logger logger = Logger.getLogger(System_Defination_ShiftBandTest.class.getName());
	public E10_2606_SystemDefinationShiftBandPage shiftBand;

	@Test(priority = 1)
	public void System_Defination_VerifyCreateShiftBand() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyCreateShiftBand");
		shiftBand = new E10_2606_SystemDefinationShiftBandPage(driver);
		shiftBand.createShiftBand();
		logger.info("Test System_Defination_VerifyCreateShiftBand is successful");
	}

	@Test(priority = 2)
	public void System_Defination_VerifyUpdateShiftBand() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyUpdateShiftBand");
		shiftBand.updateShiftBand();
		logger.info("Test System_Defination_VerifyUpdateShiftBand is successful");
	}

	@Test(priority = 3)
	public void System_Defination_VerifyDeactivateShiftBand() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyDeactivateShiftBand");
		shiftBand.deactiveShiftBand();
		logger.info("Test System_Defination_VerifyDeactivateShiftBand is successful");
	}
	@Test(priority = 4)
	public void System_Defination_VerifyReactivateShiftBand() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyReactivateShiftBand");
		shiftBand.reactivateShiftBand();
		logger.info("Test System_Defination_VerifyReactivateShiftBand is successful");
	}
	@Test(priority = 5)
	public void System_Defination_VerifyWithoutShiftBandName() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyWithoutShiftBandName");
		shiftBand.withoutShiftBandName();
		logger.info("Test System_Defination_VerifyWithoutShiftBandName is successful");
	}

	@Test(priority = 6)
	public void System_Defination_VerifyWithCombinationShift() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyWithCombinationShift");
		shiftBand.shiftBandTypeCombinationShift();
		logger.info("Test System_Defination_VerifyWithCombinationShift is successful");
	}

	@Test(priority = 7)
	public void System_Defination_VerifyWithOvertimeShift() throws Exception 
	{
		logger.info("Starting test: System_Defination_VerifyWithOvertimeShift");
		shiftBand.shiftBandTypeOvertimeShift();
		logger.info("Test System_Defination_VerifyWithOvertimeShift is successful");
	}
}

