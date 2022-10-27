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

	public String addApartmentWithObjectOwner(Apartment objectApartment){
		String msj = "The owner has owned all the apartments available";
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

	public String getNumAccount(){
		return this.numAccount;
	}

	public String getBankName(){
		return this.bankName;
	}

	
}