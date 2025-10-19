package uts.game;
import java.util.*;

public class Battle {
    private final List<Character> teamA;
    private final List<Character> teamB;

    private int nextAttackerIndexA = 0;
    private int nextAttackerIndexB = 0;
    public Battle(List<Character> teamA, List<Character> teamB) {
        this.teamA = teamA; this.teamB = teamB;
    }

    public void run() {
        // loop turn, auto-targeting, log hasil, berhenti saat salah satu tim habis
    }
}