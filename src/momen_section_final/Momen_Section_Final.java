//     Momen Bassam Sarsour 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package momen_section_final;

import java.util.Scanner;

/**
 *
 * @author PTC
 */
public class Momen_Section_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of elements so that the number is divisible by 4 : ");
        int NumberOfElements = input.nextInt();
        if(NumberOfElements%4==0){
            
        int numberOfPoint = NumberOfElements/2;
        System.out.println("The point is : " + numberOfPoint );
        
        double[][] points = new double[numberOfPoint][2];
        System.out.println("         ##   Enter " + numberOfPoint + " points   ## ");
        for(int i = 0 ; i < points.length ; i++){
            System.out.print("Enter the point " + (i+1) + " on x-axis : ");
            points[i][0] = input.nextDouble();
            System.out.print("Enter the point " + (i+1) + " on y-axis : ");
            points[i][1] = input.nextDouble();
        }
        
        int choice = 0;
        while(choice!=6){
            System.out.println();
            choice=displayMenu(input);
            if(choice > 6){
                System.out.println("Error of Enter, please try again !!");
            }
            
            switch(choice){
                case 1:
                    disPlayPoint(points,numberOfPoint);
                    break;
                   
                case 2:
                    shufflePoints(points);
                    break;
                    
                case 3:
                    lineEquation(points,numberOfPoint);
                    break;
                    
                case 4:
                    double[] point = getRightMostLowestPoint(points);
                    System.out.println("The rightmost lowest point is (" + point[0] + ", " + point[1] + ")");
                    break;
                    
                case 5:
                    slopeOfLine(points);
                    break;
                    
                case 6:
                    System.out.println("Thank you!");
                    break;        
            }
        }
        }
        else
            System.out.println("Error of Enter, please try again !!");
    }
    
    private static int displayMenu(Scanner input) {
        System.out.println("Menu\n" 
                    + "1. Display points\n" 
                    + "2. Shuffle points\n" 
                    + "3. Display line equation\n" 
                    + "4. Display right most lowest point\n" 
                    + "5. Display slope of lines\n" 
                    + "6. Quit");
            System.out.print("Enter your choice: ");
            int choice=input.nextInt();
            System.out.println("    ");
            input.nextLine();
            return choice;
    }
    
    private static double[][] disPlayPoint(double[][] points,int numberOfPoint) {
        for(int i = 0 ; i < points.length ; i++){
            System.out.print("The point " + (i+1) + " : ( ");
            for(int j = 0 ; j < points[i].length ; j++){
                System.out.print(points[i][j] + " ");
            }
            System.out.println(" )");
        }
        return points;
    }

    private static double[][] shufflePoints(double[][] Point) {
        for (int i = 0; i < Point.length; i++) {
            for (int j = 0; j < Point[i].length; j++) {
                int i1 = (int)(Math.random() * Point.length);
                int j1 = (int)(Math.random() * Point[i].length);
                double temp = Point[i][j];
                Point[i][j] = Point[i1][j1];
                Point[i1][j1] = temp;
            }
        }
        for(int i = 0 ; i < Point.length ; i++){
            System.out.print("The point " + (i+1) + " : ( ");
            for(int j = 0 ; j < Point[i].length ; j++){
                System.out.print(Point[i][j] + " ");
            }
            System.out.println(" )");
        }
        
        return Point;
    }
    
    private static String[] lineEquation(double[][] Points , int numberOfPoint) {
        
        String[] lineEqua = new String[numberOfPoint/2];
        for(int i = 0 ; i < Points.length ; i = i + 2){
                double x1 = Points[i][0];
                double y1 = Points[i][1];
                int n = i+1;
                double x2 = Points[n][0];
                double y2 = Points[n][1];
                System.out.println("The line " + (i+1) +" : ( " + x1+ ", " + y1+ " ) ( " + x2+ " , " + y2 + " )");
                double b = ((y2-y1)/(x2-x1))*x1 + y1;
                double slope = (y2-y1)/(x2-x1);
                
                System.out.println("The b = " + b + "   , The slope = " + slope);
                lineEqua[i/2] = slope+"x +"+ b;
        }
        for(int i = 0 ; i < lineEqua.length ; i++){
            System.out.println("The line " + (i+1) + " Equation = " + lineEqua[i]);
        }

        return lineEqua;
    }

    public static double[] getRightMostLowestPoint(double[][] points) {

        double[] rightMost;
        rightMost = points[0];

        for (int i = 1; i < points.length; i++) {

            if (points[i][1] < rightMost[1]) {

                rightMost = points[i];
            } else if (points[i][1] == rightMost[1] && points[i][0] > rightMost[0]) {

                rightMost = points[i];
            }
        }
        return new double[] {rightMost[0], rightMost[1]};

    }
    
    private static double slopeOfLine(double[][] Points ) {
        double slope=0;
        for(int i = 0 ; i < Points.length ; i = i + 2){
                double x1 = Points[i][0];
                double y1 = Points[i][1];
                int n = i+1;
                double x2 = Points[n][0];
                double y2 = Points[n][1];
                
                System.out.println("The line : ( " + x1+ " , " + y1+ " ) ( " + x2+ " , " + y2 + " )");
                double b = ((y2-y1)/(x2-x1))*x1 + y1;
                slope = (y2-y1)/(x2-x1);
                System.out.println("The Slope = " + slope);
        }
        return slope;
    }

    
    
}
