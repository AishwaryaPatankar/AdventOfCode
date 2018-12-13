import resources.Constants;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Day4{
    public static void challenge1() {
        Integer total = sleepyElf(Constants.trialElfNightShift);
        System.out.printf("Day 3: Challenge 1 completed. \n \t Id of the sleepiest elf times the minutes slept is %d \n", total);
    }

//    public static void challenge2() {
//        Integer claim = findClaimNotOverlapped(Constants.claims);
//        System.out.printf("Day 1: Challenge 2 completed. \n \t Claim not overlapped is %d \n", claim);
//    }

    private static Integer sleepyElf(String input) throws ParseException {


        HashMap<String, Integer> minutesSleptByElfOnDays = new HashMap<>();

        DateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        String[] lines = input.split("\n");
        String guardName;
        Date date;

        for(String line: lines){
            guardName = line.split ("Guard #")[1].split(" begins")[0];
            date = (Date) parser.parse(line.substring(1,17));
            if (guardName!=null){

            }
        }


        return 1;
    }

    class elfShift{
        String date;
        String guard;
        Integer minutesSlept;

        public void setDate(String date) {
            this.date = date;
        }

        public void setGuard(String guard) {
            this.guard = guard;
        }

        public void setMinutesSlept(Integer minutesSlept) {
            this.minutesSlept = minutesSlept;
        }

        public String getDate() {
            return date;
        }

        public String getGuard() {
            return guard;
        }

        public Integer getMinutesSlept() {
            return minutesSlept;
        }
    }
}

