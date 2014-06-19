/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import simulation.data.Bird;
import simulation.data.Vector;

/**
 *
 * @author Jake
 */
public abstract class Rule {

    double weight;

    public Rule() {
        weight = 1;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Vector getChange(Bird bird, Bird[] flock) {
        return Vector.multScalar(change(bird, flock), weight);
    }

    public abstract Vector change(Bird bird, Bird[] flock);
}
