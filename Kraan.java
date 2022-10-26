// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public class Kraan extends Thread {
    private String naam;
    private Kade kade;
    private Containerschip containerschip;
    private Container vastGepakteContainer;

    // Constructor
    public Kraan(String naam, Containerschip containerschip, Kade kade) {
        this.naam = naam;
        this.containerschip = containerschip;
        this.kade = kade;
        this.vastGepakteContainer = null;
    }

    @Override
    public void run() {
        while(containerschip.isLeeg == false) {
            try {
                containerLaden();
                if(vastGepakteContainer != null) {
                    Thread.sleep((int) (Math.random() * 500));
                    containerLossen();
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void containerLossen() throws InterruptedException {
        if(vastGepakteContainer != null) {
            // pak een container uit het schip
            vastGepakteContainer.containerLossen();
            kade.containerOpKadePlaatsen(vastGepakteContainer);
            System.out.println(naam + " heeft container " + vastGepakteContainer.getContainerId() + " op de kade gezet.");
            vastGepakteContainer = null;
        }
    }

    public void containerLaden() throws InterruptedException {
        vastGepakteContainer = containerschip.haalContainerUitSchip();
        if(vastGepakteContainer != null) {
            System.out.println(naam + " heeft container " + vastGepakteContainer.getContainerId() + " uit de boot gepakt.");
        }
    }

}