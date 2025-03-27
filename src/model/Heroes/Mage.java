package model.Heroes;

public class Mage extends GameCharacter {

    {
        typeCharacter = "Mage";
        typeWeapon = "Magic"; // for HomeWork
        magicSkill = 1.1;
    }

    public Mage() {
        super();
    }

//    public Mage(int level, int attackPower, int magicSkill) {
//        super(level, attackPower);
//        this.magicSkill = magicSkill;
//    }

    // for HomeWork
    @Override
    public void attack() {
        System.out.printf("%s attacks with a %s\n", typeCharacter, typeWeapon);
    }


}
