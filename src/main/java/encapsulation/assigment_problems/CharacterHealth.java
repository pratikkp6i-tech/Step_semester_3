package encapsulation.assigment_problems;

public class CharacterHealth {
    private int health;
    private final int maxHealth;

    public CharacterHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        CharacterHealth c = new CharacterHealth(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());
        c.heal(50);
        System.out.println("health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth());
    }
}
