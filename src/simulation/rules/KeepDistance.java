/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.rules;

import simulation.Flock;
import simulation.Rule;
import simulation.data.Bird;
import simulation.data.Vector;

/**
 *
 * @author Jake
 */
public class KeepDistance extends Rule {

    private final double DISTANCE;
    private final Flock FLOCK;
    
    public KeepDistance(double distance, Flock flock) {
        DISTANCE = distance;
        FLOCK = flock;
    }

    @Override
    public Vector change(Bird bird, Bird[] flock) {
        Vector c = new Vector(0, 0);

        for (Bird b : FLOCK.get()) {
            if (b != bird) {
                if (Vector.mag(Vector.sub(b.pos, bird.pos)) < DISTANCE) {
                    c = Vector.sub(c, Vector.sub(b.pos, bird.pos));
                }
            }
        }

        return Vector.divScalar(c, 8);
    }
}
