// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public class Vrachtwagen extends Thread {
    private String naam;
    private Kade kade;
    private Kraan kraan1;
    private Kraan kraan2;
    
    private Container gepaktContainer;

    // Constructor
    public Vrachtwagen(String naam, Kade kade, Kraan kraan1, Kraan kraan2) {
        this.naam = naam;
        this.kade = kade;
        this.kraan1 = kraan1;
        this.kraan2 = kraan2;
        this.gepaktContainer = null;
    }

    @Override
    public void run() {
        while((kraan1.isAlive() == false && kraan2.isAlive() == false && kade.isLeeg() && gepaktContainer == null) == false) {
            try {
                // probeer een container te laden
                containerLaden();
                if(gepaktContainer != null) {
                    Thread.sleep((int) (Math.random() * 500));
                    containerLossen();
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(naam + " Thread is gestopt!");
        if(kade.isLeeg()) {
            System.out.println("Kade is leeg!");
        }
        else {
            System.out.println("Kade is nog niet leeg!");
        }
    }

    public void containerLossen() throws InterruptedException {
        System.out.println(naam + " heeft container: " + gepaktContainer.getContainerId() + " weggebracht.");
        gepaktContainer = null;
    }

    public void containerLaden() throws InterruptedException {
        if(gepaktContainer == null) {
            // pak een container van de kade
            gepaktContainer = kade.containerVanKadePakken();
            if(gepaktContainer != null) {
                gepaktContainer.containerLaden();
                System.out.println(naam + " heeft container " + gepaktContainer.getContainerId() + " opgepakt.");
            }
            
        }
    }
}