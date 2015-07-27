package mover.infrastructure.yelp;

import mover.viewmodels.AbsoluteLocation;
import mover.viewmodels.Place;
import mover.viewmodels.PlaceCategory;

public class YelpToViewModelMapper {

	public static Place Map(PlaceCategory category, Business business)
	{
		if(business == null){
			throw new IllegalArgumentException("business cannot be null");
		}
		Coordinate coordinate = business.getLocation().getCoordinate();
		if(coordinate == null){
			System.out.println(business.getName() + " has no location coordinate.");
		}
		AbsoluteLocation location = Map(coordinate);
		return new Place(category, business.getName(), location);
	}
	
	public static AbsoluteLocation Map(Coordinate coordinate)
	{
		if(coordinate == null){
			throw new IllegalArgumentException("coordinate cannot be null");
		}
		return new AbsoluteLocation(coordinate.getLatitude(), coordinate.getLongitude());
	}
}
