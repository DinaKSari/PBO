package uts.game;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    public static void main(String[] args) {
        AttackStrategy playerStrategy = new LevelScaledStrategy(2);
        AttackStrategy enemyStrategy = new FixedStrategy(); 
        Player hero = new Player("Dina", 600, 420, 5, playerStrategy);
        
        hero.addSkill(new HealSkill(20));
        hero.addSkill(new PiercingStrike(1.5)); 
        hero.addEffect(new Regen(5, 3)); 

        List<Character> teamA = new ArrayList<>();
        teamA.add(hero);

        Monster goblin = new Monster("Goblin", 40, 10, 1, enemyStrategy);
        
        BossMonster dragon = new BossMonster("Dragon", 80, 20, 5, enemyStrategy);
        
        dragon.addEffect(new Shield(10, 2));
        
        List<Character> teamB = new ArrayList<>();
        teamB.add(goblin);
        teamB.add(dragon);
        Battle battle = new Battle(teamA, teamB);
        battle.run();
    }
}
