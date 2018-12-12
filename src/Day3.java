import resources.Constants;

import java.util.HashMap;

public class Day3 {


    public static void challenge1() {
        Integer total = calculateDisputedAreas(Constants.claims);
        System.out.printf("Day 3: Challenge 1 completed. \n \t Square feet that are shared between two or more claims are %d \n", total);
    }

//    public static void challenge2() {
//        Integer repeated = findRepeatedFrequency(Constants.frequencyConstants);
//        System.out.printf("Day 1: Challenge 2 completed. \n \t First repeated total frequency is %d \n", repeated);
//    }

    private static Integer calculateDisputedAreas(String claims) {
        String[] claimArray = claims.split("\n");
        HashMap<String, Integer> areaHash = new HashMap<>();
        Integer startX;
        Integer startY;
        Integer width;
        Integer height;
        Integer total = 0;

        for (String claim : claimArray) {
            startX = Integer.valueOf(claim.split(" @ ")[1].split(",")[0]);
            startY = Integer.valueOf(claim.split(" @ ")[1].split(",")[1].split(": ")[0]);
            width = Integer.valueOf(claim.split(": ")[1].split("x")[0]);
            height = Integer.valueOf(claim.split(": ")[1].split("x")[1]);


            for (int i = startX; i < startX + width + 1; i++) {
                for (int j = startY; j < startY + height + 1; j++) {
                    String key = String.valueOf(i) + "-" + String.valueOf(j);
                    if (areaHash.containsValue(key)) {
                        areaHash.put(key,areaHash.get(key)+1);
                    }
                    else{
                        areaHash.put(key,1);
                    }
                    if(areaHash.get(key)==2){
                        total++;
                    }

                }
            }

        }

        return total;
    }
}
