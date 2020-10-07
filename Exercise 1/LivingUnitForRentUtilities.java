package Task_1;

import java.util.Scanner;


public class LivingUnitForRentUtilities {
	
	public static void UIDialog(LivingUnitForRent[] allRealEstate, Scanner sca ) {
		boolean toContinue = false ;
		int menuSelect ,induxRealEstate ,count = 0 ;

		System.out.println("Welcome to Real estate management systems for rent\n");

		do {

			System.out.println("Select one of the following options:");
			System.out.println("(1) Add real estate unit \n(2) Show real estate unit \n(3) Show all real estate unit");
			menuSelect = sca.nextInt();
			
			switch (menuSelect) { //menu select
			
			case 1:	
				System.out.println("(1) Add Appartment For Rent \n(2) Add House For Rent \n(3) Add Room For Rent");
				menuSelect = sca.nextInt();
				
				switch (menuSelect) {

				case 1:
					allRealEstate[count] = new AppartmentForRent();
					break;

				case 2:
					allRealEstate[count] = new HouseForRent();
					break;

				case 3:
					allRealEstate[count] = new RoomForRent();
					break;

				default:
					System.out.println("Error: should select one of the given options");
					break;
				}
				allRealEstate[count++].readData(sca); //Call function that the user enters values
				break;
				
			case 2:
				
				System.out.println("Which real estate you want to show? between 1-" +(count) );
				induxRealEstate = sca.nextInt()-1;
				System.out.println(allRealEstate[induxRealEstate]);
				break;

			case 3:
				for (int i = 0; i < count; i++) {
					System.out.println((i+1) + ") " +allRealEstate[i] );
					System.out.println();
				}
				break;


				default:
					System.out.println("Error: should select one of the given options");
				break;
			}
			
			System.out.println();
			System.out.println("Want to continue?\n(1) Yes \n(2) No");
			menuSelect = sca.nextInt();
			toContinue = ((menuSelect == 1) ? true:false);

		} while (toContinue);
		
		sca.close();

		System.out.println("Goodbye :)");	
	}

}
