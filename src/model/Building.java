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
		String msj = "Maximun apartments. Capacity reached";
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
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_OWNERS && !sw; i++){
			if(owner[i] == null){
				sw = true;
				owner[i] = objectOwner;
				msj = "The owner was added succesfully";
			}
		}
		return msj;
	}

	public String addTenantWithObject(Tenant objectTenant){
		String msj = "Maximun capacity reached";
		boolean sw = false;
		for(int i = 0; i < SIZE_OF_TENANTS && !sw; i++){
			if(tenant[i] == null){
				sw = true;
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
				apartment[i].setOwner(1); //It means it has an owner
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

	public void callAddApartmentWithObjectOwner(Apartment objectApartment, String ownerId){
		int posOwner = searchOwnerById(ownerId);
		owner[posOwner].addApartmentWithObjectOwner(objectApartment);
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
			if(apartment[i] != null){
				if(apartmentId.equalsIgnoreCase(apartment[i].getId())){
					sw = true;
					tenant = apartment[i].getTenant();
				}
			}
		}
		return tenant;
	}

	public int searchAvailableApartment(){
		int apartmentsAvailable = 0;
		for(int i = 0; i < SIZE_OF_APARTMENTS; i++){
			if(apartment[i] != null){
				if(apartment[i].getTenant() == -1){
					apartmentsAvailable ++;
				}
			}
		}
		return apartmentsAvailable;
	}

	public int countRents(){
		int moneyRents = 0;
		for(int i = 0; i < SIZE_OF_APARTMENTS; i++){
			if(apartment[i] != null){
				if(apartment[i].getTenant() != -1){ //First we validate if it has a tenant
					if(apartment[i].getOwner() != -1){//Now we validate if it has an Owner, if so, we calculate the 10% that correspond to the inmobiliary
						moneyRents += apartment[i].getCost() * 0.1;
					}else{ //If the apartment doesn't have owner, so all the rent is for the inmobiliary
						moneyRents += apartment[i].getCost();
					}
				}
			}
		}
		return moneyRents;
	}

	public int searchOwnerById(String ownerId){
		int posOwner = -1;
		boolean isFound = false;
		for(int i = 0; i < SIZE_OF_OWNERS && !isFound; i++){
			if(owner[i] != null){
				if(owner[i].getId().equalsIgnoreCase(ownerId)){
					isFound = true;
						posOwner = i;
				}
			}
			
		}
		return posOwner;
	}

	public String amountApartmentsRentedByOwner(String ownerId){
		String msj = "";
		int numApartments = 0;
		int posOwner = searchOwnerById(ownerId);
		if(posOwner != -1){
			numApartments = owner[posOwner].countApartmentsRented();
			return msj = "The amount of rented apartments that the owner '" + owner[posOwner].getName() + "' has is/are: " + numApartments;
		}else{
			return msj = "The owner doesn't exist"; 
		}
	}

	public String getId(){
		return this.id;
	}

	public String getDirection(){
		return this.direction;
	}
}