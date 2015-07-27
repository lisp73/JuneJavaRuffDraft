package mover.infrastructure.yelp;


public interface IYelpModelValidator
{
	Boolean IsValid(Business business);
	Boolean IsValid(Location location);
	Boolean IsValid(Coordinate coordinate);
}
