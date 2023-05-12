package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
	public void sell(Vehicle obj) {
		
		
	}

	@Override
	public void buy(Vehicle obj) {
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

	

	@Override
	public List<Vehicle> findByModel(Vehicle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findByYear(Vehicle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vehicle> findByAssembler(Vehicle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle buy(int id, String modelo, String montadora, String cor, int ano, double preco, int quantidade) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
