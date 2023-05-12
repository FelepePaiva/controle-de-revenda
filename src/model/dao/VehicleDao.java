package model.dao;

import java.util.List;

import entities.Vehicle;

public interface VehicleDao {
	void sell (Vehicle obj);
	void buy (Vehicle obj);
	List<Vehicle> findByModel(Vehicle obj);
	List<Vehicle> findByYear (Vehicle obj);
	List<Vehicle> findByAssembler (Vehicle obj);
	Vehicle buy(int id, String modelo, String montadora, String cor, int ano, double preco, int quantidade);

}
