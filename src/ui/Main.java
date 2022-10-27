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
				"3. \n" +
				"4.  \n" +
				"5. \n" +
				"6.  \n" +
				"7.  \n" +
				"8.  \n" +
				"9.  \n" +
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
				System.out.print("Type the id of the bulding where is going to be added the apartment: ");
				idBuilding = input.next();
				System.out.print("Type the id of the apartment: ");
				String apartmentId = input.next();
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
									 "(2) No");
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
				while(sw2){
					System.out.println("It has a tenent: \n" +
									 "(1) Yes \n" +
									 "(2) No ");
					while (!input.hasNextInt()){
						input.next();
						System.out.println("Enter a valid integer number ");
					}
					numPrueba = input.nextInt();
					if(inmobiliary.verifyCorrectOption(numPrueba)){
						tenant = numPrueba;
						sw2= false;
					}else{
						System.out.println("Type a correct option");
					}
				}
				msj = inmobiliary.addApartmentToBulding(idBuilding, apartmentId, numRooms, numBaths, balcony, cost, tenant);
				System.out.println(msj);

				break;

			case 3:
				
				break;

			case 4: 

				break;

			case 5: 

				break;

			case 6: 
				
				break;

			case 7: 

				break;

			case 8: 

				break;

			case 9: 

				break;

			case 10: 

				break;

			case 11: 

				break;

			case 12: 

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