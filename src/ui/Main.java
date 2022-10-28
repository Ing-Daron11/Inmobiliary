package ui;

import java.util.Scanner;
import model.Inmobiliary;

public class Main{

	private Scanner input;
	private Inmobiliary inmobiliary;

	public Main(){ //Constructor
		input = new Scanner(System.in);
		inmobiliary = new Inmobiliary();
	}

	public static void main(String args[]){ //Método main
		Main main = new Main();
		int option = -1; 
			do{
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

	}

	public int validateIntegerOption(){
			int option = 0; 

			if (input.hasNextInt()){
				option = input.nextInt();
			}else{
				//Se limpia el scanner
				input.next();
				option = -1;
			}

			return option;
	}

	public int getOptionShowMenu(){
		int option = 0; 
			System.out.println(printMenu());

			option = validateIntegerOption(); 

			return option; 
	}

	public String printMenu(){
			return 
				"\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"<< -                                Welcome                            - >>\n" +
				"<< --------------------------------------------------------------------- >>\n" +
				"1. Add a building \n" +
				"2. Add a apartment to specific building\n" + 
				"3. Register an owner \n" +
				"4. Register a tenant\n" +
				"5. Show how many apartments are available by building\n" +
				"6. Show amount of money of the rents by building\n" +
				"7. Verify if an apartment is available\n" +
				"8. Consult how many rented apartments an owner has\n" +
				"9. Consult how much money an owner recives from his rented apartments\n" +
				"0. Exit.\n"; 
	}

	public void executeOption(int option){
		int numPrueba;
		String msj = "";
		boolean sw = true;
		boolean sw2 = true;
		boolean sw3 = true;
		boolean sw4 = true;
		int tenant=0;
		int balcony=0;
		int numRooms = 0;
		int numBaths = 0;
		int phoneType = 0;
		String apartmentId = "";

		switch(option){
			case 1: //Add a building
				System.out.print("Type the id of the building: ");
				String idBuilding = input.next();
				System.out.print("Type the direction of the building: ");
				String directionBulding = input.next();
				msj = inmobiliary.addBuilding(idBuilding, directionBulding);
				System.out.println(msj);
				break;

			case 2: //Add apartment to a bulding
				System.out.print("Type the id of the bulding where is going to be added the apartment: "); ///////////
				idBuilding = input.next();
				if(inmobiliary.searchBuildingById(idBuilding) != -1){
					System.out.print("Type the id of the apartment: ");
					apartmentId = input.next();
					while (sw3){
						System.out.print("Type the number of rooms of the apartment: ");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						numPrueba = input.nextInt();
						if(inmobiliary.validateIfPositive(numPrueba)){
						numRooms = numPrueba;
						sw3 = false;
						}else{
							System.out.println("Type a positive number");
						}
					}
					while(sw4){
						System.out.print("Type the number of baths of the aparment: ");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						numPrueba = input.nextInt();
						if(inmobiliary.validateIfPositive(numPrueba)){
							numBaths = numPrueba;
							sw4 = false;
						}else{
							System.out.println("Type a positive number");
						}
					}
					while(sw){
						System.out.println("The apartment has balcony: \n" + 
										 "(1) Yes\n" +
										 "(0) No");
						while (!input.hasNextInt()){
							input.next();
							System.out.println("Enter a valid integer number ");
						}
						numPrueba = input.nextInt();
						if(inmobiliary.verifyCorrectOption(numPrueba)){
							balcony = numPrueba;
							sw = false;
						}else{
							System.out.println("Type a correct option");
						}
					}
					System.out.print("Type the cost of the rent: ");
					while (!input.hasNextDouble()){
						input.next();
						System.out.println("Enter a valid double number ");
					}
					double cost = input.nextDouble();
					msj = inmobiliary.addApartmentToBulding(idBuilding, apartmentId, numRooms, numBaths, balcony, cost);
					System.out.println(msj);

				}else{
					System.out.println("The building doesn't exist");
				}
				
				break;

			case 3: //Register an owner
				System.out.println("To register an owner it's necesary to have a apartment and a building, because an owner needs both to be registered");
				System.out.print("Type the building id: ");
				idBuilding = input.next();
				if(inmobiliary.searchBuildingById(idBuilding) != -1){
					System.out.print("Type the id of the apartment that the owner is going to buy: ");
					apartmentId = input.next();
					if(inmobiliary.callVerifyIfApartmentExist(idBuilding,apartmentId) != -1){
						if(inmobiliary.verifyIfApartmentHasOwner(idBuilding,apartmentId) == -1){
							System.out.print("Type the id of the owner: ");
							String ownerId = input.next();
							System.out.print("Type the document number of the owner: ");
							String ownerNumDocument = input.next();
							System.out.print("Type the owner's name: ");
							String ownerName = input.next();
							System.out.print("Type the owner's phone number: ");
							String ownerNumPhone = input.next();
							while(sw){
								System.out.print("Type the phone type: \n"+
												 "0. HOME \n" +
												 "1. OFFICE \n" +
												 "2. MOVIL \n"+
												 "3. FAMILY \n"+
												 "4. OTHER \n" );
								while (!input.hasNextInt()){
									input.next();
									System.out.println("Enter a valid integer number ");
								}
								numPrueba = input.nextInt();
								if(inmobiliary.validateCorrectOption(numPrueba)){
									phoneType = numPrueba;
									sw = false;
								}else{
									System.out.println("Type a correct option");
								}
							}
							System.out.print("Type the account number of the owner: ");
							String numAccount = input.next();
							System.out.print("Type the owner's bank's name: ");
							String bankName = input.next();

							msj = inmobiliary.callAddOwner(idBuilding, apartmentId, ownerId, ownerNumDocument, ownerName, ownerNumPhone, phoneType, numAccount, bankName);
							System.out.println(msj);
						}else{
							System.out.println("The aparment already has an owner");
						}
					}else{
						System.out.println("The aparment doesn't exist");
					}
				}else{
					System.out.println("The bulding doesn't exist");
				}
				break;

			case 4: //Register a tenant
				System.out.println("To register a Tenant it's necesary to have an apartment and a building, because a tenant needs both to be registered");
				System.out.print("Type the building id: ");
				idBuilding = input.next();
				if(inmobiliary.searchBuildingById(idBuilding) != -1){
					System.out.print("Type the id of the apartment that tenant is going to be: ");
					apartmentId = input.next();
					if(inmobiliary.callVerifyIfApartmentExist(idBuilding,apartmentId) != -1){
						if(inmobiliary.verifyIfApartmentHasTenant(idBuilding,apartmentId) == -1){
							System.out.print("Type the id of the tenant: ");
							String tenantId = input.next();
							System.out.print("Type the document number of the tenant: ");
							String tenantNumDocument = input.next();
							System.out.print("Type the tenant's name: ");
							String tenantName = input.next();
							System.out.print("Type the tenant's phone number: ");
							String tenantNumPhone = input.next();
							while(sw){
								System.out.print("Type the phone type: \n"+
												 "0. HOME \n" +
												 "1. OFFICE \n" +
												 "2. MOVIL \n"+
												 "3. FAMILY \n"+
												 "4. OTHER \n" );
								while (!input.hasNextInt()){
									input.next();
									System.out.println("Enter a valid integer number ");
								}
								numPrueba = input.nextInt();
								if(inmobiliary.validateCorrectOption(numPrueba)){
									phoneType = numPrueba;
									sw = false;
								}else{
									System.out.println("Type a correct option");
								}
							}
							msj = inmobiliary.callAddTenant(idBuilding, apartmentId, tenantId, tenantNumDocument, tenantName, tenantNumPhone, phoneType);
							System.out.println(msj);
						}else{
							System.out.println("The aparment already has a tenant");
						}
					}else{
						System.out.println("The aparment doesn't exist");
					}
				}else{
					System.out.println("The bulding doesn't exist");
				}
				break;

			case 5: //Show how many apartments are available by building
				System.out.print("Type the id of the building:");
				idBuilding = input.next();
				msj = inmobiliary.availableApartmentByBuilding(idBuilding);
				System.out.println(msj);
				break;

			case 6: //Show amount of money of the rents by building
				System.out.print("Type the id of the building: ");
				idBuilding = input.next();
				msj = inmobiliary.countRentsByBuilding(idBuilding);
				System.out.println(msj);

				break;
			case 7: //Verify if an apartment is available
				System.out.print("Type the id of the building: ");
				idBuilding = input.next();
				System.out.print("Type the id of the apartment: ");
				apartmentId = input.next();
				msj = inmobiliary.callVerifyTenantFromApartment(idBuilding, apartmentId);
				System.out.println(msj);

				break;
			case 8: //Consult how many rented apartments an owner has
				System.out.print("Type the id of the building: ");
				idBuilding = input.next();
				System.out.print("Type the id of the owner: ");
				String ownerId = input.next();
				msj = inmobiliary.callAmountApartmentsRentedByOwner(idBuilding, ownerId);
				System.out.println(msj);
				break;
				
			case 9: // Consult how much money an owner recives from his rented apartments

				break;

			case 0:
				System.out.println("Exit program");
				break;

			default:
				System.out.println("Invalid option");
				break;

		}
	}

	
}