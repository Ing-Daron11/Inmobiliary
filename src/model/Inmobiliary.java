package model;

public class Inmobiliary{
	
	public static final int SIZE_OF_BUILDINGS = 5;


	private Building[] building;
	private Apartment apartment;
	private Owner owner;

	public Inmobiliary(){
		building = new Building[SIZE_OF_BUILDINGS];
	}

	public String addBuilding(String id, String direction){
		Building newBuilding = new Building(id, direction);
		String msj = "Maximun capacity reached";
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

	public String addApartmentToBulding(String buildingId, String id, int numRooms, int numBaths, int balcony, double cost, int tenant){
		String msj = "The building doesn't exist";
		Apartment newApartment = new Apartment(id, numRooms,numBaths,balcony,cost, tenant);
		int posBuilding = searchBuildingById(buildingId);
		if (posBuilding != -1){
			msj = building[posBuilding].addApartmentWithObject(newApartment);
		}
		return msj;
	}

	
	public boolean verifyCorrectOption(int option){
		boolean isCorrect = false;
		if(option >= 1 && option <=2){
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

}