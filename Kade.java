// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

public class Kade {
    public static Container[] containers = new Container[5];

    public static boolean isPlek() {
        return 
        containers[0] == null ||
        containers[1] == null ||
        containers[2] == null ||
        containers[3] == null ||
        containers[4] == null;
    }

    public static boolean isLeeg() {
        return 
        containers[0] == null &&
        containers[1] == null &&
        containers[2] == null &&
        containers[3] == null &&
        containers[4] == null;
    }

    public static int legePlek() {
        for(int x = 0; x < 5; x++) {
            if(containers[x] == null) {
                return x;
            }
        }
        throw new NullPointerException();
    }

    public static int aantalLegePlaatsen() {
        int aantal = 0;
        for(int x = 0; x < 5; x++) {
            if(containers[x] == null) {
                aantal++;
            }
        }
        return aantal;
    }
}