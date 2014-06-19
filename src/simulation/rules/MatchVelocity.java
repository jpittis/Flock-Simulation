/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.rules;

import simulation.Rule;
import simulation.data.Bird;
import simulation.data.Vector;

/**
 *
 * @author Jake
 */
public class MatchVelocity extends Rule {

    private final double DISTANCE;

    public MatchVelocity(double distance) {
        DISTANCE = distance;
    }

    @Override
    public Vector change(Bird bird, Bird[] flock) {
        Vector v = bird.vel;

        int i = 1;

        for (Bird b : flock) {
            if (b != bird && Vector.mag(Vector.sub(b.pos, bird.pos)) < DISTANCE) {
                v = Vector.add(v, b.vel);
                i++;
            }
        }

        v = Vector.divScalar(v, i);

        return Vector.divScalar(Vector.sub(v, bird.vel), 8);
    }
}
