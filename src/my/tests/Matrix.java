package my.tests;

import sun.rmi.runtime.Log;

import java.util.Arrays;

/**
 * Created by dmitriy on 26.10.2017.
 */
public class Matrix {

    private int Xn;
    private int Yn;
    private Cell[][] matrix;

    public Matrix(int xn, int yn) {
        Xn = xn;
        Yn = yn;
        matrix=genarateMatrix(Xn,Yn);
    }

    public Matrix(int xn, int yn, Cell[][] matrix) {
        Xn = xn;
        Yn = yn;
        this.matrix = matrix;
    }

    public Matrix() {

        Xn = 3;
        Yn = 3;
        Cell[][] cells = new Cell[3][3];
        cells[0][0]= new Cell(0,0,false);
        cells[0][1]= new Cell(0,1,false);
        cells[0][2]= new Cell(0,2,false);
        cells[1][0]= new Cell(1,0,false);
        cells[1][1]= new Cell(1,1,false);
        cells[1][2]= new Cell(1,2,true);
        cells[2][0]= new Cell(2,0,true);
        cells[2][1]= new Cell(2,1,false);
        cells[2][2]= new Cell(2,2,true);

        this.matrix = cells;
    }

    private Cell[][] genarateMatrix(int xn, int yn) {
        Cell[][] matr = new Cell[xn][yn];

        for (int i=0;i<xn;i++){
            for(int j=0;j<yn;j++){
                matr[i][j]= new Cell(i,j);
            }
        }
        return matr;
    }

    public int getXn() {
        return Xn;
    }

    public void setXn(int xn) {
        Xn = xn;
    }

    public int getYn() {
        return Yn;
    }

    public void setYn(int yn) {
        Yn = yn;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isNoLife(){
        int summ=0;
        for (int i=0;i<Xn;i++) {
            for (int j = 0; j < Yn; j++) {
                summ += matrix[i][j].getNumberValue();
            }
        }
        return summ==0 ? true: false;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i=0;i<Xn;i++){
            for (int j=0;j<Yn;j++){
                if (j+1<Yn)
                    str = str.append(matrix[i][j].toString()+" ");
                else str = str.append(matrix[i][j].toString());
            }
            str.append("\n");
        }
        return "Matrix\n{\n" +
                str.toString()+
                '}';
    }

    public int size() {
        return matrix.length;
    }

    public Cell getCell (int x, int y){
        return matrix[x][y];
    }

    public int summOfNeigbours(int x, int y){
        int     neib1 = 0,
                neib2 = 0,
                neib3 = 0,
                neib4 = 0,
                neib5 = 0,
                neib6 = 0,
                neib7 = 0,
                neib8 = 0;
      //  System.out.println("x = " + x+ ", y = " + y);
        if (x==0 && y==0){
            neib5 = matrix[x][y+1].getNumberValue();
            neib7 = matrix[x+1][y].getNumberValue();
            neib8 = matrix[x+1][y+1].getNumberValue();
        }
        else if (x==0 && y==Yn-1){
            neib4 = matrix[x][y-1].getNumberValue();
            neib6 = matrix[x+1][y-1].getNumberValue();
            neib7 = matrix[x+1][y].getNumberValue();

        }
        else if (x==Xn-1 && y==0){
            neib2 = matrix[x-1][y].getNumberValue();
            neib3 = matrix[x-1][y+1].getNumberValue();
            neib5 = matrix[x][y+1].getNumberValue();

        }
        else if (x==Xn-1 && y==Yn-1){
            neib1 = matrix[x-1][y-1].getNumberValue();
            neib2 = matrix[x-1][y].getNumberValue();
            neib4 = matrix[x][y-1].getNumberValue();
        }
        else if (x==0){
            neib4 = matrix[x][y-1].getNumberValue();
            neib5 = matrix[x][y+1].getNumberValue();
            neib6 = matrix[x+1][y-1].getNumberValue();
            neib7 = matrix[x+1][y].getNumberValue();
            neib8 = matrix[x+1][y+1].getNumberValue();
        }
        else if (y==0){

            neib2 = matrix[x-1][y].getNumberValue();
            neib3 = matrix[x-1][y+1].getNumberValue();
            neib5 = matrix[x][y+1].getNumberValue();
            neib7 = matrix[x+1][y].getNumberValue();
            neib8 = matrix[x+1][y+1].getNumberValue();
        }

        else if (x==Xn-1){
            neib1 = matrix[x-1][y-1].getNumberValue();
            neib2 = matrix[x-1][y].getNumberValue();
            neib3 = matrix[x-1][y+1].getNumberValue();
            neib4 = matrix[x][y-1].getNumberValue();
            neib5 = matrix[x][y+1].getNumberValue();
        }
        else if (y==Yn-1){
            neib1 = matrix[x-1][y-1].getNumberValue();
            neib2 = matrix[x-1][y].getNumberValue();
            neib4 = matrix[x][y-1].getNumberValue();
            neib6 = matrix[x+1][y-1].getNumberValue();
            neib7 = matrix[x+1][y].getNumberValue();
        }
    return neib1+neib2+neib3+neib4+neib5+neib6+neib7+neib8;
    }


    public int summOfNeigboursNew(int x, int y){
        int summ=0;
        int xx,yy;
        for (int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i==x && j==y) {
                    summ=summ+0;
                }
                else{
                    xx=Math.abs((Xn+i)%Xn);
                    yy=Math.abs((Yn+j)%Yn);
                    if (matrix[xx][yy].isAlive()) {
                        summ++;
                    }
                }
            }
        }
        return summ;
    }
    public boolean nextGeneration (int x, int y){
       // System.out.println("Call NextGen for ("+x+","+y+")");
        boolean currentStatus = matrix[x][y].isAlive();

        int summ = summOfNeigboursNew(x, y);
        if (currentStatus && summ>=2 && summ<=3)    return true;
        if (currentStatus && (summ<2 || summ>3))    return false;
        if (!currentStatus && summ==3)              return true;
        else return false;
    }
}
