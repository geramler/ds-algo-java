package hashtables;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public static Integer getFirstRecurringCharacter(int[] input) {
        Map<Integer, Boolean> workerMap = new HashMap<>();

        for (int number : input) {
            if (workerMap.containsKey(number)) {
                return number;
            }

            workerMap.put(number, true);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] anArray = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        System.out.println(getFirstRecurringCharacter(anArray));
    }
}