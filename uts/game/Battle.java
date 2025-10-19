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
        int turn = 1;
        while (isTeamAlive(teamA) && isTeamAlive(teamB)) {
            System.out.println("\n--- Turn " + turn + " ---");

            Character attacker = null;
            Character target = null;

            if (turn % 2 != 0) {
                attacker = findNextLivingAttacker(teamA, nextAttackerIndexA);
                if (attacker != null) {
                    nextAttackerIndexA = (teamA.indexOf(attacker) + 1) % teamA.size();
                }
                target = findTargetFor(attacker, teamB);
                
            } else {
                attacker = findNextLivingAttacker(teamB, nextAttackerIndexB);
                if (attacker != null) {
                    nextAttackerIndexB = (teamB.indexOf(attacker) + 1) % teamB.size();
                }
                target = findTargetFor(attacker, teamA);
            }
            if (attacker != null && target != null) {
                attacker.performTurn(target);
            } else if (attacker != null && target == null) {
                System.out.println(attacker.getName() + " melihat tidak ada target tersisa.");
            }
            
            turn++;
        }
        System.out.println("\n=== BATTLE BERAKHIR ===");
        if (isTeamAlive(teamA)) {
            System.out.println("\nSELAMAT ANDA MENANG!");
        } else if (isTeamAlive(teamB)) {
            System.out.println("\nAnda Kalah. . .");
        } else {
            System.out.println("\nPertarungan berakhir seri (semua kalah).");
        }
        
        printTeamStatus("Final Status Team A", teamA);
        printTeamStatus("Final Status Team B", teamB);
    }

    private Character findNextLivingAttacker(List<Character> team, int startIndex) {
        for (int i = startIndex; i < team.size(); i++) {
            if (team.get(i).isAlive()) {
                return team.get(i);
            }
        }
        for (int i = 0; i < startIndex; i++) {
            if (team.get(i).isAlive()) {
                return team.get(i);
            }
        }
        return null;
    }

    private Character findTargetFor(Character attacker, List<Character> targetTeam) {
        if (attacker == null) return null;
        Character bestTarget = null;
        if (attacker instanceof Player) {
            Enemy currentBestTarget = null;
            for (Character target : targetTeam) {
                if (!target.isAlive() || !(target instanceof Enemy)) continue;
                Enemy enemyTarget = (Enemy) target;
                if (currentBestTarget == null) {
                    currentBestTarget = enemyTarget;
                } else {
                    if (enemyTarget.getThreatLevel() > currentBestTarget.getThreatLevel()) {
                        currentBestTarget = enemyTarget;
                    }
                    else if (enemyTarget.getThreatLevel() == currentBestTarget.getThreatLevel()) {
                        if (enemyTarget.getHealth() < currentBestTarget.getHealth()) {
                            currentBestTarget = enemyTarget;
                        }
                    }
                }
            }
            bestTarget = currentBestTarget;
        } 
        else if (attacker instanceof Enemy) {
            Player currentBestTarget = null;
            
            for (Character target : targetTeam) {
                if (!target.isAlive() || !(target instanceof Player)) continue;
                Player playerTarget = (Player) target;
                if (currentBestTarget == null) {
                    currentBestTarget = playerTarget;
                } else {
                    if (playerTarget.getHealth() > currentBestTarget.getHealth()) {
                        currentBestTarget = playerTarget;
                    }
                }
            }
            bestTarget = currentBestTarget;
        }
        if (bestTarget == null) {
            for (Character target : targetTeam) {
                if (target.isAlive()) {
                    bestTarget = target;
                    break;
                }
            }
        }

        return bestTarget;
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