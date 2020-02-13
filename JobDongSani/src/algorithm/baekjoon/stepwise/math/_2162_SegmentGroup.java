package algorithm.baekjoon.stepwise.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _2162_SegmentGroup {
    private static Vector[][] segments = null;
    private static List<HashSet<Integer>> segmentGroups = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        segments = new Vector[N][2];
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            segments[i][0] = new Vector(Long.parseLong(strArr[0]), Long.parseLong(strArr[1]));
            segments[i][1] = new Vector(Long.parseLong(strArr[2]), Long.parseLong(strArr[3]));
        }

        segmentGroups = new LinkedList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(segmentIntersection(segments[i][0], segments[i][1], segments[j][0], segments[j][1])){
                    findAndMakeGroup(i, j);
                }
            }
        }

        System.out.println(segmentGroups.size());
        int maxSizeOfGroup = 0;
        for (int i = 0; i < segmentGroups.size(); i++) {
            if(maxSizeOfGroup < segmentGroups.get(i).size()){
                maxSizeOfGroup = segmentGroups.get(i).size();
            }
        }
        System.out.println(maxSizeOfGroup);

        br.close();
    }

    private static void findAndMakeGroup(int i, int j) {
        if(segmentGroups.isEmpty()){
            HashSet<Integer> group = new HashSet<>();
            group.add(i);
            group.add(j);
            segmentGroups.add(group);
            return;
        }
        boolean find = false;
        int prevGroupIndex = -1;
        for (int k = 0; k < segmentGroups.size(); k++) {
            if(segmentGroups.get(k).contains(i) || segmentGroups.get(k).contains(j)){
                segmentGroups.get(k).add(i);
                segmentGroups.get(k).add(i);
                // i: 5, j: 13일 때, 그룹이 {1, 2, 3, 4, 5}, {6, 7, 8, 9, 13}, {10, 11, 12}, ... 일 경우 앞 두 그룹을 합쳐야 한다.
                if(find){
                    HashSet<Integer> prevGroup = segmentGroups.get(prevGroupIndex);
                    for (int l = 0; l < segmentGroups.get(k).size(); l++) {
//                        prevGroup.add(segmentGroups.get(k).)
                    }
                    break;
                }else{
                    prevGroupIndex = k;
                }
                find = true;
            }
        }
        if(!find){
            HashSet<Integer> group = new HashSet<>();
            group.add(i);
            group.add(j);
            segmentGroups.add(group);
        }
    }

    private static void swap(Vector a, Vector b){
        Vector tmp = new Vector(a.x, a.y);
        a.x = b.x;
        a.y = b.y;
        b.x = tmp.x;
        b.y = tmp.y;
    }

    private static boolean segmentIntersection(Vector a, Vector b, Vector c, Vector d){
        long ab = ccw(a, b, c) * ccw(a, b, d);
        long cd = ccw(c, d, a) * ccw(c, d, b);
        if(ab == 0 && cd == 0){
            if(b.lessThan(a)){
                swap(a, b);
            }
            if(d.lessThan(c)){
                swap(c, d);
            }
            return !(b.lessThan(c) || d.lessThan(a));
        }

        return ab <= 0 && cd <= 0;
    }

    private static long ccw(Vector a, Vector b, Vector c){
        long value = b.minus(a).cross(c.minus(a));
        if(value > 0){
            return 1;
        }else if(value == 0){
            return 0;
        }else{
            return -1;
        }
    }

    private static class Vector{
        long x, y;

        Vector(long x, long y){
            this.x = x;
            this.y = y;
        }

        boolean lessThan(Vector rhs){
            return (x != rhs.x)? x < rhs.x : y < rhs.y;
        }

        Vector plus(Vector rhs){
            return new Vector(x + rhs.x, y + rhs.y);
        }

        Vector minus(Vector rhs){
            return new Vector(x - rhs.x, y - rhs.y);
        }

        long dot(Vector rhs) { return x * rhs.x + y * rhs.y; }

        long cross(Vector rhs){
            return x * rhs.y - rhs.x * y;
        }
    }
}
