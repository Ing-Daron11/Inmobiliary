package model;

public class Building{

	public static final int SIZE_OF_APARTMENTS = 10;
	public static final int SIZE_OF_OWNERS = 10;
	
	private String id;
	private String direction;
	private Apartment[] apartment;
	private Owner[] owner;

	public Building(String id, String direction){
		this.id = id;
		this.direction = direction;
		apartment = new Apartment[SIZE_OF_APARTMENTS];

	}

	public String addApartmentWithObject(Apartment objectApartment){
		String msj = "Maximun capacity reached";
		boolean sw = false;
		for (int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartment[i] == null){
				apartment[i] = objectApartment;
				sw = true;
				msj = "The apartment was added succesfully";
			}
		}
		return msj;
	}

	public boolean veryifOwnerExist(String ownerId){
		boolean ownerExist = false;
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_OWNERS && !sw; i++){
			if(owner[i] != null){
				if(owner[i].getId().equalsIgnoreCase(ownerId)){
				ownerExist = true;
				}
			}
		}
		return ownerExist;
	}

	public String getId(){
		return this.id;
	}

	public String getDirection(){
		return this.direction;
	}
}