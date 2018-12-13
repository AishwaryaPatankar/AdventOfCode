import resources.Constants;

import java.sql.SQLOutput;
import java.util.*;

public class Day3 {


    public static void challenge1() {
        Integer total = calculateDisputedAreas(Constants.trialClaim);
        System.out.printf("Day 3: Challenge 1 completed. \n \t Square feet that are shared between two or more claims are %d \n", total);
    }

    public static void challenge2() {
        Integer claim = findClaimNotOverlapped(Constants.claims);
        System.out.printf("Day 1: Challenge 2 completed. \n \t Claim not overlapped is %d \n", claim);
    }

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

                }
            }

        }

        return total;
    }


    private static Integer findClaimNotOverlapped (String input){
        String[] claimArray = input.split("\n");
        HashMap<String, Integer> areaHash = new HashMap<>();
        Integer startX;
        Integer startY;
        Integer width;
        Integer height;
        String claimNumber;

        for (String claim : claimArray) {
            startX = Integer.valueOf(claim.split(" @ ")[1].split(",")[0]);
            startY = Integer.valueOf(claim.split(" @ ")[1].split(",")[1].split(": ")[0]);
            width = Integer.valueOf(claim.split(": ")[1].split("x")[0]);
            height = Integer.valueOf(claim.split(": ")[1].split("x")[1]);


            for (int i = startX; i < startX + width; i++) {

                for (int j = startY; j < startY + height; j++) {
                    String key = String.valueOf(i) + "-" + String.valueOf(j);
                    if (areaHash.containsKey(key)) {
                        areaHash.put(key, areaHash.get(key) + 1);

                    } else {
                        areaHash.put(key, 1);
                    }

                }
            }

        }
        List<String> goodClaims = new ArrayList<String>();
        for(String claim: claimArray){

            startX = Integer.valueOf(claim.split(" @ ")[1].split(",")[0]);
            startY = Integer.valueOf(claim.split(" @ ")[1].split(",")[1].split(": ")[0]);
            width = Integer.valueOf(claim.split(": ")[1].split("x")[0]);
            height = Integer.valueOf(claim.split(": ")[1].split("x")[1]);
            claimNumber = claim.split(" @ ")[0];
            goodClaims.add(claimNumber);


            for (int k = startX; k< startX+width; k++){
                for(int l = startY; l<startY+height; l++){
                    if(!areaHash.get(k+"-"+l).equals(1)&&!areaHash.get(k+"-"+l).equals(0)){
                        goodClaims.remove(claimNumber);
                    }

                }
            }

        }

        System.out.println(goodClaims);


        return Integer.valueOf(goodClaims.get(0).replace("#", ""));
    }

}
