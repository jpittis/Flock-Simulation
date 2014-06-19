/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.data;

/**
 *
 * @author Jake
 */
public class Bird {

    public Vector pos;
    public Vector vel;

    public Bird(Vector pos, Vector vel) {
        this.pos = pos;
        this.vel = vel;
    }

    public void move() {
        pos = Vector.add(pos, vel);
    }

    public static Vector randomPos(int maxX, int minX, int maxY, int minY) {
        double x = (Math.random() * (maxX - minX)) + minX;
        double y = (Math.random() * (maxY - minY)) + minY;
        return new Vector(x, y);
    }

    public static Vector randomVel(double maxSpeed) {
        double minSpeed = maxSpeed * -1;
        double x = (Math.random() * (maxSpeed - minSpeed)) + minSpeed;
        double y = (Math.random() * (maxSpeed - minSpeed)) + minSpeed;

        Vector v = new Vector(x, y);

        if (Vector.mag(v) > maxSpeed) {
            v = Vector.multScalar(Vector.divScalar(v, Vector.mag(v)), maxSpeed);
        }

        return v;
    }
}
