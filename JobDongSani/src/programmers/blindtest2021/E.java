package programmers.blindtest2021;

import java.util.ArrayList;
import java.util.Arrays;

public class E {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertStrToSec(play_time);
        int advTime = convertStrToSec(adv_time);

        int[][] timelogs = new int[logs.length][2];
        ArrayList<Integer> startendsList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] interval = logs[i].split("-");
            timelogs[i][0] = convertStrToSec(interval[0]);
            timelogs[i][1] = convertStrToSec(interval[1]);
            startendsList.add(timelogs[i][0]);
            startendsList.add(timelogs[i][1]);
        }
        startendsList.add(0);
        startendsList.add(playTime);

        int[] startends = new int[startendsList.size()];
        for (int i = 0; i < startendsList.size(); i++) {
            startends[i] = startendsList.get(i);
        }

        Arrays.sort(startends);

        int maxAdvPlayTime = 0;
        int advStartTime = playTime;
        for (int i = 0; i < startends.length; i++) {
            // 광고가 해당 시간부터 시작할 때
            int st = startends[i];
            int et = st + advTime;
            int pt = find(st, et, playTime, timelogs);
            if(maxAdvPlayTime < pt){
                maxAdvPlayTime = pt;
                advStartTime = st;
            }else if(maxAdvPlayTime == pt){
                if(advStartTime > st){
                    advStartTime = st;
                }
            }
            
            // 광고가 해당 시간에서 끝날 때
            et = startends[i];
            st = et - advTime;
            pt = find(st, et, playTime, timelogs);
            if(maxAdvPlayTime < pt){
                maxAdvPlayTime = pt;
                advStartTime = st;
            }else if(maxAdvPlayTime == pt){
                if(advStartTime > st){
                    advStartTime = st;
                }
            }
        }

        int sec = advStartTime % 60;
        int min = ((advStartTime - sec) % 3600) / 60;
        int hour = (advStartTime - (min * 60) - sec) / 3600;

        String secStr = String.valueOf(sec);
        String minStr = String.valueOf(min);
        String hourStr = String.valueOf(hour);
        if(secStr.length() == 1){
            secStr = "0" + secStr;
        }
        if(minStr.length() == 1){
            minStr = "0" + minStr;
        }
        if(hourStr.length() == 1){
            hourStr = "0" + hourStr;
        }

        return hourStr + ":" + minStr + ":" + secStr;
    }

    private static int find(int st, int et, int playTime, int[][] timelogs) {
        int timeSum = 0;

        if(st < 0 || st > playTime || et < 0 || et > playTime){
            return -1;
        }

        for (int i = 0; i < timelogs.length; i++) {
            if(st > timelogs[i][1] || et < timelogs[i][0]){
                continue;
            }
            int start = 0;
            int end = 0;
            if(st < timelogs[i][0]){
                start = timelogs[i][0];
            }else{
                start = st;
            }
            if(et > timelogs[i][1]){
                end = timelogs[i][1];
            }else{
                end = et;
            }
            timeSum += (end - start);
        }

        return timeSum;
    }

    private static int convertStrToSec(String str){
        String[] hms = str.split(":");
        return (3600 * Integer.parseInt(hms[0])) + (60 * Integer.parseInt(hms[1])) + (Integer.parseInt(hms[2]));
    }
}
