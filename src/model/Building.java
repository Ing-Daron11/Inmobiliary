package model;

public class Building{

	public static final int SIZE_OF_APARTMENTS = 10;
	public static final int SIZE_OF_OWNERS = 10;
	public static final int SIZE_OF_TENANTS = 10;
	
	private String id;
	private String direction;
	private Apartment[] apartment;
	private Owner[] owner;
	private Tenant[] tenant;

	public Building(String id, String direction){
		this.id = id;
		this.direction = direction;
		apartment = new Apartment[SIZE_OF_APARTMENTS];
		owner = new Owner[SIZE_OF_OWNERS];
		tenant = new Tenant[SIZE_OF_TENANTS];

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

	public int verifyIfApartmentExist(String apartmentId){
		int posApartment = -1;
		boolean isFound = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !isFound; i++){
			if(apartment[i] != null){
				if(apartment[i].getId().equalsIgnoreCase(apartmentId)){
					isFound = true;
					posApartment = i;
				}
			}
			
		}
		return posApartment;
	}

	public String addOwnerWithObject(Owner objectOwner){
		String msj = "Maximun capacity reached";
		for(int i = 0; i < SIZE_OF_OWNERS; i++){
			if(owner[i] == null){
				owner[i] = objectOwner;
				msj = "The owner was added succesfully";
			}
		}
		return msj;
	}

	public String addTenantWithObject(Tenant objectTenant){
		String msj = "Maximun capacity reached";
		for(int i = 0; i < SIZE_OF_TENANTS; i++){
			if(tenant[i] == null){
				tenant[i] = objectTenant;
				msj = "The tenant was added succesfully";
			}
		}
		return msj;
	}

	public void stablishOwnerForApartment(String apartmentId){
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartmentId.equalsIgnoreCase(apartment[i].getId())){
				sw = true;
				apartment[i].setOwner(1);
			}
		}
	}

	public void stablishTenantForApartment(String apartmentId){
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartmentId.equalsIgnoreCase(apartment[i].getId())){
				sw = true;
				apartment[i].setTenant(1); //It means it has a tenant
			}
		}
	}

	public int verifyOwnerFromApartment(String apartmentId){
		int owner = -1;
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartmentId.equalsIgnoreCase(apartment[i].getId())){
				sw = true;
				owner = apartment[i].getOwner();
			}
		}
		return owner;
	}

	public int verifyTenantFromApartment(String apartmentId){
		int tenant = -1;
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartmentId.equalsIgnoreCase(apartment[i].getId())){
				sw = true;
				tenant = apartment[i].getTenant();
			}
		}
		return tenant;
	}

	public String getId(){
		return this.id;
	}

	public String getDirection(){
		return this.direction;
	}
}