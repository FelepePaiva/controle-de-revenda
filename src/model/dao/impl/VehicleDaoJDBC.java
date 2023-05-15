package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Vehicle;
import model.dao.VehicleDao;

public class VehicleDaoJDBC implements VehicleDao{
	private Connection conn;
	public VehicleDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public void removeVehicle(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tbl_veiculos WHERE id_veiculo = ? ");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(st);
		}
		
		
		
	}

	@Override
	public void addVehicle(Vehicle obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO tbl_veiculos "
				+ "(modelo_veiculo, montadora_veiculo, cor_veiculo, ano_veiculo, preco_veiculo, quantidade) "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getModel());
			st.setString(2, obj.getAssembler());
			st.setString(3, obj.getColor());
			st.setInt(4, obj.getYearModel());
			st.setDouble(5, obj.getPrice());
			st.setInt(6, obj.getQuantity());
			
			int rowsAffected = st.executeUpdate();
					
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}			
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	//Méotod auxiliar para facilitar a implementação
	private Vehicle instanteateVehicle(ResultSet rs) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(rs.getInt("id_veiculo"));
		vehicle.setModel(rs.getString("modelo_veiculo"));
		vehicle.setAssembler(rs.getString("montadora_veiculo"));
		vehicle.setColor(rs.getString("cor_veiculo"));
		vehicle.setYearModel(rs.getInt("ano_veiculo"));
		vehicle.setPrice(rs.getDouble("preco_veiculo"));
		vehicle.setQuantity(rs.getInt("quantidade"));
		return vehicle;
		
		
		
	}

	
	@Override
	public List<Vehicle> findByAssembler(Vehicle obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM tbl_veiculos WHERE montadora_veiculo = ? ");
					
			
			st.setString(1, obj.getAssembler());
			rs = st.executeQuery();
			List<Vehicle> list = new ArrayList<>();
			Map<String, Vehicle> map = new HashMap<>();
			
			while (rs.next()) {
				Vehicle vehicle = map.get(rs.getString("montadora_veiculo"));
				
				if (vehicle == null) {
					vehicle = instanteateVehicle(rs);
					map.put("montadora_veiculo", vehicle);
					
				}
				list.add(vehicle);
				return list;
			}
				
			return null;
		}		
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Vehicle buy(int id, String modelo, String montadora, String cor, int ano, double preco, int quantidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findByModel(Vehicle obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM tbl_veiculos WHERE modelo_veiculo = ? ");
					
			
			st.setString(1, obj.getModel());
			rs = st.executeQuery();
			List<Vehicle> list = new ArrayList<>();
			Map<String, Vehicle> map = new HashMap<>();
			
			while (rs.next()) {
				Vehicle vehicle = map.get(rs.getString("modelo_veiculo"));
				
				if (vehicle == null) {
					vehicle = instanteateVehicle(rs);
					map.put("modelo_veiculo", vehicle);
					
				}
				list.add(vehicle);
				return list;
			}
			return list;
				
			
		}		
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vehicle> findByYear(Vehicle vehicle) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM tbl_veiculos WHERE ano_veiculo = ? ");
					
			
			st.setInt(1, vehicle.getYearModel());
			rs = st.executeQuery();
			List<Vehicle> list = new ArrayList<>();
			Map<Integer, Vehicle> map = new HashMap<>();
			
			while (rs.next()) {
				Vehicle veh = map.get(rs.getInt("ano_veiculo"));
				
				if (veh == null) {
					veh = instanteateVehicle(rs);
					map.put(rs.getInt("ano_veiculo"), veh);
					
				}
				Vehicle obj = instanteateVehicle(rs);
				list.add(obj);
			}				
			return list;
		}		
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	

}
