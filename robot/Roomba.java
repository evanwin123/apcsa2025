package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	public static void main(String[] args) {
		String worldName = "robot/finalTestWorld2024.wld";
		Roomba cleaner = new Roomba();
		double totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
	}

	public double cleanRoom(String worldName, int startX, int startY) {
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);
		Robot roomba = new Robot(26,149,West,0);

		double totalPiles = 0.0;
		double largestPile = 0.0;
		double largestX = 0.0;
		double largestY = 0.0;
		double totalBeepers = 0.0; 
		double totalSquareMoved = 2.0;

		while(true) {
			double pileSize = 0.0;
			while(roomba.nextToABeeper()) {
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
					roomba.turnLeft(); roomba.turnLeft(); roomba.turnLeft();
					if(!roomba.frontIsClear()) break;
					roomba.move();
					totalSquareMoved++;
					roomba.turnLeft(); roomba.turnLeft(); roomba.turnLeft();
				} else {
					break;
				}
			}
		}

		double avgPileSize = (totalPiles > 0) ? totalBeepers / totalPiles : 0.0;
		double percentDirty = (totalSquareMoved > 0) ? (totalPiles / totalSquareMoved) * 100.0 : 0.0;

		System.out.println("The total number of piles is : " + totalPiles);
		System.out.println("The total area of the room is : " + totalSquareMoved);
		System.out.println("The largest pile is " + largestPile);
		System.out.println("Location of largest pile (Street, Avenue): (" + largestX + "," + largestY + ")");
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
		System.out.println("Average pile size: " + avgPileSize);
		System.out.println("Percent dirty: " + percentDirty + "%");

		return totalBeepers;
	}
}
