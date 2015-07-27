package mover.viewmodels;



public class Place {

	private PlaceCategory category;
	private String name;
	private AbsoluteLocation location;
	
	public Place()
	{
		
	}
	public Place(PlaceCategory category, String name, Double latitude, Double longitude)
	{
		this.setCategory(category);
		this.setName(name);
		this.setLocation(latitude, longitude);
	}
	
//Not Sure if we need AbsoluteLocation. 
	public Place(PlaceCategory category, String name, AbsoluteLocation location)
	{
		this.setCategory(category);
		this.setName(name);
		this.setLocation(location);
	}

	public PlaceCategory getCategory(){ 
		return this.category; 
	}
	public void setCategory(PlaceCategory category){ 
		this.category = category; 
	}
	public String getName(){ 
		return this.name; 
	}
	public void setName(String name){ 
		if(name == null || name.trim().length() == 0){
			throw new IllegalArgumentException("name cannot be null or whitespace.");
		}
		this.name = name; 
	}
	
	public AbsoluteLocation getLocation(){
		return this.location;
	}
	public void setLocation(AbsoluteLocation location){
		if(location == null){
			throw new IllegalArgumentException("location cannot be null.");
		}
		this.location = location;
	}
	public void setLocation(Double latitude, Double longitude){
		this.setLocation(new AbsoluteLocation(latitude, longitude));
	}
}
