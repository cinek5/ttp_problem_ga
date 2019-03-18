package utils;

import model.CityNode;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Created by Cinek on 10.03.2019.
 */
public class MathUtils {
    public static  double calculateDistanceBetweenTwoCities(CityNode city1, CityNode city2)
    {
        float x1 = city1.getX();
        float y1 = city1.getY();
        float x2 = city2.getX();
        float y2 = city2.getY();
        return Point2D.distance(x1, y1, x2, y2);
    }

    public static double randDouble(double min, double max) {

        Random rand = new Random();

        double result = rand.nextDouble() * (max - min) + min;

        return result;

    }
    public static int randInt(int min, int max) {


        int result = (int) (Math.random() * (max - min) + min);

        return result;

    }
}
