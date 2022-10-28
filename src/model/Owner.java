package model;

public class Owner extends User{

	public static final int SIZE_OF_APARTMENTS = 10;

	protected String numAccount;
	protected String bankName;
	private Apartment[] apartment;

	public Owner(String id, String numDocument, String name, String numPhone, int optionPhoneType, String numAccount, String bankName){
		super(id, numDocument, name, numPhone, optionPhoneType);
		this.numAccount = numAccount;
		this.bankName = bankName;
		apartment = new Apartment[SIZE_OF_APARTMENTS];

	}

	public void addApartmentWithObjectOwner(Apartment objectApartment){
		boolean sw = false;
		for (int i = 0; i < SIZE_OF_APARTMENTS && !sw; i++){
			if(apartment[i] == null){
				apartment[i] = objectApartment;
				sw = true;
			}
		}
	}

	public int countApartmentsRented(){
		int numApartments = 0;
		for(int i = 0; i < SIZE_OF_APARTMENTS; i++){
			if(apartment[i] != null){
				if(apartment[i].getTenant() != -1){
					numApartments ++;
				}
			}
		}
		return numApartments;
	}

	public String getNumAccount(){
		return this.numAccount;
	}

	public String getBankName(){
		return this.bankName;
	}

	
}