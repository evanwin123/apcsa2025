package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// declared here so it is visible in all the methods!
	

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(1);
		Robot roomba = new Robot(8,8,South,1000);

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.
boolean done = false;
int totalBeepers = 0; // Need to move this somewhere else.
int totalSquareMoved = 0;
int totalPiles = 0;

		


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		while(!done)
		{
		while(roomba.frontIsClear())
		{
		
		
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			
				
			}
				roomba.move();
				totalSquareMoved++;

		}
		roomba.turnLeft();
		while(roomba.frontIsClear())
		{
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			}
				roomba.move();
				totalSquareMoved++;
		}
		if(roomba.facingEast())
		{
			roomba.turnLeft();
			roomba.move();
			totalSquareMoved++;

			roomba.turnLeft();
		}

		while(roomba.frontIsClear())
		{
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			}
			roomba.move();
			totalSquareMoved++;

		}
		if(roomba.facingWest())
		{
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.move();
			totalSquareMoved++;
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
		}
		while(roomba.frontIsClear())
		{
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			}
			roomba.move();
			totalSquareMoved++;

		}
		if(roomba.facingEast())
		{
			roomba.turnLeft();
			roomba.move();
			totalSquareMoved++;

			roomba.turnLeft();
		}
		while(roomba.frontIsClear())
		{
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			}
			roomba.move();
			totalSquareMoved++;

		}
		if(roomba.facingWest())
		{
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.move();
			totalSquareMoved++;
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();

		}
		if (done) {
			
		}
		while(roomba.frontIsClear())
		{
			while(roomba.nextToABeeper())
			{
				totalBeepers++;
				roomba.pickBeeper();
			}
			roomba.move();
			totalSquareMoved++;
		}
		
		System.out.println("Roomba total moves : " + totalSquareMoved);
		System.out.println("The total number of piles is : " + totalPiles);
		System.out.println("The total area of the room is : 40 moves");
		
		//int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
	return totalSquareMoved;
}
}
