package com.JiviewsAutomation.SystemDefination_Test;


	import org.testng.annotations.Test;
	import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.Berth_Setup;
import com.AutomationJiviewsPOM.HomePage;
	import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
	import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

	public class Berth_Setup_Test extends BaseClass {
		
		
		Berth_Setup bt;
		 
		@Test(priority = 1)
		public void System_Defination_VerifyCreateBerth() throws Exception
		{
			bt=new Berth_Setup(driver);
	 
			bt.createBerth();
		}
		
		@Test(priority = 2)
		public void System_Defination_VerifyEditBerth() throws Exception
		{
			bt.editBerth();
		}
		
		@Test(priority = 3)
		public void System_Defination_VerifyDeleteBerth() throws Exception
		{
			bt.deleteBerth();
		}
		
		@Test(priority = 4)
		public void System_Defination_VerifyReActivate()throws Exception
		{
			bt.reActivate();
		}
	 
		

}
