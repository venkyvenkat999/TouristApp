package com.touristapp.contollers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.touristapp.model.Tourist;
import com.touristapp.service.TouristService;
import com.touristapp.service.TouristServiceImpl;

public class TouristMain {

	public static void main(String[] args) {
		
		List<Tourist> places=new ArrayList<>();
		TouristService touristService=new TouristServiceImpl();

		while(true) {
			System.out.println("1.addplace\n2.update cost\n3.delete place\n4.findbytouristid\n5.find all places\n6.find by place contains\n7.find by category\n8.find by state\n9.find place contains and category\n10.find by place contains and tourist id\n11.find by cost less than\n12.exit the application\n");
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter your choice:");
			int choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.printf("enter place:");
				String place=scanner.nextLine();
				scanner.nextLine();
				System.out.println("enter category:");
				String category=scanner.nextLine();
				System.out.println("enter state:");
				String state=scanner.nextLine();
				System.out.println("enter cost:");
				Double cost=scanner.nextDouble();
				Tourist tourist=new Tourist(place,category,state,cost);
				touristService.addPlace(tourist);
				break;
			case 2:
				System.out.println("enter id:");
				int id=scanner.nextInt();
				System.out.println("enter cost:");
				Double cost1=scanner.nextDouble();
				touristService.updateCost(id,cost1);
				break;
				
			case 3:
				System.out.println("enter id:");
				int id1=scanner.nextInt();
				touristService.deletePlace(id1);
				break;

			case 4:
				System.out.println("enter id:");
				int id11=scanner.nextInt();
				System.out.println(touristService.getByTouristId(id11));
				break;

			case 5:
				places=touristService.getAllPlaces();
				places.forEach(System.out::println);
				System.out.println("\n");
				break;
				
			case 6:
				System.out.printf("enter place:");
				String place1=scanner.nextLine();
				places=touristService.getByPlaceContains(place1);
				places.forEach(System.out::println);
				break;

			case 7:
				System.out.println("enter category:");
				String category1=scanner.nextLine();
				places=touristService.getByCategory(category1);
				places.forEach(System.out::println);
				break;
				
			case 8:
				System.out.println("enter state:");
				String state1=scanner.nextLine();
				places=touristService.getByState(state1);
				places.forEach(System.out::println);
				break;
				
			case 9:
				System.out.printf("enter place:");
				String place11=scanner.nextLine();
				System.out.println("enter category:");
				String category11=scanner.nextLine();
				places=touristService.getPlaceContainsAndCategory(place11,category11);
				places.forEach(System.out::println);
				break;
				
			case 10:
				System.out.printf("enter place:");
				String place111=scanner.nextLine();
				System.out.println("enter id:");
				int id111=scanner.nextInt();
				places=touristService.getPlaceContainsAndTouristId(place111,id111);
				places.forEach(System.out::println);
				break;
				
			case 11:
				System.out.println("enter cost:");
				Double cost11=scanner.nextDouble();
				places=touristService.getByCostLessThan(cost11);
				places.forEach(System.out::println);
				break;
			
			case 12:
				return;
					
			default:
				System.out.println("enter the valid choice from 1 to 12");
				System.out.println();
				break;
			}
		
		}


	}

}
