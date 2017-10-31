package my.tests;

/**
 * Created by dmitriy on 27.10.2017.
 */
public class Generation {

    public static Matrix nextGeneration (Matrix matrix){

        Cell[][] cells = new Cell[matrix.getXn()][matrix.getYn()];

        for(int i=0;i<matrix.getXn();i++){
            for(int j=0;j<matrix.getYn();j++){
                cells[i][j]= new Cell(i,j,matrix.nextGeneration(i,j));
            }
        }
        return new Matrix(matrix.getXn(),matrix.getYn(),cells);
    }
}
