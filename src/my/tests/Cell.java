package my.tests;

import java.util.Random;

/**
 * Created by dmitriy on 26.10.2017.
 */
public class Cell {

    private int x;
    private int y;
    private boolean alive;

    public Cell(int x, int y) {
        Random rand = new Random();
        this.x = x;
        this.y = y;
        this.alive = rand.nextBoolean();

    }

    public Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getNumberValue() {
        return alive ? 1:0;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return alive ? "0":" ";
    }
}
