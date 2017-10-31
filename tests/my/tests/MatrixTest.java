package my.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dmitriy on 01.11.2017.
 */
class MatrixTest {
    final int Xn=3;
    final int Yn=3;
    @Test
    void summOfNeigboursNew() {
        Cell[][] cells = new Cell[Xn][Yn];

        for (int i = 0; i < Xn; i++) {
            for (int j = 0; j < Yn; j++) {
                cells[i][j] = new Cell(i, j);
                Matrix matrix = new Matrix(Xn, Yn, cells);

            }
        }
    }

    @Test
    void nextGeneration() {

    }

}