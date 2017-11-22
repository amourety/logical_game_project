package entities;

import java.util.Random;

public class Randomizer {
    public Unit random(Unit[] units){
        Random random = new Random();
        int num = random.nextInt(24);
        return units[num];
    }
}
