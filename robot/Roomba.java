package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";
		Roomba cleaner = new Roomba();
		double totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
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
	double totalPiles = 0;
	double largestPile = 0;
	double largest_pile_x = 0;
	double largest_pile_y = 0;
	double totalBeepers = 0; 
	double totalSquareMoved = 2;
	
	




		


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		//KEEP MOVING INFINITE LOOP
		while(true) {
            double pileSize = 0;
			while(roomba.nextToABeeper()) 
			{
                pileSize++;
                roomba.pickBeeper();
                totalBeepers++;
            }
				if (pileSize > 0) {
                    totalPiles++;
                    if (pileSize > largestPile) {
                        largestPile = pileSize;
                        largestX = roomba.street();
                        largestY = roomba.avenue();
                    }
                
                }
                if(roomba.frontIsClear()) {
                    roomba.move();
                    totalSquareMoved++;
                } else {
                    if(roomba.facingEast()) {
                        roomba.turnLeft();
                        if(!roomba.frontIsClear()) break;
                        roomba.move();
                        totalSquareMoved++;
                        roomba.turnLeft();
                    } else if(roomba.facingWest()) {
                        roomba.turnLeft(); 
                        roomba.turnLeft(); 
                        roomba.turnLeft();
                        if(!roomba.frontIsClear()) break;
                        roomba.move();
                        totalSquareMoved++;
                        roomba.turnLeft();
                        roomba.turnLeft();
                        roomba.turnLeft();
                     } else {
                        break;
                     }
                }
            }
		
            double avgPileSize = (totalPiles > 0) ? totalBeepers / totalPiles : 0;
            double percentDirty = (totalSquareMoved > 0) ? (totalPiles / totalSquareMoved) * 100 : 0;
				
        System.out.println("The total number of piles is : " + totalPiles);
		System.out.println("The total area of the room is : " + totalSquareMoved);
		System.out.println("The total number of piles is " + largestPile);
		System.out.println("Location of largest pile (Street Avenue): (" + largestX "," + largestY + ")");
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
        System.out.println("Average pile size: " + avgPileSize);
        System.out.println("Percent dirty: " + percentDirty + "%");
		
		return totalBeepers;

				
				

			
			}





		}
		
		//int totalBeepers = 0; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
	}
		
}
