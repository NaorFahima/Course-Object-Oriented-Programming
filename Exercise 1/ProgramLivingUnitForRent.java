package Task_1;

import java.util.Scanner;

public class ProgramLivingUnitForRent {

	public static void main(String[] args) {
	
		final int MAX_UNIT_FOR_RENT = 15;
		
		Scanner sca = new Scanner(System.in);
		LivingUnitForRent[] allRealEstate = new LivingUnitForRent[MAX_UNIT_FOR_RENT];

		LivingUnitForRentUtilities.UIDialog(allRealEstate, sca);
	}
}
