package entities;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "artist")
public class Artist {
	
	private String id;
	private String name;
	private double price;
	private int quantity;
	private String country;
	
	@XmlElement(name = "id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "price")
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@XmlElement(name = "quantity")
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@XmlElement(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Artist(String id, String name, double price, int quantity, String country) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.country = country;
	}
	
	public Artist() {
		super();
	}
	
}
