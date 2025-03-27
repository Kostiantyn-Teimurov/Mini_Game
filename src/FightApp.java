import model.Enemies.OrcMagicDef;
import model.Enemies.OrcPhysDef;
import model.Heroes.Archer;
import model.Heroes.Mage;
import model.Heroes.Warrior;
import model.Weapon.HuntingBow;
import model.Weapon.Knife;
import model.Weapon.Staff;
import model.Weapon.Sword;

public class FightApp {
    public static void main(String[] args) {

        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Archer archer = new Archer();

        OrcPhysDef orcWarrior = new OrcPhysDef(1);
        OrcMagicDef orcMage = new OrcMagicDef(-1);

        warrior.getInfoHero();

        warrior.attack(orcWarrior);
        warrior.attack(orcMage);


//        warrior.completeTask();
//        warrior.completeMegaTask();
//        warrior.getInfoHero();

        mage.getInfoHero();

        System.out.println("\n==================  Tasks / EXP =========================");
        mage.completeMegaTask();
        mage.completeMegaTask();
        mage.completeTask();


        System.out.println("+++++++++++++++++Enemies+++++++++++++++++++");

        orcWarrior.getInfoEnemy();
        orcMage.getInfoEnemy();


        System.out.println("+++++++++++++++++++Weapons+++++++++++++++++");
        Sword weapon = new Sword();
        System.out.println(weapon.getDmg());

        Knife knife = new Knife();
        System.out.println(knife.getDmg());

        Staff staff = new Staff();
        System.out.println(staff.getDmg());

        HuntingBow huntingBow = new HuntingBow();
        System.out.println(huntingBow.getDmg());

        System.out.println(warrior.getWeapon());
        warrior.changeWeapon(knife);
        System.out.println(warrior.getWeapon());

        warrior.getInfoHero();


        System.out.println("\n================Fight!=======================");

        warrior.attack(orcWarrior);
        warrior.attack(orcMage);

        warrior.changeWeapon(staff);
        warrior.attack(orcMage);
        warrior.attack(orcWarrior);
        warrior.attack(orcWarrior);

        warrior.changeWeapon(huntingBow);
        warrior.attack(orcWarrior);
        warrior.attack(orcMage);

        mage.attack(orcMage);
        mage.attack(orcWarrior);
        mage.getInfoHero();
        mage.changeWeapon(staff);
        mage.attack(orcWarrior);

        OrcMagicDef orcMagicDef = new OrcMagicDef(2);
        OrcMagicDef orcMagicDef1 = new OrcMagicDef(5);
        OrcMagicDef orcMagicDef2 = new OrcMagicDef(10);
        orcMagicDef.getInfoEnemy();

        mage.attack(orcMagicDef);
        mage.attack(orcMagicDef1);
        mage.attack(orcMagicDef2);

        archer.attack(orcMagicDef);
        archer.changeWeapon(huntingBow);
        archer.attack(orcMagicDef1);
        archer.attack(orcMagicDef2);


    }


}
