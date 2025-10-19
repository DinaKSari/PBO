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

    
    private boolean isTeamAlive(List<Character> team) {
        for (Character member : team) {
            if (member.isAlive()) {
                return true;
            }
        }
        return false;
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