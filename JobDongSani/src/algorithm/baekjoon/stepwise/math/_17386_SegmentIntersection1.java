package algorithm.baekjoon.stepwise.math;

import java.util.Scanner;

public class _17386_SegmentIntersection1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Vector a = new Vector(scn.nextInt(), scn.nextInt());
        Vector b = new Vector(scn.nextInt(), scn.nextInt());
        scn.nextLine();
        Vector c = new Vector(scn.nextInt(), scn.nextInt());
        Vector d = new Vector(scn.nextInt(), scn.nextInt());

        if(segmentIntersection(a, b, c, d)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }

    private static boolean segmentIntersection(Vector a, Vector b, Vector c, Vector d){
        long ab = ccw(a, b, c) * ccw(a, b, d);
        long cd = ccw(c, d, a) * ccw(c, d, b);

        return ab <= 0 && cd <= 0;
    }

    private static long ccw(Vector a, Vector b, Vector c){
        long value = c.minus(b).cross(a.minus(b));
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
