package algorithm.baekjoon.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Segmentation {
	
	private static final String NEW_CUSTOMER = "New Customer";
	private static final String PROMISING = "Promising";
	private static final String ABOUT_TO_SLEEP = "About to Sleep";
	private static final String HIBERNATING = "Hibernating";
	private static final String LOST = "Lost";
	private static final String POTENTIAL_LOYALIST = "Potential Loyalist";
	private static final String NEED_ATTENTION = "Need Attention";
	private static final String ABOUT_TO_LEAVE = "About to Leave";
	private static final String CHAMPION = "Champion";
	private static final String LOYAL_CUSTOMER = "Loyal Customer";
	private static final String CANT_LOSE_THEM = "Can't Lose Them";
	private static final String NONE = "None";
	
	private static String classify(int[] rNums, int[] fNums, int r, int f) {
		if(r <= rNums[0]) {
			if(f <= fNums[0]) return NEW_CUSTOMER;
			else if(f <= fNums[2]) return POTENTIAL_LOYALIST;
			else if(f <= fNums[3]) return LOYAL_CUSTOMER;
			else return CHAMPION;
		}else if(r <= rNums[1]) {
			if(f <= fNums[0]) return PROMISING;
			else if(f <= fNums[2]) return POTENTIAL_LOYALIST;
			else return LOYAL_CUSTOMER;
		}else if(r <= rNums[2]) {
			if(f <= fNums[1]) return ABOUT_TO_SLEEP;
			else if(f <= fNums[2]) return NEED_ATTENTION;
			else return LOYAL_CUSTOMER;
		}else if(r <= rNums[3]) {
			if(f <= fNums[0]) return LOST;
			else if(f <= fNums[1]) return HIBERNATING;
			else return ABOUT_TO_LEAVE;
		}else {
			if(f <= fNums[1]) return LOST;
			else if(f <= fNums[3]) return ABOUT_TO_LEAVE;
			else return CANT_LOSE_THEM;
		}
	}

	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		OutputStreamWriter wt = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(wt);
		
		String str = null;
		int iter = 0;
		int[] rNums = new int[4];
		int[] fNums = new int[4];
		int testNum = 0;
		int presentTime = 1;
		Map<String, Integer[]> userMap = new HashMap<String, Integer[]>(); 
		try {
			while((str = br.readLine()) != null) {
				if(iter == 0) {
					String[] rIndex = str.split(" ");
					for(int i=0;i<4;i++)
						rNums[i] = Integer.parseInt(rIndex[i]);
				}
				else if(iter == 1) {
					String[] fIndex = str.split(" ");
					for(int i=0;i<4;i++)
						fNums[i] = Integer.parseInt(fIndex[i]);
				}else if(iter == 2) {
					testNum = Integer.parseInt(str);
				}else {
					String[] event = str.split(" ");
					int action = Integer.parseInt(event[0]);
					String name = event[1];
					if(2 == action) {
						if(userMap.isEmpty()) {
							bw.write(NONE);
							bw.newLine();
						}else {
							Iterator iterator = userMap.keySet().iterator();
							while(iterator.hasNext()) {
								String userName = (String) iterator.next();
								Integer[] rf = userMap.get(userName);
								rf[0]++;
								userMap.put(userName, rf);
							}
							if(!userMap.containsKey(name))
								bw.write(NONE);
							else {
								Integer[] rf = userMap.get(name);
								bw.write(classify(rNums, fNums, rf[0].intValue(), rf[1].intValue()));
							}
							bw.newLine();
						}
					}
					else {
						if(userMap.isEmpty())
							userMap.put(name, new Integer[] {0, 1});
						else{
							Iterator iterator = userMap.keySet().iterator();
							while(iterator.hasNext()) {
								String userName = (String) iterator.next();
								Integer[] rf = userMap.get(userName);
								if(name.equals(userName)) {
									rf[0] = 0;
									rf[1]++;
								}else
									rf[0]++;
								userMap.put(userName, rf);
							}
							if(!userMap.containsKey(name))
								userMap.put(name, new Integer[] {0, 1});
						}
					}
					if(testNum == presentTime)
						break;
					else
						presentTime++;
				}
				iter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();}catch(IOException e) {}
			if(rd != null) try {rd.close();}catch(IOException e) {}
			if(bw != null) try {bw.close();}catch(IOException e) {}
			if(wt != null) try {wt.close();}catch(IOException e) {}
		}
	}
}
