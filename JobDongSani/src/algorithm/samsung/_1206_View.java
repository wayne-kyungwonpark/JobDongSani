package algorithm.samsung;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/samsung/_1206_View.java
 *
 * Samsung > 문제 > View
 * 1. 빌딩의 높이를 저장할 1차원 int 배열: heights
 * 2. heigths의 length: n
 * 3. heights의 0부터 n - 1 까지 for문을 돌며 다음을 체크한다.
 * 4. 체크하는 건물(i)의 왼쪽 2칸부터 오른쪽 2칸까지 자기자신을 제외하고 maxHeight를 체크한다.
 * 5. heights[i] - maxHeight 가 음수라면 조망권세대는 없다.
 * 6. 음수가 아니라면, 그 값이 해당 건물의 조망권 세대의 수이다.
 * 7. 조망권 확보 세대 수: views
 * 8. 차이를 views에 더해준다.
 */
public class _1206_View {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testFreq = 0;
        int buildingNum = 0;
        int[] heights = null;
        int views = 0;
        while((str = br.readLine()) != null){
            if(buildingNum == 0){
                buildingNum = Integer.parseInt(str);
                heights = new int[buildingNum];
            }else{
                testFreq++;
                String[] strArr = str.split(" ");
                for (int i = 0; i < buildingNum; i++) {
                    heights[i] = Integer.parseInt(strArr[i]);
                }
                for (int i = 2; i < buildingNum - 2; i++) {
                    int max = 0;
                    for (int j = i - 2; j <= i + 2; j++) {
                        if(j != i){
                           if(heights[j] > max){
                               max = heights[j];
                           }
                        }
                    }
                    if(heights[i] - max > 0){
                        views += (heights[i] - max);
                    }
                }
                bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(views));
                if(testFreq != 10){
                    bw.newLine();
                }
                buildingNum = 0;
                heights = null;
                views = 0;
            }
            if(testFreq == 10){
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
