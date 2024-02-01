package com.AutomationJiviewsGeneric;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import com.github.javafaker.Faker;


public class FakeEmployee {

	private String empNumber;
	private String badgeNumber;
	private String skillCode;
	private String skillCodeDesc;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private String DOB;
	private String Address;
	private String postCode;
	private String city;
	private String state;
	private String mobileNumber;
	private String phoneNumber;
	private String hireDate;
	private String probationExpirydate;
	private String designation;
	private String documentName;
	private String description;
	private String WorkFlowStartDate;
	private String WorkFlowEndDate;
	private String SkillStartDate;
	private String SkillEndDate;
	private String TerminatedDate;
	private String interests;
	private String email;
	private String holidayName;
	private String holidayDate;
	private String holidayNote;
	private String rosterGroupName;
	private String rosterGroupDescription;
	private String rosterPublishDate;
	private String rosterStartDate;
	private String rosterEndDate;
	private String leaveFrom;
	private String leaveTo;
	private String referenceNo;
	private String remarksLeave;
	private String dtPlanning;
	private String txtVesselName;
	private String txtVesselVisitId;
	private String dtVesselArrival;
	private String vesselArrivalTime;
	private String dtVesselDeparture;
	private String tmVesselDeparture;
	private String tmrwDate;
	
	private String LeaveFromDate;
	private String LeaveEndDate;
	



	

	// Constructor
	public FakeEmployee() {
		// we can generate unique IDs for empNumber and badgeNumber using UUID
		this.empNumber = generateEmpNumber(8);
		this.badgeNumber = generateBadgeNumber();
		this.postCode= generateFakePostalCode();
		// Set uniqueHolidayDate to a future date
		this.uniqueHolidayDate = generateFutureDate();

		generateTmrwDate();
	}

	String generateEmpNumber(int length) {
		Random random = new Random();
		StringBuilder empNumber = new StringBuilder();

		for (int i = 0; i < length; i++) {
			empNumber.append(random.nextInt(10)); // Append a random digit (0-9)
		}

		return empNumber.toString();
	}
	String generateBadgeNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(100000000); 
		return String.format("%08d", randomNumber);
		//		return  UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
	String generateFakePostalCode() {
		Random random = new Random();
		// Adjust the range and format of the postal code based on your requirements
		int postalCodeNumber = random.nextInt(90000) + 10000; // Example: 10000 to 99999
		return String.format("ZIP%s", postalCodeNumber);
	}

	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getBadgeNumber() {
		return badgeNumber;
	}
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getProbationExpirydate() {
		return probationExpirydate;
	}

	public void setProbationExpirydate(String probationExpirydate) {
		this.probationExpirydate = probationExpirydate;
	}
	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getWorkFlowStartDate() {
		return WorkFlowStartDate;
	}

	public void setWorkFlowStartDate(String workFlowStartDate) {
		WorkFlowStartDate = workFlowStartDate;
	}

	public String getWorkFlowEndDate() {
		return WorkFlowEndDate;
	}

	public void setWorkFlowEndDate(String workFlowEndDate) {
		WorkFlowEndDate = workFlowEndDate;
	}
	public String getSkillStartDate() {
		return SkillStartDate;
	}

	public void setSkillStartDate(String skillStartDate) {
		SkillStartDate = skillStartDate;
	}

	public String getSkillEndDate() {
		return SkillEndDate;
	}

	public void setSkillEndDate(String skillEndDate) {
		SkillEndDate = skillEndDate;
	}
	public String getTerminatedDate() {
		return TerminatedDate;
	}

	public void setTerminatedDate(String terminatedDate) {
		TerminatedDate = terminatedDate;
	}
	public String getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}
	public String getSkillCodeDesc() {
		return skillCodeDesc;
	}

	public void setSkillCodeDesc(String skillCodeDesc) {
		this.skillCodeDesc = skillCodeDesc;
	}
	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayNote() {
		return holidayNote;
	}

	public void setHolidayNote(String holidayNote) {
		this.holidayNote = holidayNote;
	}
	public String getRosterGroupName() {
		return rosterGroupName;
	}

	public void setRosterGroupName(String rosterGroupName) {
		this.rosterGroupName = rosterGroupName;
	}

	public String getRosterGroupDescription() {
		return rosterGroupDescription;
	}

	public void setRosterGroupDescription(String rosterGroupDescription) {
		this.rosterGroupDescription = rosterGroupDescription;
	}
	public String getRosterPublishDate() {
		return rosterPublishDate;
	}

	public void setRosterPublishDate(String rosterPublishDate) {
		this.rosterPublishDate = rosterPublishDate;
	}
	public String getRosterStartDate() {
		return rosterStartDate;
	}

	public void setRosterStartDate(String rosterStartDate) {
		this.rosterStartDate = rosterStartDate;
	}

	public String getRosterEndDate() {
		return rosterEndDate;
	}

	public void setRosterEndDate(String rosterEndDate) {
		this.rosterEndDate = rosterEndDate;
	}

	public String getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String ReferenceNo) {
		this.referenceNo = ReferenceNo;
	}

	public String getRemarksLeave() {
		return remarksLeave;
	}

	public void setRemarksLeave(String RemarksLeave) {
		this.remarksLeave = RemarksLeave;
	}
	public String getDtPlanning() {
		return dtPlanning;
	}

	public void setDtPlanning(String dtPlanning) {
		this.dtPlanning = dtPlanning;
	}

	public String getTxtVesselName() {
		return txtVesselName;
	}

	public void setTxtVesselName(String txtVesselName) {
		this.txtVesselName = txtVesselName;
	}

	public String getTxtVesselVisitId() {
		return txtVesselVisitId;
	}

	public void setTxtVesselVisitId(String txtVesselVisitId) {
		this.txtVesselVisitId = txtVesselVisitId;
	}

	public String getDtVesselArrival() {
		return dtVesselArrival;
	}

	public void setDtVesselArrival(String dtVesselArrival) {
		this.dtVesselArrival = dtVesselArrival;
	}

	public String getVesselArrivalTime() {
		return vesselArrivalTime;
	}

	public void setVesselArrivalTime(String vesselArrivalTime) {
		this.vesselArrivalTime = vesselArrivalTime;
	}

	public String getDtVesselDeparture() {
		return dtVesselDeparture;
	}

	public void setDtVesselDeparture(String dtVesselDeparture) {
		this.dtVesselDeparture = dtVesselDeparture;
	}

	public String getTmVesselDeparture() {
		return tmVesselDeparture;
	}

	public void setTmVesselDeparture(String tmVesselDeparture) {
		this.tmVesselDeparture = tmVesselDeparture;
	}
	public String getTmrwDate() {
		return tmrwDate;
	}

	public void setTmrwDate(String TmrwDate) {
		this.tmrwDate= TmrwDate;
	}
	public String getLeaveFromDate() {
		return LeaveFromDate;
	}

	public void setLeaveFromDate(String leaveFromDate) {
		LeaveFromDate = leaveFromDate;
	}

	public String getLeaveEndDate() {
		return LeaveEndDate;
	}

	public void setLeaveEndDate(String leaveEndDate) {
		LeaveEndDate = leaveEndDate;
	}



	private static final int EMPLOYEE_NUMBER_LENGTH = 8;
	private static final int HIRE_DATE_YEARS_AGO = 2;
	private static final int PROBATION_DAYS = 90;
	private static final int WORKFLOW_START_MONTHS = 2;
	private static final int WORKFLOW_END_MONTHS = 4;
	private static final int SKILL_START_MONTHS = 2;
	private static final int SKILL_END_MONTHS_MIN = 3;
	private static final int SKILL_END_MONTHS_MAX = 6;
	private static final int TERMINATION_MONTHS_AFTER_SKILL_END = 3;
	private static final int ROSTER_START_DAYS_BEFORE = 7;
	private static final int ROSTER_END_DAYS_AFTER_START = 20;
	private String uniqueHolidayDate;


	public void generateFakeEmployeeData() {
		Faker fakeData = new Faker();

		String portOperatorName = fakeData.options().option("TT Operator","Crane Operator", "YC operator", "FLT Operator", "RS Operator", "QC Operator");
		String uniqueSkillCode = portOperatorName + "_" + System.currentTimeMillis();
		setSkillCode(uniqueSkillCode);

		String description = generateDescriptionForPortOperator(portOperatorName);
		String uniqueDescription = description + " - " + System.currentTimeMillis();
		setSkillCodeDesc(uniqueDescription);

		setFirstName(fakeData.name().firstName());
		setDescription(fakeData.lorem().sentence()); 
		setDocumentName("Medical Report"); 
		setMiddleName(fakeData.name().firstName());
		setLastName(fakeData.name().lastName());

		setEmpNumber(generateNumericString(EMPLOYEE_NUMBER_LENGTH));
		setBadgeNumber(generateNumericString(EMPLOYEE_NUMBER_LENGTH));
		setDisplayName(fakeData.name().fullName());

		LocalDate minDOB = LocalDate.of(1990, 1, 1);
		LocalDate maxDOB = LocalDate.of(2004, 12, 31);
		LocalDate randomDOB = minDOB.plusDays(new Random().nextInt((int) (maxDOB.toEpochDay() - minDOB.toEpochDay()) + 1));
		setDOB(randomDOB.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		setAddress(fakeData.address().streetAddress());
		setCity(fakeData.address().city());
		setState(fakeData.address().state());
		setPostCode(generateFakePostalCode());
		setMobileNumber(fakeData.phoneNumber().cellPhone());
		setPhoneNumber(fakeData.phoneNumber().cellPhone());
		setEmail(fakeData.internet().emailAddress());

		LocalDate hireDate = LocalDate.now().minusYears(HIRE_DATE_YEARS_AGO);
		setHireDate(hireDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate probationExpiryDate = hireDate.plusDays(PROBATION_DAYS);
		setProbationExpirydate(probationExpiryDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate startDate = LocalDate.now().plusMonths(WORKFLOW_START_MONTHS);
		setWorkFlowStartDate(startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate endDate = LocalDate.now().plusMonths(WORKFLOW_END_MONTHS);
		setWorkFlowEndDate(endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate skillStartDate = LocalDate.now().plusMonths(SKILL_START_MONTHS);
		setSkillStartDate(skillStartDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate skillEndDate = LocalDate.now().plusMonths(SKILL_END_MONTHS_MIN + new Random().nextInt(SKILL_END_MONTHS_MAX - SKILL_END_MONTHS_MIN + 1));
		setSkillEndDate(skillEndDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		LocalDate terminationDate = skillEndDate.plusMonths(TERMINATION_MONTHS_AFTER_SKILL_END);
		setTerminatedDate(terminationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		String uniqueHolidayName = fakeData.name().fullName() + "_" + System.currentTimeMillis();
		setHolidayName(uniqueHolidayName);

		//		String uniqueHolidayDate = LocalDateTime.now().toString();
		//		setHolidayDate(uniqueHolidayDate);

		setHolidayDate(generateFutureDate() + "_" + System.currentTimeMillis());

		setHolidayNote(fakeData.lorem().sentence());

		String rosterGroupName = fakeData.options().option("Crew Group", "PM1_A", "PM1_B", "PM1_C", "RBR");
		String uniqueRosterGroupName = rosterGroupName + "_" + System.currentTimeMillis();
		setRosterGroupName(uniqueRosterGroupName);

		String descriptionGroupName = generateDescriptionForRosterGroupName(rosterGroupName);
		String uniqueDescriptionGroupName = descriptionGroupName + " - " + System.currentTimeMillis();
		setRosterGroupDescription(uniqueDescriptionGroupName);

		setRosterPublishDate(LocalDateTime.now().minusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		calculateRosterDates();


		// Set leaveFrom (2 days after the current date)
		LocalDate leaveFromDate = LocalDate.now().plusDays(2);
		setLeaveFrom(leaveFromDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		// Set leaveTo (15 days after leaveFromDate)
		LocalDate leaveToDate = leaveFromDate.plusDays(2);
		setLeaveTo(leaveToDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		// Set referenceNo (random digits)
		setReferenceNo(fakeData.number().digits(8));

		// Set remarksLeave (random sentence)
		setRemarksLeave(fakeData.lorem().sentence());

		setTxtVesselName(fakeData.company().name());
		setTxtVesselVisitId(fakeData.idNumber().valid());

		// Set both planning, arrival, and departure dates to the same date
		LocalDate commonDate = LocalDate.now().plusDays(fakeData.number().numberBetween(1, 30));
		//		LocalDate currentDate = LocalDate.now(); // Get the current date
		//		setDtPlanning(formatDate(currentDate));
		LocalDate currentDate = LocalDate.now(); // Get the current date
		LocalDate tomorrowDate = currentDate.plusDays(5); // Get the date for tomorrow
		setDtPlanning(formatDate(tomorrowDate)); // Set the date for tomorrow


		//	    setDtPlanning(formatDate(commonDate));
		setDtVesselArrival(formatDate(commonDate));
		setDtVesselDeparture(formatDate(commonDate));

		// Set specific arrival and departure times
		setVesselArrivalTime("07:00");
		setTmVesselDeparture("19:00");
		//		generateTmrwDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String tmrwDateValue = LocalDate.now().plusDays(10).format(formatter); 

//		setTmrwDate(tmrwDateValue);
		setLeaveFromDate(tmrwDateValue);
//		setLeaveFromDate("12/01/2024");
		setLeaveEndDate(tmrwDateValue);
//		setLeaveEndDate("12/01/2024");
		//		setTmrwDate(generateFutureDate());



	}

	private String generateDescriptionForPortOperator(String portOperatorName) {
		switch (portOperatorName) {
		case "crane operator":
			return "Responsible for operating cranes.";
		case "cfs":
			return "Handles Container Freight Station (CFS) operations.";
		case "efo":
			return "Manages Empty Container Yard (EFO) activities.";
		case "flo":
			return "Oversees Freight Loading Operations (FLO).";
		case "lsh obc":
			return "Works with Logistics and Shipping (LSH) - Outward Bound Cargo (OBC).";
		default:
			return "Default description for the skill.";
		}
	}

	public void generateTmrwDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String tmrwDateValue = LocalDate.now().plusDays(7).format(formatter); // Set to 7 days in the future
		setTmrwDate(tmrwDateValue);
	}
	private void calculateRosterDates() {
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime startDate = currentDate.minusDays(ROSTER_START_DAYS_BEFORE);
		LocalDateTime endDate = startDate.plusDays(ROSTER_END_DAYS_AFTER_START);

		setRosterStartDate(formatDate(startDate));
		setRosterEndDate(formatDate(endDate));
	}

	private String formatDate(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}


	private String generateNumericString(int length) {
		Random random = new Random();
		StringBuilder numericString = new StringBuilder();
		for (int i = 0; i < length; i++) {
			numericString.append(random.nextInt(10));
		}
		return numericString.toString();
	}

	protected String generateDescriptionForRosterGroupName(String groupName) {
		return "Description for " + groupName;
	}

	private String generateFutureDate() {
		Random random = new Random();
		int randomDays = random.nextInt(30) + 1; // Generate a random number of days between 1 and 30
		LocalDate futureDate = LocalDate.now().plusDays(randomDays);
		return formatDate(futureDate);
	}
	private String generateRandomTime() {
		return LocalDateTime.now().plusHours((long) (Math.random() * 24)).format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	private String formatDate(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

}
