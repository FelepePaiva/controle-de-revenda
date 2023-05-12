package entities;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String model;
	private String assembler;
	private String color;
	private Integer yearModel;
	private Double price;
	private Integer quantity;
	

	public Vehicle () {}

	public Vehicle(Integer id, String model, String assembler, String color, Integer yearModel, Double price,
			Integer quantity) {
		super();
		this.id = id;
		this.model = model;
		this.assembler = assembler;
		this.color = color;
		this.yearModel = yearModel;
		this.price = price;
		this.quantity = quantity;
	}



	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAssembler() {
		return assembler;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getYearModel() {
		return yearModel;
	}

	public void setYearModel(Integer yearModel) {
		this.yearModel = yearModel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assembler, color, id, model, price, quantity, yearModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(assembler, other.assembler) && Objects.equals(color, other.color)
				&& Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(yearModel, other.yearModel);
	}
	
	
	
	

}
