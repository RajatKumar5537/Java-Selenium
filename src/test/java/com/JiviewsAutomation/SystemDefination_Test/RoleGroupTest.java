package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleGroupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class RoleGroupTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(RoleGroupTest.class);

    private HomePage hp;
    private OrganizationUnitDropDown oudd;
    private jiviewsMainMenuItems jmmi;
    private EmployeeSetupPage esp;
    private SystemDefinationRoleGroupPage sdrg;

    @BeforeMethod
    public void setUp() throws Exception {
        hp = new HomePage(driver);
        oudd = new OrganizationUnitDropDown(driver);
        jmmi = new jiviewsMainMenuItems(driver);
        esp = new EmployeeSetupPage(driver);
        sdrg = new SystemDefinationRoleGroupPage(driver);

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRoleGroups();
    }

    @Test(priority = 1)
    public void verifyCreateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create Role Group");

        sdrg.createRolesGroup();
    }

    @Test(priority = 2)
    public void verifyUpdateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Update Role Group");

        sdrg.updateRolesGroup();
    }

    @Test(priority = 3)
    public void verifyDeactivateRoleGroups() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Deactivate Role Group");

        sdrg.deactivateRoleGroup();
    }

    @Test(priority = 4)
    public void verifyCreateRoleGrpWithoutAvailableRole() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create role group without available role Group");

        sdrg.createRoleGrpWithoutAvailableRole();
    }

    @Test(priority = 5)
    public void verifySearchRoleGroup() throws Exception {
        logger.info("Create role group without available role Group");

        sdrg.searchRoleGroup();
    }

    @Test(priority = 6)
    public void verifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
        captureScreenshot(driver, "RoleGroupTest");
        logger.info("Create role group without role group name");

        sdrg.createRoleGrpWithoutRoleGrpName();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);

	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public SystemDefinationRoleGroupPage sdrg;
	

	@Test(priority = 1)
	public void verifyCreateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create Role Group");
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRolesGroup();
	}
	@Test (priority = 2)
	public void verifyUpdateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Update Role Group");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setUpdateRolesGroup();
	}
	
	@Test (priority = 3)
	public void verifyDeactivateRoleGroups() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Deactivate Role Group");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setDeactivateRoleGroup();
	}
	
	@Test (priority = 4)
	public void verifyCreateRoleGrpWithoutAvailableRole() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without available role Group");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRoleGrpWithoutAvailableRole();
	}
	
	@Test (priority = 5)
	public void verifySearchRoleGroup() throws Exception {
		logger.info("Create role group without available role Group");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		Thread.sleep(1000);
		hp.setOrgUnit();
		Thread.sleep(1000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setSearchRoleGroup();
	}
	@Test (priority = 6)
	public void verifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without role group name");
//		driver.navigate().refresh();
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		Thread.sleep(2000);
		hp.setOrgUnit();
		Thread.sleep(2000);
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRoleGrpWithoutRoleGrpName();
	}
	
	
	
	
	
	// @BeforeClass And @AfterClass
	/*@Test(priority = 1)
	public void verifyCreateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create Role Group");
		
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRoleGroups();
		sdrg.setCreateRolesGroup();
		
		
//		logger.info("Update Role Group");
//		esp.setCreateRoleGroups();
//		sdrg.setUpdateRolesGroup();
	}
	@Test (priority = 2) //,dependsOnMethods = "verifyCreateRoleGrpWithoutRoleGrpName")
	public void verifyUpdateRoleGroups ()throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Update Role Group");
		
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(2000);
		esp.setCreateRoleGroups();
		Thread.sleep(2000);
		sdrg.setUpdateRolesGroup();
	}
	
	@Test (priority = 3) //, dependsOnMethods = "verifyUpdateRoleGroups")
	public void verifyDeactivateRoleGroups() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Deactivate Role Group");
		
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(2000);
		esp.setCreateRoleGroups();
		Thread.sleep(2000);
		sdrg.setDeactivateRoleGroup();
	}
	
	@Test (priority = 4) //, dependsOnMethods = "verifyDeactivateRoleGroups")
	public void verifyCreateRoleGrpWithoutAvailableRole() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without available role Group");
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(2000);
		esp.setCreateRoleGroups();
		Thread.sleep(2000);
		sdrg.setCreateRoleGrpWithoutAvailableRole();
	}
	
	@Test (priority = 5) //, dependsOnMethods = "verifyCreateRoleGrpWithoutAvailableRole")
	public void verifySearchRoleGroup() throws Exception {
		logger.info("Create role group without available role Group");
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(2000);
		esp.setCreateRoleGroups();
		Thread.sleep(2000);
		sdrg.setSearchRoleGroup();
	}
	@Test (priority = 6) // , dependsOnMethods = "verifySearchRoleGroup")
	public void verifyCreateRoleGrpWithoutRoleGrpName() throws Exception {
		captureScreenshot(driver, "roleGroupTest");
		logger.info("Create role group without role group name");
		esp= new EmployeeSetupPage(driver);
		sdrg= new SystemDefinationRoleGroupPage(driver);
		Thread.sleep(2000);
		esp.setCreateRoleGroups();
		Thread.sleep(2000);
		sdrg.setCreateRoleGrpWithoutRoleGrpName();
	}
	*/
}
