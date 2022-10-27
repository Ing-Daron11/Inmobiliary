package model;

public abstract class User{

	private String id;
	private String numDocument;
	private String name;
	private String numPhone;
	private PhoneType phoneType;
	private int optionPhoneType;

	public User(String id, String numDocument, String name, String numPhone, int optionPhoneType){
		this.id = id;
		this.numDocument = numDocument;
		this.name = name;
		this.numPhone = numPhone;
		this.phoneType = PhoneType.values()[optionPhoneType];
	}

	public String getId(){
		return this.id;
	}


	
}