package model.Heroes;

public class Archer extends GameCharacter {

    {
        typeCharacter = "Archer";
        typeWeapon = "Bow"; // for HomeWork
        bowSkill = 1.1;
    }

    public Archer() {
        super();
    }

//    public Archer(int level, int attackPower, int bowSkill) {
//        super(level, attackPower);
//        this.bowSkill = bowSkill;
//    }

    // for HomeWork
    @Override
    public void attack() {
        System.out.printf("%s attacks with a %s\n", typeCharacter, typeWeapon);
    }

}
