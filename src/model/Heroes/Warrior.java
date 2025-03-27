package model.Heroes;

public class Warrior extends GameCharacter {

    {
        typeCharacter = "Warrior";
        typeWeapon = "Sword"; // for HomeWork
        oneHandSkill = 1.1;
    }

    public Warrior() {
        super();
    }

//    public Warrior(int level, int attackPower, int swordSkill) {
//        super(level, attackPower);
//        this.swordSkill = swordSkill;
//    }

    // For Homework
    @Override
    public void attack() {
        System.out.printf("%s attacks with a %s\n", typeCharacter, typeWeapon);
    }


}
