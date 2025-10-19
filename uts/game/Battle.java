package uts.game;
import java.util.*;

public class Battle {
    private final List<Character> teamA;
    private final List<Character> teamB;

    private int nextAttackerIndexA = 0;
    private int nextAttackerIndexB = 0;
    public Battle(List<Character> teamA, List<Character> teamB) {
        this.teamA = new ArrayList<>(teamA);
        this.teamB = new ArrayList<>(teamB);
    }

    public void run() {
        System.out.println("=== BATTLE DIMULAI! ===");
        printTeamStatus("Team A", teamA);
        printTeamStatus("Team B", teamB);
    }

    private void printTeamStatus(String teamName, List<Character> team) {
        System.out.println("--- " + teamName + " ---");
        for (Character member : team) {
            String status = member.isAlive() ? "Hidup" : "Kalah";
            System.out.println(String.format("  - %s (HP: %d/%d) [%s]",
                member.getName(),
                member.getHealth(),
                member.maxHealth,
                status));
        }
    }
}