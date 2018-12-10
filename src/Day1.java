import resources.Constants;

import java.util.ArrayList;


public class Day1 {

    public static void challenge1() {
        Integer total = calculateFrequency(Constants.frequencyConstants);
        System.out.printf("Day 1: Challenge 1 completed. \n \t Total frequency is %d \n", total);
    }

    public static void challenge2() {
        Integer repeated = findRepeatedFrequency(Constants.frequencyConstants);
        System.out.printf("Day 1: Challenge 2 completed. \n \t First repeated total frequency is %d \n", repeated);
    }


    public static Integer calculateFrequency(String inputFrequencies) {
        String[] numbersAsString = inputFrequencies.split("\n");

        Integer total = 0;

        for (String number : numbersAsString) {
            total += Integer.parseInt(number);
        }

        return total;
    }

    public static Integer findRepeatedFrequency(String inputFrequencies) {
        String[] numbersAsString = inputFrequencies.split("\n");

        ArrayList<Integer> totals = new ArrayList<Integer>();
        totals.add(0);
        Integer firstRepeatedFrequencyTotal = null;
        int numbersCounter = 0;
        int totalsCounter = 0;

        while (firstRepeatedFrequencyTotal == null) {
            Integer currentSum = Integer.parseInt(numbersAsString[numbersCounter]);
            if (!totals.isEmpty()) {
                currentSum = totals.get(totalsCounter) + Integer.parseInt(numbersAsString[numbersCounter]);
            }

            if (totals.contains(currentSum)) {
                firstRepeatedFrequencyTotal = currentSum;
            }
            totals.add(currentSum);
            numbersCounter = (numbersCounter + 1) % (numbersAsString.length);
            totalsCounter = (totalsCounter + 1);
        }
        return firstRepeatedFrequencyTotal;
    }

}
