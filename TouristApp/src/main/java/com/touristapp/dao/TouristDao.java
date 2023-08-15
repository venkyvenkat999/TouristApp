package com.touristapp.dao;

import java.util.List;

import com.touristapp.exceptions.TouristPlaceNotFoundException;
import com.touristapp.model.Tourist;

public interface TouristDao {
	
	void addPlace(Tourist tourist);
    
    void updateCost(int touristId, double cost);
    
    void deletePlace(int touristId);

    Tourist  findByTouristId(int touristId);
    
    List<Tourist>findAllPlaces();
    
	List<Tourist>findByPlaceContains(String place)throws TouristPlaceNotFoundException;
	
	List<Tourist>findByCategory(String category)throws TouristPlaceNotFoundException;
	
	List<Tourist>findByState(String state)throws TouristPlaceNotFoundException;
	
	List<Tourist>findPlaceContainsAndCategory(String place,String category)throws TouristPlaceNotFoundException;
	
	List<Tourist>findPlaceContainsAndTouristId(String place,int touristId)throws TouristPlaceNotFoundException;

	List<Tourist>findByCostLessThan(double cost)throws TouristPlaceNotFoundException;


}
