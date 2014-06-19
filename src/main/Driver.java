/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import simulation.Flock;
import simulation.FlockManager;
import simulation.rules.KeepDistance;
import simulation.rules.KeepInBounds;
import simulation.rules.KeepTowardCentre;
import simulation.rules.MatchVelocity;
import visual.Screen;

/**
 *
 * @author Jake
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {
        FlockManager flockManager = new FlockManager();
        Screen screen = new Screen(1000, 1000, flockManager);

        Flock f1 = new Flock(20, 10, 500, -500, 500, -500);
        Flock f2 = new Flock(100, 10, 500, -500, 500, -500);
        
        f1.addRule(new KeepInBounds(500, -500, 500, -500, 10));
        f1.addRule(new KeepDistance(40, f1));
        f1.addRule(new KeepDistance(40, f2));
        f1.addRule(new KeepTowardCentre(80));
        f1.addRule(new MatchVelocity(60));
        flockManager.add(f1);

        f2.addRule(new KeepInBounds(400, -400, 400, -400, 10));
        f2.addRule(new KeepDistance(20, f2));
        KeepDistance rule = new KeepDistance(60, f1);
        rule.setWeight(-1);
        f2.addRule(rule);
        f2.addRule(new KeepTowardCentre(200));
        f2.addRule(new MatchVelocity(200));
        flockManager.add(f2);

        while (true) {
            flockManager.update();
            screen.repaint();
            Thread.sleep(25);
        }
    }
}
