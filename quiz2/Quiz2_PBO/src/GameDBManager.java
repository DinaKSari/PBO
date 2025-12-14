package quiz2.Quiz2_PBO.src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDBManager {
    // Sesuaikan konfigurasi database Anda di sini
    private static final String URL = "jdbc:postgresql://localhost:5432/uas_db"; // Ganti nama db
    private static final String USER = "postgres"; // Ganti user
    private static final String PASSWORD = "apayah34."; // Ganti password

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // --- BAGIAN SKILL ---
    
    public void saveSkill(String name, String type, double value) {
        String sql = "INSERT INTO skills (name, skill_type, value) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setDouble(3, value);
            pstmt.executeUpdate();
            System.out.println("Skill berhasil disimpan ke DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> loadSkills() {
        List<Skill> skills = new ArrayList<>();
        String sql = "SELECT * FROM skills";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("skill_type");
                // String name = rs.getString("name"); // Nama dari DB tidak dipakai di constructor saat ini
                double val = rs.getDouble("value");
                
                if (type.equalsIgnoreCase("HEAL")) {
                    // PERBAIKAN: Constructor HealSkill hanya minta int (amount)
                    skills.add(new HealSkill((int) val));
                } else {
                    // PERBAIKAN: Constructor PiercingStrike hanya minta double (multiplier)
                    skills.add(new PiercingStrike(val)); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }

    // --- BAGIAN HERO ---

    public void saveHero(Player p) {
        String sql = "INSERT INTO heroes (name, hp, ap, level) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getHealth());
            pstmt.setInt(3, p.getAttackPower());
            pstmt.setInt(4, p.getLevel());
            pstmt.executeUpdate();
            System.out.println("Hero disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Player> loadHeroes() {
        List<Player> heroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AttackStrategy strategy = new LevelScaledStrategy(10); 
                
                Player p = new Player(
                    rs.getString("name"),
                    rs.getInt("hp"),
                    rs.getInt("ap"),
                    rs.getInt("level"), 
                    strategy
                );
                heroes.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    // --- BAGIAN ENEMY ---

    public void saveEnemy(Enemy e, boolean isBoss) {
        String sql = "INSERT INTO enemies (name, hp, ap, is_boss, threat_level, strategy_type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, e.getName());
            pstmt.setInt(2, e.getHealth());
            pstmt.setInt(3, e.getAttackPower());
            pstmt.setBoolean(4, isBoss);
            pstmt.setInt(5, e.getThreatLevel());
            pstmt.setString(6, "FIXED"); // Simplifikasi default strategy
            pstmt.executeUpdate();
            System.out.println("Enemy disimpan.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Character> loadEnemies() {
        List<Character> enemies = new ArrayList<>();
        String sql = "SELECT * FROM enemies";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AttackStrategy strat = new FixedStrategy(); // Default
                boolean isBoss = rs.getBoolean("is_boss");
                String name = rs.getString("name");
                int hp = rs.getInt("hp");
                int ap = rs.getInt("ap");
                int threat = rs.getInt("threat_level");

                if (isBoss) {
                    enemies.add(new BossMonster(name, hp, ap, threat, strat));
                } else {
                    enemies.add(new Monster(name, hp, ap, threat, strat));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enemies;
    }

    // --- BAGIAN HISTORY BATTLE ---

    public void saveBattleHistory(String winner, String logs) {
        String sql = "INSERT INTO battle_history (winner, log_content) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, winner);
            pstmt.setString(2, logs);
            pstmt.executeUpdate();
            System.out.println("History Battle disimpan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}