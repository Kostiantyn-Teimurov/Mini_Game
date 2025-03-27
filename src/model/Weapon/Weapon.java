package model.Weapon;

import java.util.Random;

public abstract class Weapon {

    protected int dmgMin;
    protected int dmgMax;
    protected String typeWeapon;

    public Weapon() {
    }


    public int getDmg() {
        Random random = new Random();
        return random.nextInt(dmgMax - dmgMin + 1) + dmgMin;
    }

    public String getTypeWeapon() {
        return typeWeapon;
    }
}
