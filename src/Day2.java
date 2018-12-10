import resources.Constants;

public class Day2 {

    public static void challenge1() {
        Integer total = calculateCheckSum(Constants.boxNames);
        System.out.printf("Day 2: Challenge 1 completed. \n \t Check sum is %d \n", total);
    }

    public static void challenge2() {
//        System.out.printf("Day 1: Challenge 2 completed. \n \t First repeated total frequency is %d \n", repeated);
    }

    private static Integer calculateCheckSum(String boxNames) {
        String[] nameArray = boxNames.split("\n");
        int twos = 0;
        int threes = 0;

        boolean hasTwos = false;
        boolean hasThrees = false;

        for (String name : nameArray) {
            for (int i = 0; i < name.length(); i++) {
                char current = name.charAt(i);
                int split = (" " + name+ " ").split(String.valueOf(current)).length;
                if (split == 3) {
                    hasTwos = true;
                } else if (split == 4) {
                    hasThrees = true;
                }
            }
            if (hasTwos) {
                twos++;
            }
            if (hasThrees) {
                threes++;
            }
            hasTwos = false;
            hasThrees = false;

        }
        return twos * threes;
    }
}