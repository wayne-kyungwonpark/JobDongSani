package programmers.blindtest2020_mock;

import java.util.*;

public class ColumnAndBeam {
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
//        HashSet<Struct> set = new HashSet<>();
//        set.add(new Struct(build_frame[0][0], build_frame[0][1], build_frame[0][2]));
//        Struct struct = new Struct(0, 0, 0);
//        System.out.println(set.contains(struct));
        int[][] answer = solution(n, build_frame);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
        }
    }

    public static int[][] solution(int n, int[][] build_frame) {
        HashSet<Struct> set = new HashSet<>();
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            if(b == 0){ // 삭제
                boolean isPossible = true;
                set.remove(new Struct(x, y, a));
                if(a == 0){ // 기둥 삭제
                    if(set.contains(new Struct(x, y + 1, 1))){ // 삭제하는 기둥 위치 오른쪽 위쪽에 보가 존재하는 경우
                        // 해당 보가 삭제하려는 기둥으로 인해 규칙을 만족하는 경우라면 삭제 불가능
                        if(!set.contains(new Struct(x + 1, y, 0)) // 해당 보 오른쪽 아래에 기둥이 존재하지 않고
                                && (!set.contains(new Struct(x + 1, y + 1, 1)) || !set.contains(new Struct(x - 1, y + 1, 1)))){ // 해당 보 양 옆 중 하나라도 보가 존재하지 않는 경우 삭제 불가능
                            isPossible = false;
                        }
                    }
                    if(set.contains(new Struct(x - 1, y + 1, 1))){ // 삭제하는 기둥 위치 왼쪽 위쪽에 보가 존재하는 경우
                        // 해당 보가 삭제하려는 기둥으로 인해 규칙을 만족하는 경우라면 삭제 불가능
                        if(!set.contains(new Struct(x - 1, y, 0)) // 해당 보 왼쪽 아래에 기둥이 존재하지 않고
                                && (!set.contains(new Struct(x - 2, y + 1, 1)) || !set.contains(new Struct(x, y + 1, 1)))){ // 해당 보 양 옆 중 하나라도 보가 존재하지 않는 경우 삭제 불가능
                            isPossible = false;
                        }
                    }
                    if(set.contains(new Struct(x, y + 1, 0))){ // 삭제하는 기둥 위에 기둥이 존재하는 경우
                        if(!set.contains(new Struct(x - 1, y + 1, 1)) // 해당 기둥 왼쪽에도 보가 존재하지 않고
                                && !set.contains(new Struct(x, y + 1, 1))){ // 해당 기둥 오른쪽에도 보가 존재하지 않을 경우 삭제 불가능
                            isPossible = false;
                        }
                    }
                }else { // 보 삭제
                    if(set.contains(new Struct(x, y, 0))){ // 삭제하는 보의 왼쪽 위치에 기둥이 있는 경우
                        if(!set.contains(new Struct(x - 1, y, 1)) // 왼쪽에 다른 보가 없고
                                && !set.contains(new Struct(x, y - 1, 0))){ // 아래에 기둥이 존재하지도 않을 경우 삭제 불가능
                            isPossible = false;
                        }
                    }
                    if(set.contains(new Struct(x + 1, y, 0))){ // 삭제하는 보의 오른쪽 위치에 기둥이 있는 경우
                        if(!set.contains(new Struct(x + 1, y, 1)) // 오른쪽에 다른 보가 없고
                                && !set.contains(new Struct(x + 1, y - 1, 0))){ // 아래에 기둥이 존재하지도 않을 경우 삭제 불가능
                            isPossible = false;
                        }
                    }
                    if(set.contains(new Struct(x - 1, y, 1))) { // 삭제하는 보의 왼쪽에 보가 있는 경우
                        // 왼쪽에 있는 보가 양 옆 보로 인해 규칙을 만족하는 경우라면 삭제 불가능
                        if(!set.contains(new Struct(x - 1, y - 1, 0)) // 왼쪽 보의 왼쪽 아래에 기둥이 존재하지 않고
                                && !set.contains(new Struct(x, y - 1, 0))){ // 왼쪽 보의 오른쪽 아래에도 기둥이 존재하지 않을 경우
                            isPossible = false;
                        }
                    }
                    if(set.contains(new Struct(x + 1, y, 1))) { // 삭제하는 보의 오른쪽에 보가 있는 경우
                        // 오른쪽에 있는 보가 양 옆 보로 인해 규칙을 만족하는 경우라면 삭제 불가능
                        if(!set.contains(new Struct(x + 2, y - 1, 0)) // 오른쪽 보의 오른쪽 아래에 기둥이 존재하지 않고
                                && !set.contains(new Struct(x + 1, y - 1, 0))){ // 오른쪽 보의 왼쪽 아래에도 기둥이 존재하지 않을 경우
                            isPossible = false;
                        }
                    }
                }

                if(!isPossible){
                    set.add(new Struct(x, y, a));
                }
            }else{ // 설치
                if (a == 0) { // 기둥 설치
                    if (x >= 0 && (y == 0 // 바닥이거나
                            || set.contains(new Struct(x, y - 1, 0)) // 아래 기둥이 있거나
                            || set.contains(new Struct(x - 1, y, 1)) // 왼쪽에 보가 있거나
                            || set.contains(new Struct(x, y, 1)))) { // 오른쪽에 보가 있거나
                        set.add(new Struct(x, y, 0));
                    }
                }else{ // 보 설치
                    if(x >= 0 && y > 0 &&
                            (set.contains(new Struct(x, y - 1, 0)) // 왼쪽 아래에 기둥이 있거나
                            || set.contains(new Struct(x + 1, y - 1, 0)) // 오른쪽 아래에 기둥이 있거나
                            || (set.contains(new Struct(x - 1, y, 1)) && set.contains(new Struct(x + 1, y, 1))))){ // 양옆에 보가 존재하거나
                        set.add(new Struct(x, y, 1));
                    }
                }
            }
        }

        int[][] answer = new int[set.size()][3];
        int index = 0;
        for(Struct struct : set){
            answer[index][0] = struct.x;
            answer[index][1] = struct.y;
            answer[index][2] = struct.s;
            index++;
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] > o2[0]){
                    return 1;
                }else{
                    if(o1[1] < o2[1]){
                        return -1;
                    }else if(o1[1] > o2[1]){
                        return 1;
                    }else{
                        if(o1[2] < o2[2]){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                }
            }
        });

        return answer;
    }

    private static class Struct{
        int x, y, s;

        public Struct(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Struct struct = (Struct) o;
            return x == struct.x &&
                    y == struct.y &&
                    s == struct.s;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, s);
        }
    }
}
