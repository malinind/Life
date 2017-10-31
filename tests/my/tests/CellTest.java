package my.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by dmitriy on 01.11.2017.
 */
class CellTest {
    final int x =10;
    final int y =15;
    final int newX =15;
    final int newY =20;
    @Test
    void getX() {

        Cell cell = new Cell(x,y);
        assertEquals(x,cell.getX());
        System.out.println(cell.getX());
    }

    @Test
    void setX() {
        Cell cell = new Cell(x,y);
        cell.setX(newX);
        assertEquals(newX,cell.getX());
        System.out.println(cell.getX());
    }

    @Test
    void getY() {
        Cell cell = new Cell(x,y);
        assertEquals(y,cell.getY());
        System.out.println(cell.getY());
    }

    @Test
    void setY() {
        Cell cell = new Cell(x,y);
        cell.setX(newX);
        assertEquals(newX,cell.getX());
        System.out.println(cell.getY());
    }

    @Test
    void isAlive() {
        Cell cell = new Cell(x,y,true);
        assertTrue(cell.isAlive());
        System.out.println(cell.getY());

    }

    @Test
    void getNumberValue() {

    }

    @Test
    void setAlive() {

    }

//    @Test
//    void toString() {
//
//    }

}