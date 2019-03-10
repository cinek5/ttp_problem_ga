package loader;

import model.CityNode;
import model.Item;
import problem.Problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cinek on 10.03.2019.
 */
public class Loader {
    public Problem loadProblemData(String path) throws FileNotFoundException
    {
        File file = new File(path);
        Scanner reader = new Scanner(file);

        omitLines(reader, 2);

        reader.next();
        int dimension = reader.nextInt();
        reader.nextLine();
        omitWords(reader, 3);
        int numberOfItems = reader.nextInt();
        reader.nextLine();
        omitWords(reader, 3);
        int knapsackCapacity = reader.nextInt();
        reader.nextLine();
        omitWords(reader, 2);
        float minSpeed = Float.parseFloat(reader.next());
        reader.nextLine();
        omitWords(reader, 2);
        float maxSpeed = Float.parseFloat(reader.next());
        reader.nextLine();

        omitLines(reader, 3);
        HashMap<Integer, CityNode> citiesByIndex = new HashMap<Integer, CityNode>(dimension);
        for (int i=1; i<=dimension; i++)
        {
            int index = reader.nextInt();
            float x = Float.parseFloat(reader.next());
            float y = Float.parseFloat(reader.next());
            CityNode city = new CityNode(index, x, y);

            citiesByIndex.put(index, city);
            reader.nextLine();

        }
        omitLines(reader, 1);
        List<Item> allItems = new ArrayList<>(numberOfItems);
        for (int i=1; i<=numberOfItems; i++)
        {
            int index = reader.nextInt();
            int profit = reader.nextInt();
            int weight = reader.nextInt();
            int cityIndex = reader.nextInt();

            Item item = new Item(index, profit, weight, cityIndex);
            allItems.add(item);

            citiesByIndex.get(index).addItem(item);
            reader.nextLine();
        }

        Problem  pro8l3m= new Problem(new ArrayList<>(citiesByIndex.values()), dimension, numberOfItems, minSpeed, maxSpeed, knapsackCapacity, allItems);

        return pro8l3m;


    }

    private void omitLines(Scanner scanner, int numberOfLines)
    {
        for (int i=0; i< numberOfLines; i++ )
        {
            scanner.nextLine();
        }
    }
    private void omitWords(Scanner scanner, int numberOfWords)
    {
        for (int i=0; i<numberOfWords; i++)
        {
            scanner.next();
        }
    }
}
