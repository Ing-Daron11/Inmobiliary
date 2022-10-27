package model;

public class Apartment{
	
	private String id;
	private int numRooms;
	private int numBaths;
	private int balcony;
	private double cost;
	private int tenant;

	public Apartment(String id, int numRooms, int numBaths, int balcony, double cost, int tenant){
		this.id = id;
		this.numRooms = numRooms;
		this.numBaths = numBaths;
		this.balcony = balcony;
		this.cost = cost;
		this.tenant = tenant;
	}

	public String getId(){
		return this.id;
	}

	public int getNumRooms(){
		return this.numRooms;
	}

	public int getNumBaths(){
		return this.numBaths;
	}

	public int getBalcony(){
		return this.balcony;
	}

	public double getCost(){
		return this.cost;
	}

	public int getTenant(){
		return this.tenant;
	}

	public int setTenant(int newTenant){
		return this.tenant = newTenant;		
	}
}