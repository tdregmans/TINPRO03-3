// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

import java.util.Random;

public class Kraan  extends Thread{
    private String naam;
    private Container container;

    public Kraan(String naam) {
        this.naam = naam;
        this.container = null;
    }

    public void run() {
        while(true) {
            // pak container
            try {
                pakContainer();
            }
            catch(NullPointerException e) {
                // geen containers meer in het schip
                if(this.container == null) {
                    break;
                }
            }

            // verwerkings tijd zit tussen 1000 en 6000 ms
            Random rand = new Random();
            int sleepTime = rand.nextInt(5000) + 1000;
            try {
                sleep(sleepTime);
            } catch (InterruptedException e1) {}
            
            // plaats container
            System.out.println(this.naam + " heeft de container " + this.container.getVolgNummer() + " op de kade gezet.");
            // LET OP! resultaat wordt geprint voordat het is behaald. Daardoor lijkt het alsof de kade wordt overloaded.
            plaatsContainerOpKade();
        }
    }


    public synchronized void pakContainer() {
        // check of kraan nu een container vast heeft
        if(this.container == null) {
            if(!ContainerSchip.isLeeg()) {
                // zoek random een container in het schip
                Random rand = new Random();
                Container tempContainer;
                int index;
                do {
                    index = rand.nextInt(100);
                } while(ContainerSchip.containers[index] == null);
                // pak container
                tempContainer = ContainerSchip.containers[index];
                ContainerSchip.containers[index] = null;
                this.container = tempContainer;
                // indien nodig; loskoppelen
                if(this.container instanceof GekoeldeContainer) {
                    System.out.println("Gekoelde container " + this.container.getVolgNummer() + " losgekoppeld van het containerschip.");
                }
                else if(this.container instanceof VerwarmdeContainer) {
                    System.out.println("Verwarmde container " + this.container.getVolgNummer() + " losgekoppeld van het containerschip.");
                }

                System.out.println(this.naam + " heeft de container " + this.container.getVolgNummer() + " opgepakt.");
                System.out.println("Er staan nu " + (5-Kade.aantalLegePlaatsen()) + " container(s) op de Kade.");
                
            }
            else {
                // geen containers meer in het schip
                throw new NullPointerException();
            }
        }
        else {
            while(this.container != null) {
                plaatsContainerOpKade();
            }
        }
    }
    
    public synchronized void plaatsContainerOpKade() {
        int nieuwePlek;
        boolean plaatsenIsMogelijk = false;
        try {
            nieuwePlek = Kade.legePlek();
            plaatsenIsMogelijk = true;
        } catch (NullPointerException e) {
            // geen lege plek op de kade
            System.out.println("Let op!");
            
            System.out.println("Er staan nu " + (5-Kade.aantalLegePlaatsen()) + " container(s) op de Kade. Er is geen plaats meer!");
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        if(plaatsenIsMogelijk) {
            // laat vrachtwagens weten dat deze container beschikbaar is
            this.container.put();
            // plaats container op kade op lege plek
            Kade.containers[Kade.legePlek()] = this.container;
            this.container = null;
            System.out.println("Er staan nu " + (5-Kade.aantalLegePlaatsen()) + " container(s) op de Kade.");
        }
    }

}