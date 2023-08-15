package com.touristapp.util;

public class Queries {
	
	public static final String createquery="create table tourist(place varchar(200),touristId int primary key auto_increment,category varchar(100),state varchar(100), cost double)";
	public static final String insertQuery="insert into tourist(place,category,state,cost) values(?,?,?,?) ";
	public static final String updateQuery="update tourist set cost=? where touristId=?";
	public static final String deleteQuery="delete from tourist where touristId=?";
	public static final String query="select * from tourist";
	public static final String querybyid="select * from tourist where touristId=?";
	public static final String querybyplace="select * from tourist where place like ?";
	public static final String querybycategory="select * from tourist where category like ?";
	public static final String querybystate="select * from tourist where state like ?";
	public static final String querybyplaceandcategory="select * from tourist where place=? and category=? ";
	public static final String querybyplaceandid="select * from tourist where place=? and touristId=? ";
	public static final String querybycostlessthan="select * from tourist where cost< ?";

}
