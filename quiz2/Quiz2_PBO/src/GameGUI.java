package quiz2.Quiz2_PBO.src;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class GameGUI extends JFrame {

    // Data tim dan list skill
    private List<Character> teamA = new ArrayList<>();
    private List<Character> teamB = new ArrayList<>();
    private List<Skill> availableSkills = new ArrayList<>();

    // komponen - Tim player
    private JTextField txtPlayerName, txtPlayerHP, txtPlayerAP, txtPlayerLevel;
    private JList<String> listSkillsForPlayer;
    private DefaultListModel<String> skillListModel;
    private DefaultListModel<String> teamAListModel;
    private JList<String> listTeamA;

    // komponen - tim musuh
    private JTextField txtEnemyName, txtEnemyHP, txtEnemyAP, txtThreatLevel;
    private JCheckBox chkIsBoss;
    private DefaultListModel<String> teamBListModel;
    private JList<String> listTeamB;

    // komponen - Skills
    private JTextField txtSkillAmountOrMult;
    private JComboBox<String> cmbSkillType;
    
    // komponen - Battle
    private JTextArea battleLog;
    private JButton btnStartBattle;

    public GameGUI() {
        setTitle("RPG Battle Simulator");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // tab
        JTabbedPane tabbedPane = new JTabbedPane();

        // 1. Tab Skill Manager
        tabbedPane.addTab("1. Manage Skills", createSkillPanel());

        // 2. Tab tim player
        tabbedPane.addTab("2. Manage Heroes", createTeamAPanel());

        // 3. Tab tim musuh
        tabbedPane.addTab("3. Manage Enemies", createTeamBPanel());

        // 4. Tab simulasi battle
        tabbedPane.addTab("4. Battle Arena", createBattlePanel());

        add(tabbedPane, BorderLayout.CENTER);

        // Redirect System.out ke Text Area
        redirectSystemStreams();
        
        // Pre-load biar mudah testing
        preloadDefaults();
    }

    private void preloadDefaults() {
        // Default Skills
        availableSkills.add(new HealSkill(20));
        availableSkills.add(new PiercingStrike(1.5));
        updateSkillListUI();

        // Default Player
        Player p = new Player("Hero Default", 500, 50, 1, new LevelScaledStrategy(5));
        p.addSkill(availableSkills.get(0)); // Add Heal
        teamA.add(p);
        updateTeamAListUI();

        // Default musuh
        Monster m = new Monster("Goblin", 100, 20, 1, new FixedStrategy());
        teamB.add(m);
        updateTeamBListUI();
    }

    // panel 1 skill
    private JPanel createSkillPanel() {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

    // ini bagian input
    JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // Dikurangi barisnya karena button dipisah
    inputPanel.setBorder(new TitledBorder("Create New Skill"));

    inputPanel.add(new JLabel("Skill Type:"));
    cmbSkillType = new JComboBox<>(new String[]{"Heal Skill", "Piercing Strike"});
    inputPanel.add(cmbSkillType);

    inputPanel.add(new JLabel("Amount / Multiplier:"));
    txtSkillAmountOrMult = new JTextField("20");
    inputPanel.add(txtSkillAmountOrMult);

    // ini bagian button
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Rata kiri atau CENTER sesuai selera
    JButton btnAddSkill = new JButton("Add Skill to Pool");
    btnAddSkill.setPreferredSize(new Dimension(160, 30)); // Ukuran fix biar mirip tombol hero
    buttonPanel.add(btnAddSkill);

    JPanel topContainer = new JPanel(new BorderLayout());
    topContainer.add(inputPanel, BorderLayout.CENTER);
    topContainer.add(buttonPanel, BorderLayout.SOUTH);

    // bagian output, list skill
    skillListModel = new DefaultListModel<>();
    listSkillsForPlayer = new JList<>(skillListModel); 
    JScrollPane scrollPane = new JScrollPane(listSkillsForPlayer);
    scrollPane.setBorder(new TitledBorder("Available Skill Pool"));

    // action
    btnAddSkill.addActionListener(e -> {
        try {
            String type = (String) cmbSkillType.getSelectedItem();
            double val = Double.parseDouble(txtSkillAmountOrMult.getText());
            
            Skill newSkill;
            if ("Heal Skill".equals(type)) {
                newSkill = new HealSkill((int) val);
            } else {
                newSkill = new PiercingStrike(val);
            }
            availableSkills.add(newSkill);
            updateSkillListUI();
            JOptionPane.showMessageDialog(this, "Skill Added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Number Format");
        }
    });

    panel.add(topContainer, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);

    return panel;
}

    // panel 2 tim player
    private JPanel createTeamAPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(new TitledBorder("Hero Details"));

        inputPanel.add(new JLabel("Name:"));
        txtPlayerName = new JTextField("Hero");
        inputPanel.add(txtPlayerName);

        inputPanel.add(new JLabel("HP:"));
        txtPlayerHP = new JTextField("500");
        inputPanel.add(txtPlayerHP);

        inputPanel.add(new JLabel("Attack Power:"));
        txtPlayerAP = new JTextField("40");
        inputPanel.add(txtPlayerAP);

        inputPanel.add(new JLabel("Level:"));
        txtPlayerLevel = new JTextField("1");
        inputPanel.add(txtPlayerLevel);

        JButton btnAddPlayer = new JButton("Add Hero to Team A");
        
        // List seleksi skill
        JList<String> skillSelector = new JList<>(skillListModel);
        skillSelector.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane skillScroll = new JScrollPane(skillSelector);
        skillScroll.setBorder(new TitledBorder("Select Skills to Learn (Hold Ctrl)"));
        skillScroll.setPreferredSize(new Dimension(200, 100));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputPanel, BorderLayout.CENTER);
        centerPanel.add(skillScroll, BorderLayout.EAST);

        teamAListModel = new DefaultListModel<>();
        listTeamA = new JList<>(teamAListModel);
        JButton btnClearA = new JButton("Clear Team A");

        btnAddPlayer.addActionListener(e -> {
            try {
                String name = txtPlayerName.getText();
                int hp = Integer.parseInt(txtPlayerHP.getText());
                int ap = Integer.parseInt(txtPlayerAP.getText());
                int lvl = Integer.parseInt(txtPlayerLevel.getText());

                // Default strategi 
                Player p = new Player(name, hp, ap, lvl, new LevelScaledStrategy(5));
                
                // Add selected skills
                int[] selectedIndices = skillSelector.getSelectedIndices();
                for (int idx : selectedIndices) {
                    p.addSkill(availableSkills.get(idx));
                }

                teamA.add(p);
                updateTeamAListUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error input data: " + ex.getMessage());
            }
        });

        btnClearA.addActionListener(e -> {
            teamA.clear();
            updateTeamAListUI();
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(btnAddPlayer, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(listTeamA), BorderLayout.CENTER);
        bottomPanel.add(btnClearA, BorderLayout.SOUTH);

        panel.add(centerPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);

        return panel;
    }

    // panel 3, tim musuh
    private JPanel createTeamBPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(new TitledBorder("Enemy Details"));

        inputPanel.add(new JLabel("Is Boss?"));
        chkIsBoss = new JCheckBox();
        inputPanel.add(chkIsBoss);

        inputPanel.add(new JLabel("Name:"));
        txtEnemyName = new JTextField("Monster");
        inputPanel.add(txtEnemyName);

        inputPanel.add(new JLabel("HP:"));
        txtEnemyHP = new JTextField("100");
        inputPanel.add(txtEnemyHP);

        inputPanel.add(new JLabel("Attack Power:"));
        txtEnemyAP = new JTextField("15");
        inputPanel.add(txtEnemyAP);

        inputPanel.add(new JLabel("Threat Level (1-5):"));
        txtThreatLevel = new JTextField("1");
        inputPanel.add(txtThreatLevel);

        JButton btnAddEnemy = new JButton("Add Enemy to Team B");
        
        teamBListModel = new DefaultListModel<>();
        listTeamB = new JList<>(teamBListModel);
        JButton btnClearB = new JButton("Clear Team B");

        btnAddEnemy.addActionListener(e -> {
            try {
                String name = txtEnemyName.getText();
                int hp = Integer.parseInt(txtEnemyHP.getText());
                int ap = Integer.parseInt(txtEnemyAP.getText());
                int threat = Integer.parseInt(txtThreatLevel.getText());
                boolean isBoss = chkIsBoss.isSelected();

                if (isBoss) {
                    BossMonster b = new BossMonster(name, hp, ap, threat, new FixedStrategy());
                    teamB.add(b);
                } else {
                    Monster m = new Monster(name, hp, ap, threat, new FixedStrategy());
                    teamB.add(m);
                }
                updateTeamBListUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error input data.");
            }
        });

        btnClearB.addActionListener(e -> {
            teamB.clear();
            updateTeamBListUI();
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(btnAddEnemy, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(listTeamB), BorderLayout.CENTER);
        bottomPanel.add(btnClearB, BorderLayout.SOUTH);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);

        return panel;
    }

    // panel 4, untuk simulasi battle
    private JPanel createBattlePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(battleLog);
        
        btnStartBattle = new JButton("START BATTLE SIMULATION");
        btnStartBattle.setFont(new Font("Arial", Font.BOLD, 16));
        btnStartBattle.setBackground(new Color(200, 100, 100));
        
        btnStartBattle.addActionListener(e -> startBattleThread());

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnStartBattle, BorderLayout.SOUTH);
        return panel;
    }

    // logic

    private void updateSkillListUI() {
        skillListModel.clear();
        for (Skill s : availableSkills) {
            skillListModel.addElement(s.name());
        }
    }

    private void updateTeamAListUI() {
        teamAListModel.clear();
        for (Character c : teamA) {
            teamAListModel.addElement("[Hero] " + c.getName() + " (HP: " + c.getHealth() + ")");
        }
    }

    private void updateTeamBListUI() {
        teamBListModel.clear();
        for (Character c : teamB) {
            String role = (c instanceof BossMonster) ? "[BOSS]" : "[Monster]";
            teamBListModel.addElement(role + " " + c.getName() + " (HP: " + c.getHealth() + ")");
        }
    }

    private void startBattleThread() {
        if (teamA.isEmpty() || teamB.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Both teams must have at least 1 member!");
            return;
        }

        btnStartBattle.setEnabled(false);
        battleLog.setText(""); // Clear log
        battleLog.append("Initializing Battle...\n");

        // Jalankan battle di Thread terpisah agar GUI tidak Freeze
        new Thread(() -> {
            try {
                Battle battle = new Battle(teamA, teamB);
                battle.run();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                SwingUtilities.invokeLater(() -> btnStartBattle.setEnabled(true));
            }
        }).start();
    }

    // ouput redirek biar sout bisa ke textarea
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(() -> {
            battleLog.append(text);
            battleLog.setCaretPosition(battleLog.getDocument().getLength());
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new GameGUI().setVisible(true);
        });
    }
}