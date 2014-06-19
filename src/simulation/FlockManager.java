/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.ArrayList;

/**
 *
 * @author Jake
 */
public class FlockManager {

    private final ArrayList<Flock> flocks;

    public FlockManager() {
        flocks = new ArrayList<>();
    }

    public void update() {
        for (Flock flock : flocks) {
            flock.update();
        }
    }

    public void add(Flock flock) {
        flocks.add(flock);
    }

    public Flock[] flock() {
        return flocks.toArray(new Flock[flocks.size()]);
    }
}
