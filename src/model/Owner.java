package model;

public class Owner extends User{

	protected String numAccount;
	protected String bankName; 

	public Owner(String id, String numDocument, String name, String numPhone, int optionPhoneType, String numAccount, String bankName){
		super(id, numDocument, name, numPhone, optionPhoneType);
		this.numAccount = numAccount;
		this.bankName = bankName;

	}

	public String getNumAccount(){
		return this.numAccount;
	}

	public String getBankName(){
		return this.bankName;
	}

	
}