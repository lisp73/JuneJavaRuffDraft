package mover;
import mover.viewmodels.*;

import java.util.*;

public interface IPlaceProvider {
	List<Place> FindAllPlaces();
	List<Place> FindPlacesByCategory(PlaceCategory category);
	List<Place> FindPlacesByTrainStop(TrainStop trainStop);
	List<Place> FindPlacesByCategoryAndTrainStop(PlaceCategory category, TrainStop trainStop);
}

