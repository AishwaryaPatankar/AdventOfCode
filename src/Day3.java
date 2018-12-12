import resources.Constants;

import java.sql.SQLOutput;
import java.util.*;

public class Day3 {


    public static void challenge1() {
        Integer total = calculateDisputedAreas(Constants.trialClaim);
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
        String claimNumber = "";

//        List<String> claimNumbersNotOverlapped = Collections.emptyList();
        List<String> claimNumbersNotOverlapped = new ArrayList<>();

        for (String claim : claimArray) {
            claimNumber = claim.split(" @ ")[0];
            startX = Integer.valueOf(claim.split(" @ ")[1].split(",")[0]);
            startY = Integer.valueOf(claim.split(" @ ")[1].split(",")[1].split(": ")[0]);
            width = Integer.valueOf(claim.split(": ")[1].split("x")[0]);
            height = Integer.valueOf(claim.split(": ")[1].split("x")[1]);
            claimNumbersNotOverlapped.add(claimNumber);


            for (int i = startX; i < startX + width; i++) {

                for (int j = startY; j < startY + height; j++) {
                    String key = String.valueOf(i) + "-" + String.valueOf(j);
                    if (areaHash.containsKey(key)) {
                        areaHash.put(key, areaHash.get(key) + 1);

                    } else {
                        areaHash.put(key, 1);
                    }
                    if ((areaHash.get(key)).equals(2)) {
                        total++;

                    }
                    if(areaHash.get(key)>1 && claimNumbersNotOverlapped.contains(claimNumber)){
                            claimNumbersNotOverlapped.remove(claimNumber);
                    }

                }
            }

        }

        System.out.println(claimNumbersNotOverlapped);
//        System.out.println(areaHash.entrySet().stream().filter(stringIntegerEntry -> {stringIntegerEntry.getValue() == 2}).collect(Collections.).;

        return total;
    }
}
