package org.example.DPK16;

import lombok.Getter;
import lombok.Setter;

/*
1.The game should start with 10 mosquitos, 1 exterminator. ok
2.The game should have a internal matrix of 100x100. ok
3.Every 1s the mosquito should move to a random position.
4.Every 1s the exterminator should move to a specific position.
5.If the mosquito and the exterminator are in the same position, the mosquito should die. ok
6.If the mosquito moves 5 times without being killed, it should reproduce if there is a mosquito nearby.
7.The game should have a method that can return the number of mosquitos killed.
8.The game should have a method that can return the number of mosquitos alive.
9.The mosquito can walk in any direction (up, down, left, right, diagonals).
10.The exterminator can walk in one direction, it should swap the metrixs.
The exterminator can walk from the bottown left corner to the top right
corner them from the botton to the top them return on the same route.
* */
public class Game {

    @Setter
    @Getter
    private Mosquito[] mosquito = new Mosquito[10];
    @Setter
    @Getter
    private Exterminator exterminator;

    private int[][] matrix =  new int[100][100];

    @Setter
    @Getter
    private Mosquito[] mosquitos = new Mosquito[10];

    public Game(Exterminator exterminator) {
        this.exterminator = exterminator != null ? exterminator : new Exterminator();

        for (int i = 0; i < mosquitos.length; i++) {
            mosquitos[i] = new Mosquito();
        }

        initializeMosquitoPositions();
        initializeExterminatorPositions();
    }

    private void startGame(){
    }

    private void verifyIfMosquitoAndExterminatorAreOnSamePosition() {
    }

    private void initializeMosquitoPositions() {
    }

    private void initializeExterminatorPositions() {
    }


    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
