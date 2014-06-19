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
public class KeepTowardCentre extends Rule {

    private final double DISTANCE;

    public KeepTowardCentre(double distance) {
        DISTANCE = distance;
    }

    @Override
    public Vector change(Bird bird, Bird[] flock) {
        Vector p = bird.pos;

        int i = 1;

        for (Bird b : flock) {
            if (b != bird && Vector.mag(Vector.sub(b.pos, bird.pos)) < DISTANCE) {
                p = Vector.add(p, b.pos);
                i++;
            }
        }

        p = Vector.divScalar(p, i);

        return Vector.divScalar(Vector.sub(p, bird.pos), 100);
    }
}
