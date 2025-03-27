package model.Enemies;

public class OrcPhysDef extends Enemies {

    {
        typeEnemy = "Orc_Phys";
        resistancePhys = 2 * level;
        health = 50 * level;
        maxHealth = health;
        defense = 3 + (2 * level);
        exp = 25 * level;
    }

    public OrcPhysDef(int level) {
        super(level);
    }

}
