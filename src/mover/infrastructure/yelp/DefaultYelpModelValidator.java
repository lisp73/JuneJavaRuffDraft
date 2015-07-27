package mover.infrastructure.yelp;



public class DefaultYelpModelValidator implements IYelpModelValidator {


	@Override
	public Boolean IsValid(Business business) {
		return business != null 
				&& business.getName() != null 
				&& business.getName().trim().length() > 0
				&& IsValid(business.getLocation());
	}

	@Override
	public Boolean IsValid(Location location) {
		return location != null && IsValid(location.getCoordinate());
	}

	@Override
	public Boolean IsValid(Coordinate coordinate) {
		return coordinate != null;
	}
}
