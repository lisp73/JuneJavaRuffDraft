package mover.infrastructure;

import java.io.IOException;

import mover.IPlaceProvider;

public class Services {
	public static IPlaceProvider Places() throws IOException{
		return PlaceProvider.GetDefaultInstance();
	}
}
