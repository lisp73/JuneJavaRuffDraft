package mover.infrastructure.yelp;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Coordinate {

@Expose
private Double latitude;
@Expose
private Double longitude;

/**
* 
* @return
* The latitude
*/
public Double getLatitude() {
return latitude;
}

/**
* 
* @param latitude
* The latitude
*/
public void setLatitude(Double latitude) {
this.latitude = latitude;
}

/**
* 
* @return
* The longitude
*/
public Double getLongitude() {
return longitude;
}

/**
* 
* @param longitude
* The longitude
*/
public void setLongitude(Double longitude) {
this.longitude = longitude;
}
 
}
