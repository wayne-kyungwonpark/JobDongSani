package algorithm.baekjoon.stepwise.implement;

import java.util.Scanner;

public class TaxiGeometry {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = Integer.parseInt(scn.nextLine());
		double areaE = (double)r * (double)r * Math.PI;
		double areaM = (double)r * (double)r * 2;
		System.out.format("%.6f\n", areaE);
		System.out.format("%.6f", areaM);
	}
}
