package my.tests;

import java.util.Random;

public class Main {
    final static int Xx = 40;
    final static int Yy = 80;

    private static int[][] generateMatrix(int x, int y){
        int [][] matrix = new int[x][y];
        Random rand = new Random();
         for (int i=0;i<x;i++)
            for(int j=0;j<y;j++){
               // matrix[i][j]=((int)Math.random()*10)%2;
                matrix[i][j]= rand.nextInt(2);
            }

        return matrix;
    }
    private static void printMatrix(int [][] matrix){
        for(int i=0;i<Xx;i++) {
            for (int j = 0; j < Yy; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) throws InterruptedException {
	// write your code here
//        int [][] matrix=generateMatrix(Xx,Yy);
//        printMatrix(matrix);
        Matrix mat;


        if(args.length>=2){
            mat = new Matrix(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        }
        else {
        mat = new Matrix();}

        System.out.println(mat);

        for (;;) {
            mat = Generation.nextGeneration(mat);
            System.out.println(mat);

            if(mat.isNoLife()) { break; }

            if(args.length>=3){
                Thread.sleep(Long.parseLong(args[2]));
            }
            else {
            Thread.sleep(100);
            }
        }

    }
}
