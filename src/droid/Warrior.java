package droid;
import arena.Arena;

public class Warrior extends Droid implements Combatant{
    private int strength;
    public Warrior(String name, int health, int damage, int strength) {
        super(name, health, damage);
        this.strength = strength;
    }
    public void attack(Droid target) {
        int damageDealt = getDamage() + getStrength(); // Сумарний урон включає базовий урон та силу воїна
        target.takeDamage(damageDealt); // Виклик методу для завдання урону цілі
        System.out.println(getName() + " атакує " + target.getName() + " та завдає " + damageDealt + " урону.");
        Arena.LOGGER.info(getName() + " атакує " + target.getName() + " та завдає " + damageDealt + " урону.");

    }
    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", damage=" + getDamage() +
                ", strength=" + strength +
                '}';
    }
    @Override
    public void performAction(Combatant target) {
        attack((Droid) target);
    }
}
