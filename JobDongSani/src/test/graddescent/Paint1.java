package test.graddescent;

import java.awt.Frame;
import java.awt.Graphics;

public class Paint1 extends Frame{

	public static void main(String[] args) {
		double J;
		double alpha = 0.001;
		
		while(alpha<=10) {
			double theta = 100;
			for(int i = 1; i<10 ; i++) {
				theta = theta - alpha * (2*theta);
				J = Math.pow(theta, 2);
				J = Double.parseDouble(String.format("%.2f", J));
				System.out.println("[alpha: " + alpha + "] step " + i + "'s J(theta) value: " + J);
				
			}
			alpha*=10;
			alpha = Double.parseDouble(String.format("%.2f", alpha));
			System.out.println("\n");
		}
		
	}
	
//		public Paint1(String title) {
//			super(title);
//		}
//		
//		public void paint(Graphics g) {
//			g.drawLine(-1, 6, -500, 500);
//			double alpha = 0.1;
//			
//			while(alpha<=0.1) {
//				double theta = 3;
//				int[] xp = new int[5];
//				int[] yp = new int[5];
//				for(int i = 1; i<6 ; i++) {
//					theta = theta - alpha * (2*theta);
//					theta = Double.parseDouble(String.format("%.2f", theta));
//					System.out.println("[alpha: " + alpha + "] step " + i + "'s theta value: " + theta);
//					int J = (int) (100*Math.pow(theta, 2));
//					xp[i-1] = i;
//					yp[i-1] = J;
////					int J = Integer.parseInt(Double.toString(Double.parseDouble(String.format("%.0f", 100*Math.pow(theta, 2)))));
//				}
//				g.drawPolyline(xp, yp, 5);
//				alpha+=0.1;
//				alpha = Double.parseDouble(String.format("%.2f", alpha));
//				System.out.println("\n");
//			}
//		}
//		
//		public static void main(String[] args) {
//			Paint1 f = new Paint1("paint");
//			f.setSize(500, 500);
//			f.setVisible(true);
//		}
		
	}


