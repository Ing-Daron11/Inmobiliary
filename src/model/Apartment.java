package model;

public class Apartment{
	
	private String id;
	private int numRooms;
	private int numBaths;
	private int balcony;
	private double cost;
	private int tenant;
	private int owner;

	public Apartment(String id, int numRooms, int numBaths, int balcony, double cost){
		this.id = id;
		this.numRooms = numRooms;
		this.numBaths = numBaths;
		this.balcony = balcony;
		this.cost = cost;
		this.tenant = -1; //It means that when an apartment is created it doesn't have a tenant
		this.owner = -1; //It means that when an apartment is created it doesn't have an owner
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

	public void setTenant(int newTenant){
		this.tenant = newTenant;		
	}

	public int getOwner(){
		return this.owner;
	}

	public void setOwner(int newOwner){
		this.owner = newOwner;
	}
}