package com.touristapp.service;

import java.util.List;

import com.touristapp.exceptions.TouristPlaceNotFoundException;
import com.touristapp.model.Tourist;

public interface TouristService {
	
	void addPlace(Tourist tourist);
    
    void updateCost(int touristId, double cost);
    
    void deletePlace(int touristId);

    Tourist  getByTouristId(int touristId);
    
    List<Tourist>getAllPlaces();
    
	List<Tourist>getByPlaceContains(String place)throws TouristPlaceNotFoundException;
	
	List<Tourist>getByCategory(String category)throws TouristPlaceNotFoundException;
	
	List<Tourist>getByState(String state)throws TouristPlaceNotFoundException;
	
	List<Tourist>getPlaceContainsAndCategory(String place,String category)throws TouristPlaceNotFoundException;
	
	List<Tourist>getPlaceContainsAndTouristId(String place,int touristId)throws TouristPlaceNotFoundException;

	List<Tourist>getByCostLessThan(double cost)throws TouristPlaceNotFoundException;


}
