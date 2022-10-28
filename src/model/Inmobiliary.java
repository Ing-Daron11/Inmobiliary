package model;

public class Inmobiliary{
	
	public static final int SIZE_OF_BUILDINGS = 5;


	private Building[] building;
	private Apartment apartment;
	private Owner owner;
	private Tenant tenant;

	public Inmobiliary(){
		building = new Building[SIZE_OF_BUILDINGS];
	}

	public String addBuilding(String id, String direction){
		Building newBuilding = new Building(id, direction);
		String msj = "Maximun buildings. Capacity reached";
		boolean sw = false;
		for (int i = 0; i < SIZE_OF_BUILDINGS && !sw ;i++){
			if(building[i] == null){
				building[i] = newBuilding;
				sw = true;
				msj = "The building was added succesfully";
			}
		}
		return msj;
	}

	public boolean validateIfPositive(int numToValidate){
		boolean isNumberPositive = false;
		if (numToValidate >= 0){
			isNumberPositive = true;
		}
		return isNumberPositive;
	}

	public int searchBuildingById(String buildingId){
		int posBuilding = -1;
		boolean sw = false;
		for (int i = 0;i < SIZE_OF_BUILDINGS && !sw;i++){
			if(building[i] != null){
				if(buildingId.equalsIgnoreCase(building[i].getId())){
				sw = true;
				posBuilding = i;
				}
			}
		}
		return posBuilding;
	}

	public String addApartmentToBulding(String buildingId, String id, int numRooms, int numBaths, int balcony, double cost){
		String msj = "The building doesn't exist";
		Apartment newApartment = new Apartment(id, numRooms,numBaths,balcony,cost);
		int posBuilding = searchBuildingById(buildingId);
		if (posBuilding != -1){
			msj = building[posBuilding].addApartmentWithObject(newApartment);
		}
		return msj;
	}

	
	public boolean verifyCorrectOption(int option){
		boolean isCorrect = false;
		if(option >= 0 && option <=1){
			isCorrect = true;
		}
		return isCorrect;
	}

	public boolean validateCorrectOption(int option){
		boolean isCorrect = false;
		if(option >= 0 && option <=4){
			isCorrect = true;
		}
		return isCorrect;
	}

	public String callAddOwner(String buildingId, String apartmentId, String ownerId, String numDocument, String ownerName, String numPhone, int optionPhoneType, String numAccount, String bankName){
		String msj = "";
		Owner newOwner = new Owner(ownerId, numDocument, ownerName, numPhone, optionPhoneType, numAccount, bankName);
		int posBuilding = searchBuildingById(buildingId);
		msj = building[posBuilding].addOwnerWithObject(newOwner);
		building[posBuilding].stablishOwnerForApartment(apartmentId); //This line stablish that the appartment now has an owner.
		return msj;
	}

	public String callAddTenant(String buildingId, String apartmentId, String tenantId, String numDocument, String tenantName, String numPhone, int optionPhoneType){
		String msj = "";
		Tenant newTenant = new Tenant(tenantId, numDocument, tenantName, numPhone, optionPhoneType);
		int posBuilding = searchBuildingById(buildingId);
		msj = building[posBuilding].addTenantWithObject(newTenant);
		building[posBuilding].stablishTenantForApartment(apartmentId); //This line stablish that the appartment now has a tenant.
		return msj;
	}

	public int callVerifyIfApartmentExist(String buildingId, String apartmentId){
		int posApartment = -2;
		int posBuilding = searchBuildingById(buildingId);
		if(posBuilding != -1){
			posApartment = building[posBuilding].verifyIfApartmentExist(apartmentId);
		}
		return posApartment;
	}

	public int verifyIfApartmentHasOwner(String buildingId, String apartmentId){
		int posBuilding = searchBuildingById(buildingId);
		int owner = building[posBuilding].verifyOwnerFromApartment(apartmentId);
		return owner;
	}

	public int verifyIfApartmentHasTenant(String buildingId, String apartmentId){
		int posBuilding = searchBuildingById(buildingId);
		int tenant = building[posBuilding].verifyTenantFromApartment(apartmentId);
		return tenant;
	}

	public String availableApartmentByBuilding(String buildingId){
		String msj = "";
		int posBuilding = searchBuildingById(buildingId);
		if(posBuilding != -1){
			int apartmentsAvailable = building[posBuilding].searchAvailableApartment();
			return msj = "The amount of apartments avaible in the building '" + building[posBuilding].getId() + "' is/are: "+ apartmentsAvailable;
		}else{
			return msj = "The building doesn't exist";
		}
	}

	public String countRentsByBuilding(String buildingId){
		String msj = "";
		int posBuilding = searchBuildingById(buildingId);
		if(posBuilding != -1){
			int moneyRents = building[posBuilding].countRents();
			return msj = "the amount of money of this building's rents are: $" + moneyRents + " bucks";
		}else{
			return msj = "The building doesn't exist";
		}
	}

	public String callVerifyTenantFromApartment(String buildingId, String apartmentId){
		String msj = "";
		int posBuilding = searchBuildingById(buildingId);
		if(posBuilding != -1){
			int veryApartment = building[posBuilding].verifyIfApartmentExist(apartmentId);
			if(veryApartment != -1){ //If it's different from -1, it means that the apartment exists.
				int tenant = building[posBuilding].verifyTenantFromApartment(apartmentId);//if the apartment has a tenant, it means that is already occuped, if not, so it's free.
				if(tenant == -1){ //it's free.
					return msj = "The apartment '" + apartmentId + "' is available"; 
				}else{
					return msj = "The apartment '" + apartmentId + "' is already occuped. I´m sorry";
				}
			}else{
				return msj = "The apartment doesn't exist";
			}
		}else{
			return msj = "The building doesn't exist";
		}
	}

}