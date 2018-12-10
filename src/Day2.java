import resources.Constants;

public class Day2 {

    public static void challenge1() {
        Integer total = calculateCheckSum(Constants.boxNames);
        System.out.printf("Day 2: Challenge 1 completed. \n \t Check sum is %d \n", total);
    }

    public static void challenge2() {
        String commonLetters = findCommonLettersOfNamesOffByOne(Constants.boxNames);
        System.out.printf("Day 1: Challenge 2 completed. \n \t The common letters are %s \n", commonLetters);
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



    private static String findCommonLettersOfNamesOffByOne(String names){
        //This will only work if all the boxes have names with the same number of letters
        String[] nameArray = names.split("\n");
        int numLetters = nameArray[0].length();
        int arrayCounter=0;

        String returnString = "";

        for (int i=0; i<numLetters; i++){
            for(arrayCounter=0; arrayCounter<nameArray.length; arrayCounter++){
                String currentMinusLetter = minusChar(nameArray[arrayCounter], i);
                for(int secondArrayCounter=arrayCounter+1; secondArrayCounter<nameArray.length; secondArrayCounter++){
                    String secondCurrentMinusLetter = minusChar(nameArray[secondArrayCounter],i);
                    if (currentMinusLetter.equals(secondCurrentMinusLetter)){
                        returnString = currentMinusLetter;

                    }
                }


            }
        }


        return returnString;
    }

    private static String minusChar (String str, int i){
        return str.substring(0, i) + str.substring(i + 1, str.length());
    }

}