package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
	}

	// declared here so it is visible in all the methods!
	

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);
		Robot roomba = new Robot(26,149,West,0);

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.//area
	int totalPiles = 0;
	int largestPile = 0;
	double largest_pile_x = 0;
	double largest_pile_y = 0;
	int totalBeepers = 0; 
	int totalSquareMoved = 2;
	int numPiles = 0;
	




		


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		//KEEP MOVING INFINITE LOOP
		while(roomba.frontIsClear())
		{
			//ROW
			while(roomba.frontIsClear())
			{
			
				while(roomba.nextToABeeper())
				{
					
					totalBeepers++;
					roomba.pickBeeper();
				
					
				}
				roomba.move();
				totalSquareMoved++;
				if (!roomba.frontIsClear()) break;

			}

			if(roomba.facingEast())
			{
				
				
				roomba.turnLeft();                      
				if(!roomba.frontIsClear()) break;
				roomba.move();
				totalSquareMoved++;

				roomba.turnLeft();

				while(roomba.nextToABeeper())
				{
					roomba.pickBeeper();
					totalBeepers++;
				}
			}
			
			else if(roomba.facingWest()) 
			{
				while(roomba.nextToABeeper())
					roomba.pickBeeper();
					totalBeepers++;
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				if(!roomba.frontIsClear()) break;
			
				
				roomba.move();
				totalSquareMoved++;
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();

				
				

			
			}





		}
		System.out.println("The total number of piles is : " + totalPiles);
		System.out.println("The total area of the room is : " + totalSquareMoved);
		System.out.println("The total number of piles is " + numPiles);
		System.out.println("The largest pile is " + largestPile);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

		System.out.println("Test");
		
		
		//int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
		
}
