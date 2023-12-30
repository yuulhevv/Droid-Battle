package droid;

public interface Combatant {
    String getName();
    int getHealth();
    void performAction(Combatant target);
    boolean isAlive();
}
