package com.JiviewsAutomation.SystemDefination_Test;


import org.testng.annotations.Test;
import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.E10_2606_SystemDefinationShiftBandPage;


public class System_Defination_ShiftBandTest extends BaseClass
{
	E10_2606_SystemDefinationShiftBandPage shiftBand;

	@Test(priority = 1)
	public void E10_3115_VerifyCreateShiftBand() throws Exception 
	{
		shiftBand = new E10_2606_SystemDefinationShiftBandPage(driver);
		shiftBand.createShiftBand();
	}

	@Test(priority = 2)
	public void E10_3116_VerifyUpdateShiftBand() throws Exception 
	{
		shiftBand.updateShiftBand();
	}

	@Test(priority = 3)
	public void E10_3117_VerifyDeactivateShiftBand() throws Exception 
	{
		shiftBand.deactiveShiftBand();
	}
	@Test(priority = 4)
	public void E10_3118_VerifyReactivateShiftBand() throws Exception 
	{
		shiftBand.reactivateShiftBand();
	}
	@Test(priority = 5)
	public void E10_3119_VerifyWithoutShiftBandName() throws Exception 
	{
		shiftBand.withoutShiftBandName();
	}

	@Test(priority = 6)
	public void E10_3120_VerifyWithCombinationShift() throws Exception 
	{
		shiftBand.shiftBandTypeCombinationShift();
	}

	@Test(priority = 7)
	public void E10_3121_VerifyWithOvertimeShift() throws Exception 
	{
		shiftBand.shiftBandTypeOvertimeShift();
	}
}

