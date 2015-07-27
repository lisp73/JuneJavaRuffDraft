package mover.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mover.IPlaceProvider;
import mover.infrastructure.PlaceProvider;
import mover.infrastructure.Services;
import mover.viewmodels.PlaceCategory;

import com.google.gson.Gson; 

/**
 * Servlet implementation class MoverServlet
 */
@WebServlet("/pizzerias")
public class MoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final IPlaceProvider places;
	private final Gson gson;
	
	public MoverServlet() throws IOException{
		this(Services.Places(), new Gson());
	}
	
  //here we include dependency injection by injecting IPlacePrivider and Gson
    public MoverServlet(IPlaceProvider places, Gson gson) {
        super();
        this.places = places;
        this.gson = gson;

    }
    
    protected IPlaceProvider getPlaces(){ return places;}

    protected String serialize(Object model){
    	return this.gson.toJson(model);
    }
    
//form inputs drop down select 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = serialize(places.FindPlacesByCategory(PlaceCategory.Pizzeria));
		response.setContentType("application/json");
		response.getWriter().write(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
