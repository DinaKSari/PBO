package quiz1.dina;
// Main class 
public class GameTest { 
    public static void main(String[] args) { 
        Player p1 = new Player("Dina", 100, 20, 5); 
        Monster m1 = new Monster("Goblin", 80, 15, "Goblin"); 
        BossMonster m2 = new BossMonster("Dragon", 200, 30, "Dragon");
        Character[] characters = {m1, m2}; 
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        } 
        //player healing
        p1.healing(p1);
        p1.attack(m1);
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        }
        p1.healing(p1);
        p1.healing(p1);
        p1.attack(m1);
        p1.healing(p1);
        p1.attack(m1);
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        }
        p1.healing(p1);
        p1.attack(m1);
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        }
        p1.healing(p1);
        p1.attack(m1);
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        }
        p1.healing(p1);
        p1.attack(m1);
        for (Character c : characters) { 
        c.attack(p1); // semua karakter menyerang player 
        }
    } 
} 
