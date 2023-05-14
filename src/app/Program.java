package app;

import java.util.List;
import java.util.Scanner;

import entities.Vehicle;
import model.dao.DaoFactory;
import model.dao.VehicleDao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VehicleDao vehicleDao = DaoFactory.createVehicleDao();
		
		//vehicleDao.buy(vehicle);
		System.out.println("Digite 1 para busca por modelo e 2 para busca por ano");
		int x = sc.nextInt();
		switch (x) {
		case 1:		
			System.out.println("Testando o método findByModel");
			System.out.println("Digite o modelo que deseja buscar: ");
			String findModel = sc.next();
			Vehicle vehicle = new Vehicle(null, findModel, null, null, null, null, null);
		
			List<Vehicle> vehicleByModel = vehicleDao.findByModel(vehicle);
			for (Vehicle obj : vehicleByModel) {
			System.out.println(obj);
			}
			break;
		case 2:	
			System.out.println("Testando o método findByYear");
			System.out.println("Digite o ano que deseja buscar: ");
			int findYear = sc.nextInt();
			vehicle = new Vehicle(null, null, null, null, findYear, null, null);
		
			List<Vehicle> vehicleByYear = vehicleDao.findByYear(vehicle);
			for (Vehicle obj : vehicleByYear) {
				System.out.println(obj);
			}			
			break;
		}		
		sc.close();
	}

}
