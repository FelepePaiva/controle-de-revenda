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
		int menu;
		do {
			showMenu();
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Digite o modelo do veículo que deseja buscar: ");
				String findModel = sc.next();
				Vehicle vehicle = new Vehicle(null, findModel, null, null, null, null, null);

				List<Vehicle> vehicleByModel = vehicleDao.findByModel(vehicle);
				if (vehicleByModel.isEmpty()) {					 
						System.out.println("O modelo buscado não consta em nossos estoques");
				}
				else {
					for (Vehicle obj : vehicleByModel) {
						System.out.println(obj);
					}
					
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
				System.out.println("Testando o método addVehicle");
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
				Vehicle newVehicle = new Vehicle(id, model, assembler, color, year, price, quantity);
				vehicleDao.addVehicle(newVehicle);
				System.out.println("O veículo foi adicionaod ao estoque com sucesso!");
				break;
			case 5:
				System.out.println("Testando o método removeVehicle");
				System.out.println("Digite o id do veículo que será removido: ");
				int n = sc.nextInt();
				vehicleDao.removeVehicle(n);
				System.out.println("O veículo foi removido co sucesso!");
				break;
			case 6:
				System.out.println("Encerrando sistema! Até nova consulta.");
				break;
			default:
				System.out.println("Opção de menu inválida!");
			}
				

		}
		while (menu != 6);
		
		sc.close();
	}

	public static void showMenu() {
		System.out.println("-------- MENU DE AÇÕES--------");
		System.out.println("1 - PESQUISAR VEÍCULO PELO NOME");
		System.out.println("2 - PESQUISAR VEÍUCLO PELO ANO DO MODELO");
		System.out.println("3 - PESQUISAR VEÍCULO PELA MONTADORA");
		System.out.println("4 - ADICIONAR VEÍCULO AO ESTOQUE");
		System.out.println("5 - REMOVER VEÍCULO DO ESTOQUE");
		System.out.println("6 - SAIR");
		System.out.println("--- ESCOLHA UMA OPÇÃO ---");
	}

}
