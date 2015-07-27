package mover.viewmodels;

public class AbsoluteLocation {

	private Double latitude;
	private Double longitude;

	public AbsoluteLocation()
	{
		
	}
	public AbsoluteLocation(Double latitude, Double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	 
	/*
	 * not critical initially, but equality and hashing 
	 * should be overwritten if this is to represent the 
	 * value completely
	 * */

	@Override 
	public String toString() {
		return "(" + getLatitude() + "," + getLongitude() + ")";
	}
}
