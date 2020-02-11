package algorithm.baekjoon.stepwise.math;

import java.util.Scanner;

public class _11758_CCW {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int[] p3 = new int[2];
        p1[0] = scn.nextInt(); p1[1] = scn.nextInt(); scn.nextLine();
        p2[0] = scn.nextInt(); p2[1] = scn.nextInt(); scn.nextLine();
        p3[0] = scn.nextInt(); p3[1] = scn.nextInt();

        Vector p1V = new Vector(p1[0], p1[1]);
        Vector p2V = new Vector(p2[0], p2[1]);
        Vector p3V = new Vector(p3[0], p3[1]);

        int ccwValue = ccw(p1V, p2V, p3V);
        if(ccwValue > 0){
            System.out.println("1");
        }else if(ccwValue < 0){
            System.out.println("-1");
        }else{
            System.out.println("0");
        }
    }

    private static int ccw(Vector a, Vector b){
        return a.cross(b);
    }

    private static int ccw(Vector a, Vector b, Vector c){
        return c.minus(b).cross(a.minus(b));
    }

    private static class Vector{
        int x, y;

        Vector(int x, int y){
            this.x = x;
            this.y = y;
        }

        Vector plus(Vector rhs){
            return new Vector(x + rhs.x, y + rhs.y);
        }

        Vector minus(Vector rhs){
            return new Vector(x - rhs.x, y - rhs.y);
        }

        int cross(Vector rhs){
            return x * rhs.y - rhs.x * y;
        }
    }
}
