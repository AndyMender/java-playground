package codecademy.intermediate_course;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;


public class MapCount {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        int bounds = 20;
        int maxNumber = 5;

        // Populate list with random numbers
        for (int i = 0; i < bounds; i++) {
            integers.add(random.nextInt(maxNumber));
        }

        System.out.println("Random numbers in range 0 to " + (maxNumber - 1) + ": " + integers);

        Map<Integer, Integer> counts = countNumbers(integers);

        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            System.out.println("Number: " + entry.getKey() + ", count: " + entry.getValue());
        }
    }   

    // We allow all collection types, since the same for-loop can be used
    public static Map<Integer, Integer> countNumbers(Collection<Integer> integers) {
        Map<Integer, Integer> intCounts = new HashMap<>();

        for (Integer element : integers) {
            Integer currCount = intCounts.get(element);
            // Empty - new item
            if (currCount == null) {
                intCounts.put(element, 1);
            } 
            // Non-empty - existing item
            else {
                // NOTE: Don't increment in-place in case the reference was pulled from the Map
                intCounts.put(element, currCount + 1);
            }
        }

        return intCounts;
    }
}
