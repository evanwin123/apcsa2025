package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";
        Roomba cleaner = new Roomba();

        // Call cleanRoom and print total beepers cleaned
        double totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        System.out.println("Total beepers cleaned (from main): " + totalBeepers);
    }

    public double cleanRoom(String worldName, int startX, int startY) {
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);

        // Start Roomba at specified coordinates and facing West
        Robot roomba = new Robot(26, 149, West, 0);

        double totalPiles = 0.0;
        double largestPile = 0.0;
        double largestX = 0.0;
        double largestY = 0.0;
        double totalBeepers = 0.0; 
        double totalSquaresMoved = 2.0; // counts first/last spaces that don’t count normally

        while (true) {
            double pileSize = 0.0;

            // Pick up all beepers on current square
            while (roomba.nextToABeeper()) {
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

            if (roomba.frontIsClear()) {
                roomba.move();
                totalSquaresMoved++;
            } else {
                // Turn and move to next row if possible
                if (roomba.facingEast()) {
                    roomba.turnLeft();
                    if (!roomba.frontIsClear()) break;
                    roomba.move();
                    totalSquaresMoved++;
                    roomba.turnLeft();
                } else if (roomba.facingWest()) {
                    roomba.turnLeft(); roomba.turnLeft(); roomba.turnLeft();
                    if (!roomba.frontIsClear()) break;
                    roomba.move();
                    totalSquaresMoved++;
                    roomba.turnLeft(); roomba.turnLeft(); roomba.turnLeft();
                } else {
                    break;
                }
            }
        }

        // Calculate statistics
        double avgPileSize = (totalPiles > 0) ? totalBeepers / totalPiles : 0.0;
        double percentDirty = (totalSquaresMoved > 0) ? (totalPiles / totalSquaresMoved) * 100.0 : 0.0;

        roomba.turnOff();

        // Print results
        System.out.println("Total piles: " + totalPiles);
        System.out.println("Total area of room: " + totalSquaresMoved);
        System.out.println("Largest pile: " + largestPile);
        System.out.println("Largest pile location (Street, Avenue): (" + largestX + "," + largestY + ")");
        System.out.println("Total beepers cleaned: " + totalBeepers);
        System.out.println("Average pile size: " + avgPileSize);
        System.out.println("Percent dirty: " + percentDirty + "%");

        return totalBeepers;
    }
}
