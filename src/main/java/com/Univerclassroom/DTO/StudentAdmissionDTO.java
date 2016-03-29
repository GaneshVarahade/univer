package com.Univerclassroom.DTO;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentAdmissionDTO {
    private String StudentFirstName;
    private String StudentLastName;
    private String FatherFirstName;
    private String FatherLastName;
    private String MotherFirstName;
    private String MotherLastName;
    private String GuardianFirstName;
    private String GuardianLastName;
    private String FatherOccupation;
    private String MotherOccupation;
    private String FatherAnnualIncome;
    private String Nationality;
    private String State;
    private String LocalAddress;
    private String LocalAddressPin;
    private String PermanentAddress;
    private String PermanentAddressPin;
    private String dob;
    private String dobPlace;
    private String dobDistrict;
    private String dobState;
    private String BloodGroup;
    private String LastSchool;
    private String LastResult;
    private String LastClass;
    private String ClassAdmission;
    public String getStudentFirstName() {
        return StudentFirstName;
    }
    public void setStudentFirstName(String studentFirstName) {
        StudentFirstName = studentFirstName;
    }
    public String getStudentLastName() {
        return StudentLastName;
    }
    public void setStudentLastName(String studentLastName) {
        StudentLastName = studentLastName;
    }
    public String getFatherFirstName() {
        return FatherFirstName;
    }
    public void setFatherFirstName(String fatherFirstName) {
        FatherFirstName = fatherFirstName;
    }
    public String getFatherLastName() {
        return FatherLastName;
    }
    public void setFatherLastName(String fatherLastName) {
        FatherLastName = fatherLastName;
    }
    public String getMotherFirstName() {
        return MotherFirstName;
    }
    public void setMotherFirstName(String motherFirstName) {
        MotherFirstName = motherFirstName;
    }
    public String getMotherLastName() {
        return MotherLastName;
    }
    public void setMotherLastName(String motherLastName) {
        MotherLastName = motherLastName;
    }
    public String getGuardianFirstName() {
        return GuardianFirstName;
    }
    public void setGuardianFirstName(String guardianFirstName) {
        GuardianFirstName = guardianFirstName;
    }
    public String getGuardianLastName() {
        return GuardianLastName;
    }
    public void setGuardianLastName(String guardianLastName) {
        GuardianLastName = guardianLastName;
    }
    public String getFatherOccupation() {
        return FatherOccupation;
    }
    public void setFatherOccupation(String fatherOccupation) {
        FatherOccupation = fatherOccupation;
    }
    public String getMotherOccupation() {
        return MotherOccupation;
    }
    public void setMotherOccupation(String motherOccupation) {
        MotherOccupation = motherOccupation;
    }
    public String getFatherAnnualIncome() {
        return FatherAnnualIncome;
    }
    public void setFatherAnnualIncome(String fatherAnnualIncome) {
        FatherAnnualIncome = fatherAnnualIncome;
    }
    public String getNationality() {
        return Nationality;
    }
    public void setNationality(String nationality) {
        Nationality = nationality;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getLocalAddress() {
        return LocalAddress;
    }
    public void setLocalAddress(String localAddress) {
        LocalAddress = localAddress;
    }
    public String getLocalAddressPin() {
        return LocalAddressPin;
    }
    public void setLocalAddressPin(String localAddressPin) {
        LocalAddressPin = localAddressPin;
    }
    public String getPermanentAddress() {
        return PermanentAddress;
    }
    public void setPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
    }
    public String getPermanentAddressPin() {
        return PermanentAddressPin;
    }
    public void setPermanentAddressPin(String permanentAddressPin) {
        PermanentAddressPin = permanentAddressPin;
    }
    public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDobPlace() {
		return dobPlace;
	}
	public void setDobPlace(String dobPlace) {
		this.dobPlace = dobPlace;
	}
	public String getDobDistrict() {
		return dobDistrict;
	}
	public void setDobDistrict(String dobDistrict) {
		this.dobDistrict = dobDistrict;
	}
	public String getDobState() {
		return dobState;
	}
	public void setDobState(String dobState) {
		this.dobState = dobState;
	}
	public String getBloodGroup() {
        return BloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }
    public String getLastSchool() {
        return LastSchool;
    }
    public void setLastSchool(String lastSchool) {
        LastSchool = lastSchool;
    }
    public String getLastResult() {
        return LastResult;
    }
    public void setLastResult(String lastResult) {
        LastResult = lastResult;
    }
    public String getLastClass() {
        return LastClass;
    }
    public void setLastClass(String lastClass) {
        LastClass = lastClass;
    }
    public String getClassAdmission() {
        return ClassAdmission;
    }
    public void setClassAdmission(String classAdmission) {
        ClassAdmission = classAdmission;
    }
    
}