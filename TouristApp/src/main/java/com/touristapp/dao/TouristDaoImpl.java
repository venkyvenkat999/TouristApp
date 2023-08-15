package com.touristapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.touristapp.exceptions.TouristPlaceNotFoundException;
import com.touristapp.model.Tourist;
import com.touristapp.util.DBConnection;
import com.touristapp.util.Queries;

public class TouristDaoImpl implements TouristDao {

	@Override
	public void addPlace(Tourist tourist) {
		
		try(Connection connection = DBConnection.openConnection(); 

                PreparedStatement statement = connection.prepareStatement(Queries.insertQuery);) {

            statement.setString(1, tourist.getPlace());

            statement.setString(2, tourist.getCategory());
            
            statement.setString(3, tourist.getState());

            statement.setDouble(4, tourist.getCost());

            statement.execute();
            
            System.out.println("1 row inserted");
            System.out.println();
            
            
            
        } catch (SQLException e) {

            e.printStackTrace();
		
	}
}

	@Override
	public void updateCost(int touristId, double cost) {
		try(Connection connection = DBConnection.openConnection(); 

            PreparedStatement statement = connection.prepareStatement(Queries.updateQuery);) {

            statement.setInt(2, touristId);

            statement.setDouble(1, cost);
            
            statement.executeUpdate();
            
            System.out.println("1 row updated");
            System.out.println();

        } catch (SQLException e) {

            e.printStackTrace();
		
	}
		
	}

	@Override
	public void deletePlace(int touristId) {
		try(Connection connection = DBConnection.openConnection(); 

             PreparedStatement statement = connection.prepareStatement(Queries.deleteQuery);) {

            statement.setInt(1, touristId);
            
            statement.executeUpdate();
            
            System.out.println("1 row deleted");
            System.out.println();
            
        } catch (SQLException e) {

            e.printStackTrace();
		
	}
}
	@Override
	public Tourist findByTouristId(int touristId) {
		Tourist tourist=new Tourist();
		try(Connection connection = DBConnection.openConnection(); 

	             PreparedStatement statement = connection.prepareStatement(Queries.querybyid);) {
			statement.setInt(1, touristId);
			statement.execute();
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category=rs.getString("category");
  		    	String state=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	tourist.setPlace(place);
  		    	tourist.setTravelerId(touristId1);
  		    	tourist.setCategory(category);
  		    	tourist.setState(state);
  		    	tourist.setCost(cost);

  		    	
  		    }
			
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		
		return tourist;
	}

	@Override
	public List<Tourist> findAllPlaces() {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.query);) {
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category=rs.getString("category");
  		    	String state=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place,touristId1,category,state,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}

	@Override
	public List<Tourist> findByPlaceContains(String place) throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybyplace);) {
			statement.setString(1, "%"+place+"%");
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category=rs.getString("category");
  		    	String state=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category,state,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}

	@Override
	public List<Tourist> findByCategory(String category) throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybycategory);) {
			statement.setString(1, "%"+category+"%");
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category1=rs.getString("category");
  		    	String state=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category1,state,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}
		
	

	@Override
	public List<Tourist> findByState(String state) throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybystate);) {
			statement.setString(1, "%"+state+"%");
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category1=rs.getString("category");
  		    	String state1=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category1,state1,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}

	@Override
	public List<Tourist> findPlaceContainsAndCategory(String place, String category)
			throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybyplaceandcategory);) {
			statement.setString(1, place);
			statement.setString(2, category);
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category1=rs.getString("category");
  		    	String state1=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category1,state1,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}

	@Override
	public List<Tourist> findPlaceContainsAndTouristId(String place, int touristId)
			throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybyplaceandid);) {
			statement.setString(1, place);
			statement.setInt(2, touristId);
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category1=rs.getString("category");
  		    	String state1=rs.getString("state");
  		    	double cost=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category1,state1,cost);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}

	@Override
	public List<Tourist> findByCostLessThan(double cost) throws TouristPlaceNotFoundException {
		Tourist tourist=new Tourist();
		List<Tourist> places=new ArrayList<>();
		try(Connection connection = DBConnection.openConnection(); 

	         PreparedStatement statement = connection.prepareStatement(Queries.querybycostlessthan);) {
			statement.setDouble(1, cost);
  		    ResultSet rs=statement.executeQuery();
  		    while(rs.next()) {
  		    	String place1=rs.getString("place");
  		    	Integer touristId1=rs.getInt("touristId");
  		    	String category1=rs.getString("category");
  		    	String state1=rs.getString("state");
  		    	double cost1=rs.getDouble("cost");
  		    	
  		    	tourist=new Tourist(place1,touristId1,category1,state1,cost1);
  		    	places.add(tourist);
  		    }
		}catch (SQLException e) {

            e.printStackTrace();
		
	}
		return places;
	}
	

}
