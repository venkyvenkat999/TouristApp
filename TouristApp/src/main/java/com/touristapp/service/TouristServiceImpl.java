package com.touristapp.service;
import java.util.List;
import java.util.stream.Collectors;
import com.touristapp.dao.TouristDao;
import com.touristapp.dao.TouristDaoImpl;
import com.touristapp.exceptions.TouristPlaceNotFoundException;
import com.touristapp.model.Tourist;

public class TouristServiceImpl implements TouristService {
	
	TouristDao touristDao=new TouristDaoImpl();
	Tourist tourist=new Tourist();

	@Override
	public void addPlace(Tourist tourist) {
		touristDao.addPlace(tourist);

	}

	@Override
	public void updateCost(int touristId, double cost) {
		touristDao.updateCost(touristId, cost);

	}

	@Override
	public void deletePlace(int touristId) {
		touristDao.deletePlace(touristId);

	}

	@Override
	public Tourist getByTouristId(int touristId) {
		tourist=touristDao.findByTouristId(touristId);
		return tourist;
	}

	@Override
	public List<Tourist> getAllPlaces() {
		return touristDao.findAllPlaces().stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getByPlaceContains(String place) throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findByPlaceContains(place);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("place not found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getByCategory(String category) throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findByCategory(category);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("category not found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getByState(String state) throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findByState(state);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("state not found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getPlaceContainsAndCategory(String place, String category)
			throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findPlaceContainsAndCategory(place,category);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("place and category not found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getPlaceContainsAndTouristId(String place, int touristId)
			throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findPlaceContainsAndTouristId(place,touristId);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("place and id not found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Tourist> getByCostLessThan(double cost) throws TouristPlaceNotFoundException {
		List<Tourist> places=touristDao.findByCostLessThan(cost);

		if(places.isEmpty())
			throw new TouristPlaceNotFoundException("not less than cost  found");
		
		return places.stream().sorted((d1,d2)->d1.getPlace()
				.compareTo(d2.getPlace())).collect(Collectors.toList());
	}
	

}
