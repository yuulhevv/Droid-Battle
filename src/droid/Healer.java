package droid;

import arena.Arena;

public class Healer extends Droid implements Combatant{
    private int healingPower;
    public Healer(String name, int health, int damage, int healingPower) {
        super(name, health, damage);
        this.healingPower = healingPower;
    }
    public void heal(Droid target) {
        int amountHealed = getHealingPower(); // Кількість здоров'я, яку можна відновити
        target.setHealth(target.getHealth() + amountHealed); // Відновлення здоров'я цільового об'єкта
        System.out.println(getName() + " відновлює " + amountHealed + " здоров'я " + target.getName() + ".");
        Arena.LOGGER.info(getName() + " відновлює " + amountHealed + " здоров'я " + target.getName() + ".");
    }
    public int getHealingPower() {
        return healingPower;
    }

    @Override
    public String toString() {
        return "Healer{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", damage=" + getDamage() +
                ", healingPower=" + healingPower +
                '}';
    }
    @Override
    public void performAction(Combatant target) {
        heal((Droid) target);
    }
}