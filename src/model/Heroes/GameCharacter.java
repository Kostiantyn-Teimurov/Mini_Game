package model.Heroes;


import model.Enemies.Enemies;
import model.Weapon.Fists;
import model.Weapon.Weapon;

public abstract class GameCharacter {

    protected int level;
    protected int experience;
    protected int attackPower;
    protected double oneHandSkill = 0.1;
    protected double magicSkill = 0.1;
    protected double bowSkill = 0.1;
    protected double fistsSkill = 1.0;

    protected String typeCharacter;
    protected String typeWeapon;  // for HomeWork

    protected Weapon weapon;

    public GameCharacter() {
        this.level = 1;
        this.attackPower = 10;
        weapon = new Fists();
    }

    // for HomeWork
    public GameCharacter(int level, int attackPower) {
        this.level = level;
        this.attackPower = attackPower;
    }

    abstract void attack();


    // !!!!!!!!!!!!!!!!!!!!!!!!  My Project    !!!!!!!!!!!!!!!!

    // Experience logic

    private int nextLevelXP() {
        return (int) (100 * level * (1 + (level / 10.0)));
    }

    private void addXP(int xp) {
        System.out.printf("+%d exp!\n", xp);
        this.experience += xp;
        while (experience >= nextLevelXP()) {
            levelUp();
        }
        System.out.printf("Level: %d. Experience: %d/%d.\n", level, experience, nextLevelXP());
    }

    private void levelUp() {
        experience -= nextLevelXP();
        level++;
        attackPower += 5;
        System.out.printf("%s Level UP! Level: %d.\n", typeCharacter, level);

    }

    public void completeTask() {
        System.out.print("Task completed! ");
        addXP(50);
    }

    public void completeMegaTask() {
        System.out.print("MEGA Task completed! ");
        addXP(1000);
    }


    // Fight Logic

    public void changeWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.printf("%s changed weapon to: %s\n", typeCharacter, weapon.getTypeWeapon());
    }

    private double getSkill() {
        double bestSkill = fistsSkill;
        if (weapon.getTypeWeapon().equals("Knife") || weapon.getTypeWeapon().equals("Sword")) {
            bestSkill = oneHandSkill;
        }
        if (weapon.getTypeWeapon().equals("Staff")) {
            bestSkill = magicSkill;
        }
        if (weapon.getTypeWeapon().equals("HuntingBow")) {
            bestSkill = bowSkill;
        }
        return bestSkill;
    }

    private double countDamage() {
        return (0.5 * level) + (0.5 * attackPower) + (weapon.getDmg() * getSkill());
    }


    public void attack(Enemies enemy) {
        if (!enemy.isAlive()) {
            System.out.println("Enemy is already died!");
            return;
        }
        if (weapon == null) {
            System.out.println("Take a weapon!");
            return;
        }

        int netDamage = (int) (countDamage() - enemy.getDefense());
        double resistance;
        if (netDamage < 0) {
            netDamage = 0;
        }
        if (getSkill() == oneHandSkill || getSkill() == bowSkill) {
            resistance = enemy.getResistancePhys();
        } else {
            resistance = enemy.getResistanceMage();
        }
        netDamage = (int) (netDamage * (1 - (resistance * 0.01)));

        enemy.takeDamage(netDamage);

        System.out.println("-------------------------------------------");
        System.out.printf("%s attacks %s with %s!\nDMG: %d\n", typeCharacter, enemy.getTypeEnemy(), weapon.getTypeWeapon(), netDamage);
        if (enemy.isAlive()) {
            System.out.printf("%s: %d/%d HP\n", enemy.getTypeEnemy(), enemy.getHealth(), enemy.getMaxHealth());
//            addXP((int) (0.2 * netDamage));
        } else {
            System.out.printf("You killed the %s!\n", enemy.getTypeEnemy());
            addXP(enemy.getExp());
        }
        System.out.println("-------------------------------------------");
    }


    public void getInfoHero() {
        System.out.println("============================================");
        System.out.printf("%s: %s.   Level: %d.   EXP: %d/%d.\nAttackPower: %d; SwordSkill: %.1f; MagicSkill: %.1f; BowSkill: %.1f.\nWeapon: %s\n",
                typeCharacter, weapon.getTypeWeapon(), level, experience, nextLevelXP(), attackPower, oneHandSkill, magicSkill, bowSkill,
                weapon != null ? weapon.getTypeWeapon() : "No Weapon.");
        System.out.println("============================================");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getLevel() {
        return level;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getTypeCharacter() {
        return typeCharacter;
    }

    public String getTypeWeapon() {
        return typeWeapon;
    }
}