//package com.JiviewsAutomation.SystemDefination_Test;
//
//
//	import org.testng.annotations.Test;
//	import com.AutomationJiviewsGeneric.BaseClass;
//	import com.AutomationJiviewsPOM.HomePage;
//	import com.AutomationJiviewsPOM.Maritime_Setup;
//	import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
//	import com.AutomationJiviewsPOM.jiviewsMainMenuItems;
//
//	public class Maritime_Setup_Test extends BaseClass {
//		
//		
//		Maritime_Setup mariTime;
//		
//		@Test(priority = 0)
//		public void setup() throws Exception {
//			
//			
//			
//			mariTime=new Maritime_Setup(driver);
//			mariTime.ou();
//			
//		}
//
//	
//		@Test(priority = 1)
//		public void verifyCreateBerth() throws Exception
//		{
//			mariTime.createBerth();
//		}
//		@Test(priority = 2)
//		public void verifyEditBerth() throws Exception
//		{
//			mariTime.editBerth();
//		}
//		@Test(priority = 3)
//		public void verifyDeleteBerth() throws Exception
//		{
//			mariTime.deleteBerth();
//		}
//		@Test(priority = 4)
//		public void verifyReActivate()throws Exception
//		{
//			mariTime.reActivate();
//		}
//		
//
//}
