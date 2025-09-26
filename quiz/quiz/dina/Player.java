package quiz.quiz.dina;
public class Player extends Character{
    private int level;

    public Player(String name, int health, int attackPower, int level) {
        super(name, health, attackPower);
        this.level = level;
    }

    @Override
    public void attack(Character target){
        
    }
}
