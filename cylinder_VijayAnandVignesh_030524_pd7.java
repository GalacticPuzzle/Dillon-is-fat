package cylinder;

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;


public class cylinder_VijayAnandVignesh_030524_pd7 {
	private static double[][] matrix;
	private static double totalCost;
	private static double density;
	private static double resinPrice;
	private static Random rand;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		density = 0.0;
		resinPrice = 0.0;
		rand = new Random();
		matrix = new double[10][num];
		getRadii(num);
		getHeight();
		getThickness();
		getPrice();
		calculateVolume();
		getDensity();
		calculateMass();
		calculateCosts();
		calculatetotal();
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
		System.out.println(Arrays.toString(matrix[3]));
		System.out.println(Arrays.toString(matrix[4]));
		System.out.println(Arrays.toString(matrix[5]));
		System.out.println();
		System.out.println(totalCost);



	}//main end
	//#1 method
	public static void getRadii(int n) {
		for (int i = 0; i < n; i++) {
            double rad = Math.random();
            rad = 4.0 + (rad * 2.0);
            rad = Math.round(rad * 10.0) / 10.0;
            matrix[0][i] = rad;
		}
	}//end of radii
	public static void getHeight() {
		int n = matrix[0].length;
		for (int i = 0; i < n; i++) {
	            double Height = 8.0 + (Math.random() * 10.1);
	            Height = Math.round(Height * 10.0) / 10.0;
	            matrix[1][i] = Height;
	        }

	}// end of height
	public static void getPrice() {
		int n = matrix[0].length;
		int minValue = 12;
        int incr = 4;
        for (int i = 0; i < n; i++) {
            // Calculate the random resin cost
            int randIndex = rand.nextInt((60 - minValue) / incr + 1);
            double ResinCost = minValue + randIndex * incr;
            resinPrice = ResinCost;
        }
	}//end of getPrice
	
	public static void getThickness() {
		double [] thickness = {0.4,0.5,0.6};
        for(int i = 0; i < matrix[0].length; i++) {
     	   matrix[2][i] = thickness[rand.nextInt(3)];
	        }
	}//end of thickness
	
	public static void calculateVolume() {
		int index = 0;
		for(double radius : matrix[0]) {
			matrix[3][index] = radius*radius*Math.PI*matrix[1][index];
			index++;	
		}
	}// end of calculateVolume
		
	public static void getDensity() {
		double [] Density = {1.1,1.11,1.12,1.13,1.14,1.15,1.16,1.17,1.18,1.19,1.2};
        for(int i = 0; i < matrix[0].length; i++) {
     	   density = Density[rand.nextInt(11)];
        }
	}//end of density
	
	public static void calculateMass() {
		for(int i = 0; i < matrix.length;i++ ) {
			matrix[4][i] = density * matrix[3][i];
		}
	}//end of mass
	
	public static void calculateCosts() {
		for (int i = 0; i < matrix[0].length; i++) {
            double mass = matrix[4][i];
            matrix[5][i] = resinPrice * (mass / 1000);
        }
    }// end of calculateCosts
	
	public static void calculatetotal() {
        for (int i = 0; i < matrix[0].length; i++) {
            totalCost += matrix[5][i];
        }
    }//end of calculatetotal
	
	
	
	
}//class end
