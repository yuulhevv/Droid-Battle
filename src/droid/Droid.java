package droid;
import arena.Arena;

public abstract class Droid {
    private String name;
    private int health;
    private int damage;
    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void attack(Droid enemy) {
        enemy.setDamage(10);
        enemy.setHealth(enemy.getHealth()-enemy.getDamage());
    }
    public void takeDamage(int damage) {
        this.health -= damage;
    }
    public boolean isAlive() {
        return health > 0;
    }
}
