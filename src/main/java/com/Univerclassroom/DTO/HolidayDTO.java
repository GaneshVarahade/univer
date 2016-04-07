package com.Univerclassroom.DTO;

public class HolidayDTO {

	private long HolidayId;
	private String HolidayName;
	private String HolidayDate;
	private String  sessionId;
	public long getHolidayId() {
		return HolidayId;
	}
	public void setHolidayId(long holidayId) {
		HolidayId = holidayId;
	}
	public String getHolidayName() {
		return HolidayName;
	}
	public void setHolidayName(String holidayName) {
		HolidayName = holidayName;
	}
	public String getHolidayDate() {
		return HolidayDate;
	}
	public void setHolidayDate(String holidayDate) {
		HolidayDate = holidayDate;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
}
