package com.JiviewsAutomation.SystemDefination_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationJiviewsGeneric.BaseClass;
import com.AutomationJiviewsPOM.EmployeeSetupPage;
import com.AutomationJiviewsPOM.HomePage;
import com.AutomationJiviewsPOM.OrganizationUnitDropDown;
import com.AutomationJiviewsPOM.SystemDefinationRoleSetupPage;
import com.AutomationJiviewsPOM.jiviewsMainMenuItems;

public class RoleSetUpTest extends BaseClass{
	
	private static final Logger logger = LogManager.getLogger(RoleSetUpTest.class);
    public HomePage hp;
    public OrganizationUnitDropDown oudd;
    public jiviewsMainMenuItems jmmi;
    public EmployeeSetupPage esp;
    public SystemDefinationRoleSetupPage sdrs;

    @BeforeMethod
    public void setup() {
        hp = new HomePage(driver);
        oudd = new OrganizationUnitDropDown(driver);
        jmmi = new jiviewsMainMenuItems(driver);
        esp = new EmployeeSetupPage(driver);
        sdrs = new SystemDefinationRoleSetupPage(driver);
    }

    @Test
    public void verifyCreateNewRole() throws Exception {
        captureScreenshot(driver, "roleSetUpTest");
        logger.info("Create a new Skill");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setCreateNewRole();

        logger.info("verify Create a new role is successful");
    }

    @Test
    public void verifyUpdateRole() throws Exception{
        captureScreenshot(driver, "roleSetUpTest");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setUpdateRole();

        logger.info("Verify Update Role successful");
    }

    @Test
    public void verifyDeactiveRole() throws Exception{
        captureScreenshot(driver, "roleSetUpTest");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setDeactiveRole();

        logger.info("Verify Deactive Role is successful");
    }

    @Test
    public void verifyReactiveRole() throws Exception{
        captureScreenshot(driver, "roleSetUpTest");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setReactiveRole();

        logger.info("Verify Reactive Role is successful");
    }

    @Test
    public void verifyCreateRoleWithAllAvailableSkill()throws Exception {
        captureScreenshot(driver, "roleSetUpTest");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setCreateNewRoleWithAllAvailableSkill();

        logger.info("Verify create a role with all available skill");
    }

    @Test
    public void verifyDisselectAllAvailableSkill() throws Exception{
        captureScreenshot(driver, "roleSetUpTest");

        hp.setOrgUnit();
        oudd.setAutoOu();
        jmmi.clickOnSystemDefination();
        esp.setCreateRole();
        sdrs.setDisselectAllAvailableSkill();

        logger.info("Verify disselect all available skill");
    }
	
    @Test  
	public void verifySearchColumnsForRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setSearchColumnsForRole();
		logger.info("verify Search Columns For Role is successfull");
	}
	
	
	
	
	
	
	
	
	/*
	private static final Logger logger = LogManager.getLogger(skillSetUpTest.class);
	public HomePage hp;
	public OrganizationUnitDropDown oudd;
	public jiviewsMainMenuItems jmmi;
	public EmployeeSetupPage esp;
	public SystemDefinationRoleSetupPage sdrs;


	@Test
	public void verifyCreateNewRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("Create a new Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);
		
//		Thread.sleep(2000);
		hp.setOrgUnit();
//		Thread.sleep(2000);
		oudd.setAutoOu();
//		Thread.sleep(2000);
		jmmi.clickOnSystemDefination();
//		Thread.sleep(2000);
		esp.setCreateRole();
		sdrs.setCreateNewRole();
		logger.info("verify Create a new role is successfull");
	}

	@Test

	public void verifyUpdateRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setUpdateRole();
		logger.info("Verify Update Role successfull");
	}

	@Test
	public void verifyDeactiveRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDeactiveRole();
		logger.info("Verify Deactive Role is successfull");
	}

	@Test

	public void verifyReactiveRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setReactiveRole();
		logger.info("Verify Reactive Role is successfull");
	}

	@Test
	public void verifyCreateRoleWithAllAvailableSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithAllAvailableSkill();
		logger.info("Verify create a role with all available skill");
	}

	@Test //(priority = 6)
	public void verifyDisselectAllAvailableSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDisselectAllAvailableSkill();
		logger.info("Verify disselect all available skill");
	}

//	@Test//(priority = 7) // Do it latter 
//	public void verifyCreateNewRoleWithoutPriarySkill() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setCreateNewRoleWithoutPriarySkill();
//		logger.info("verify create new role without priary skill");
//	}
	@Test //(priority = 8)
	public void verifyCreateNewRoleWithoutRoleName() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutRoleName();
		logger.info("verify create new role without role name");
	}

	@Test //(priority = 9)
	public void verifyCreateNewRoleWithoutRoleDescription() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutRoleDescription();
		logger.info("verify create new role without role description");
	}
	@Test //(priority = 10)
	public void verifyCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithoutSecondarySkillEmpty();
		logger.info("verify Create New Role Without Secondary Skill Empty is successfull");
	}
	@Test //(priority = 11)
	public void verifyDisselectSingleSkillFromSelectedSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDisSelectSingleSkillFromSelectedSkill();
		logger.info("verify Disselect Single Skill From Selected Skill is successfull");
	}
	@Test  //(priority = 12)
	public void verifySearchColumnsForRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setSearchColumnsForRole();
		logger.info("verify Search Columns For Role is successfull");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test
	public void verifyCreateNewRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		logger.info("Create a new Skill");
		hp=new HomePage(driver);
		oudd= new OrganizationUnitDropDown(driver);
		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);
		
		hp.setOrgUnit();
		oudd.setAutoOu();
		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRole();
		logger.info("verify Create a new role is successfull");
	}

	@Test

	public void verifyUpdateRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		esp.setCreateRole();
		Thread.sleep(1000);
		sdrs.setUpdateRole();
		logger.info("Verify Update Role successfull");
	}

	@Test
	public void verifyDeactiveRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		esp.setCreateRole();
		Thread.sleep(1000);
		sdrs.setDeactiveRole();
		logger.info("Verify Deactive Role is successfull");
	}

	@Test

	public void verifyReactiveRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

		esp.setCreateRole();
		Thread.sleep(1000);
		sdrs.setReactiveRole();
		logger.info("Verify Reactive Role is successfull");
	}

	@Test
	public void verifyCreateRoleWithAllAvailableSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setCreateNewRoleWithAllAvailableSkill();
		
		logger.info("Verify create a role with all available skill");
	}

	@Test //(priority = 6)
	public void verifyDisselectAllAvailableSkill() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setDisselectAllAvailableSkill();
		logger.info("Verify disselect all available skill");
	}

//	@Test//(priority = 7)
//	public void verifyCreateNewRoleWithoutPriarySkill() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setCreateNewRoleWithoutPriarySkill();
//		logger.info("verify create new role without priary skill");
//	}
//	@Test //(priority = 8)
//	public void verifyCreateNewRoleWithoutRoleName() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setCreateNewRoleWithoutRoleName();
//		logger.info("verify create new role without role name");
//	}
//
//	@Test //(priority = 9)
//	public void verifyCreateNewRoleWithoutRoleDescription() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setCreateNewRoleWithoutRoleDescription();
//		logger.info("verify create new role without role description");
//	}
//	@Test //(priority = 10)
//	public void verifyCreateNewRoleWithoutSecondarySkillEmpty() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setCreateNewRoleWithoutSecondarySkillEmpty();
//		logger.info("verify Create New Role Without Secondary Skill Empty is successfull");
//	}
//	@Test //(priority = 11)
//	public void verifyDisselectSingleSkillFromSelectedSkill() throws Exception {
//		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
//		esp=new EmployeeSetupPage(driver);
//		sdrs= new SystemDefinationRoleSetupPage(driver);
//
//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
//		esp.setCreateRole();
//		sdrs.setDisSelectSingleSkillFromSelectedSkill();
//		logger.info("verify Disselect Single Skill From Selected Skill is successfull");
//	}
	@Test  //(priority = 12)
	public void verifySearchColumnsForRole() throws Exception {
		captureScreenshot(driver, "roleSetUpTest");
//		hp=new HomePage(driver);
//		oudd= new OrganizationUnitDropDown(driver);
//		jmmi= new jiviewsMainMenuItems(driver);
		esp=new EmployeeSetupPage(driver);
		sdrs= new SystemDefinationRoleSetupPage(driver);

//		hp.setOrgUnit();
//		oudd.setAutoOu();
//		jmmi.clickOnSystemDefination();
		esp.setCreateRole();
		sdrs.setSearchColumnsForRole();
		logger.info("verify Search Columns For Role is successfull");
	}*/
}
