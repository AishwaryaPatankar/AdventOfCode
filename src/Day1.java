import resources.Constants;

public class Day1 {

    public static void challenge1() {
        Integer total = calculateFrequency(Constants.frequencyConstants);
        System.out.printf("Day 1: Challenge 1 completed. \n \t Total frequency is %d", total);

    }


    public static Integer calculateFrequency(String inputFrequencies) {
        String[] numbersAsString = inputFrequencies.split("\n");

        Integer total = 0;

        for (String number : numbersAsString) {
            total += Integer.parseInt(number);
        }

        return total;
    }

}
