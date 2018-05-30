package Mindeft.CFMS.bean;

public class crimeBean {
	String CrimeType_Id,area_id,crime_date,crime_details,location_description,crime_id;

	public String getCrimeType_Id() {
		return CrimeType_Id;
	}

	public void setCrimeType_Id(String crimeType_Id) {
		CrimeType_Id = crimeType_Id;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getCrime_date() {
		return crime_date;
	}

	public void setCrime_date(String crime_date) {
		this.crime_date = crime_date;
	}

	public String getCrime_details() {
		return crime_details;
	}

	public void setCrime_details(String crime_details) {
		this.crime_details = crime_details;
	}

	public String getLocation_description() {
		return location_description;
	}

	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}

	public String getCrime_id() {
		return crime_id;
	}

	public void setCrime_id(String crime_id) {
		this.crime_id = crime_id;
	}
	
}
