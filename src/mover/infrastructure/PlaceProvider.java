package mover.infrastructure;
import java.util.*;

import mover.IPlaceProvider;
import mover.infrastructure.yelp.Business;
import mover.infrastructure.yelp.DefaultYelpModelValidator;
import mover.infrastructure.yelp.IYelpModelValidator;
import mover.infrastructure.yelp.YelpToViewModelMapper;
import mover.viewmodels.Place;
import mover.viewmodels.PlaceCategory;
import mover.viewmodels.TrainStop;

import java.io.*;
import java.lang.reflect.Type;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PlaceProvider implements IPlaceProvider 
{
	private final Map<PlaceCategory, List<Place>> data;
	
	//  to support multiple train stops, change the underlying 
	// data store from the field above to the field below.
	//
	//  private final Map<Pair<TrainStop, PlaceCategory>, List<Place>> placesByTrainStopAndCategory;
	private static final IYelpModelValidator YelpModelValidator = new DefaultYelpModelValidator();
	
	public static IPlaceProvider GetDefaultInstance() throws IOException{
		HashMap<PlaceCategory, List<Place>> map = new HashMap<PlaceCategory, List<Place>>();
		LoadPizzerias(map);
		LoadCasinos(map);
		return new PlaceProvider(map);
	}

	
	private static void LoadPizzerias(Map<PlaceCategory, List<Place>> data) 
			throws IOException
	{
		List<Place> places = new ArrayList<Place>();
		LoadRawPizzeriaListFromYelpExport()
		.forEach(business -> {
			if(YelpModelValidator.IsValid(business))
			{
				places.add(YelpToViewModelMapper.Map(PlaceCategory.Pizzeria, business));
			}
		});
		data.put(PlaceCategory.Pizzeria, places);
	}
	
	private static void LoadCasinos(Map<PlaceCategory, List<Place>> data){
		// fill in the data loading for casinos here in the same way as the pizzeria
		
	}
	
	static List<Business> LoadRawPizzeriaListFromYelpExport() throws IOException{
		//http://www.java2blog.com/2013/11/gson-example-read-and-write-json.html
		Gson gson = new Gson();
		FileReader file = new FileReader("C:\\workspace\\PeopleMover\\WebContent\\data\\grand-circus-station-pizza.json");

		BufferedReader br = new BufferedReader(file);
		Type listType = new TypeToken<List<Business>>(){}.getType(); 
		List<Business> businesses = gson.fromJson(br, listType);
		br.close();
		return businesses;
		
	}
	
	public PlaceProvider(Map<PlaceCategory, List<Place>> data)
	{
		this.data = data;
	}

	@Override
	public List<Place> FindAllPlaces() {
		List<Place> allPlaces = new ArrayList<Place>();
		this.data.forEach((category, places) -> allPlaces.addAll(places));
		return allPlaces;
	}

	@Override
	public List<Place> FindPlacesByCategory(PlaceCategory category) {
		return this.data.get(category);
	}

	
	public static void main(String[] args) throws Exception {
		IPlaceProvider provider = GetDefaultInstance();
		Integer number = provider.FindPlacesByCategory(PlaceCategory.Pizzeria).size();
		System.out.println("There are " + number + " pizzerias.");

	}


	@Override
	public List<Place> FindPlacesByTrainStop(TrainStop trainStop) { 
		throw new NotImplementedException(); 
	}


	@Override
	public List<Place> FindPlacesByCategoryAndTrainStop(PlaceCategory category,
			TrainStop trainStop) {
		throw new NotImplementedException(); 
	}
}

