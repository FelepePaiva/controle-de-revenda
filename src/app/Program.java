package app;

import java.util.Scanner;

import entities.Vehicle;
import model.dao.DaoFactory;
import model.dao.VehicleDao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VehicleDao vehicleDao = DaoFactory.createVehicleDao();
		System.out.println("===Testando o método BUY===");
		System.out.println("Inserir o id do veículo");
		int id = sc.nextInt();
		System.out.println("Modelo: ");
		String modelo = sc.next();
		System.out.println("Montadora: ");
		String montadora = sc.next();
		System.out.println("Cor: ");
		String cor = sc.next();
		System.out.println("Ano de fabricação: ");
		int ano = sc.nextInt();
		System.out.println("Preço: ");
		double preco = sc.nextDouble();
		System.out.println("Quantidade: ");
		int quantidade = sc.nextInt();
		Vehicle vehicle = new Vehicle(id, modelo, montadora, cor, ano, preco, quantidade);
		vehicleDao.buy(vehicle);
		
		sc.close();
		
		
	
	
	}

}
