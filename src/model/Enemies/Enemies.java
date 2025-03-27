package model.Enemies;

public abstract class Enemies {
    protected int health;
    protected int defense;
    protected int maxHealth;
    protected int exp;
    protected int level;

    protected int resistancePhys;
    protected int resistanceMage;

    protected String typeEnemy;

    public Enemies(int level) {
        if (level <= 0) {
            this.level = 1;
        } else {
            this.level = level;
        }
    }

//    public Enemies(int health, int defense) {
//        this.health = health;
//        this.defense = defense;
//        this.maxHealth = health;
//    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (health <= 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void getInfoEnemy() {
        System.out.printf("%s. Level: %d. HP: %d/%d. Defence: %d. PhysResistance: %d; MageResistance: %d\n",
                typeEnemy, level, health, maxHealth, defense, resistancePhys, resistanceMage);
    }

    public String getTypeEnemy() {
        return typeEnemy;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getResistancePhys() {
        return resistancePhys;
    }

    public int getResistanceMage() {
        return resistanceMage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExp() {
        return exp;
    }
}
