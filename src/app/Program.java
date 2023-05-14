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
		case 3:
			System.out.println("Testando o método findByAssembler");
			System.out.println("Digite a montadora que deseja buscar: ");
			String findAssembler = sc.next();
			vehicle = new Vehicle(null, null, findAssembler, null, null, null, null);
		
			List<Vehicle> vehicleByAssembler = vehicleDao.findByAssembler(vehicle);
			for (Vehicle obj : vehicleByAssembler) {
				System.out.println(obj);
			}
			break;
		case 4:
			System.out.println("Testando o método buy");
			System.out.println("Digite os dados abaixo para adicionar o veículo no estoque: ");
			System.out.println("ID: ");
			int id = sc.nextInt();
			System.out.println("Modelo: ");
			String model = sc.next();
			System.out.println("Montadora: ");
			String assembler = sc.next();
			System.out.println("Cor: ");
			String color = sc.next();
			System.out.println("Ano: ");
			int year = sc.nextInt();
			System.out.println("Preço: ");
			double price = sc.nextDouble();
			System.out.println("Quantidade: ");
			int quantity = sc.nextInt();
			Vehicle addVehicle = new Vehicle(id, model, assembler, color, year, price, quantity);
			vehicleDao.buy(addVehicle);
			System.out.println("O veículo foi adicionaod ao estoque com sucesso!");
	}
		sc.close();
}
	
}
