package polygon;

import java.awt.geom.Point2D;

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();

        // Add some points so the polygon actually exists
        myPolygon.add(new Point2D.Double(50, 50));
        myPolygon.add(new Point2D.Double(150, 50));
        myPolygon.add(new Point2D.Double(150, 150));
        myPolygon.add(new Point2D.Double(50, 150));

        myPolygon.draw();

        System.out.println("Perimeter: " + myPolygon.perimeter());
        System.out.println("Area: " + myPolygon.area());

        TestSuite.run();
    }
}