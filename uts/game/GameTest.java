package uts.game;
public class GameTest {
    public static void main(String[] args) {
        Player p = new Player("HeroVipkas", 120, 25, 5, newLevelScaledStrategy(2));
        p.addSkill(new HealSkill(15));
        // tambah efek awal, musuh, boss, lalu jalankan Battle
    }
}
