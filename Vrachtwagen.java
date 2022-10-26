// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

import java.util.Random;

public class Vrachtwagen extends Thread{
    private String naam;
    private Container container;

    public Vrachtwagen(String naam) {
        this.naam = naam;
        this.container = null;
    }

    public void run() {
        while (true) {
            if(Kade.isLeeg() && ContainerSchip.isLeeg()) {
                
                break;
            }

            // haal container op
            try {
                haalContainerOp();
            }
            catch(NullPointerException e1) {}

            // verwerkings tijd zit tussen 1000 en 6000 ms
            Random rand = new Random();
            int sleepTime = rand.nextInt(3000) + 1000;
            try {
                sleep(sleepTime);
            } catch (InterruptedException e1) {}

            // weer beschikbaar
        }
    }


public synchronized void haalContainerOp() {
        for(int x = 0; x < 5; x++) {
            if(Kade.containers[x] != null) {
                this.container = Kade.containers[x].get();
                Kade.containers[x] = null;
                if(this.container instanceof GekoeldeContainer) {
                    System.out.println("Gekoelde container " + this.container.getVolgNummer() + " gekoppeld aan de vrachtwagen.");
                }
                else if(this.container instanceof VerwarmdeContainer) {
                    System.out.println("Verwarmde container " + this.container.getVolgNummer() + " gekoppeld aan de vrachtwagen.");
                }
                System.out.println(this.naam + " heeft de container " + this.container.getVolgNummer() + " opgehaald.");
                
                System.out.println("Er staan nu " + (5-Kade.aantalLegePlaatsen()) + " container(s) op de Kade.");
                break;
            }
        }
        throw new NullPointerException();
    }

}
