// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public class Containerschip {
    private static Container[] containersInSchip;
    private int aantalInSchip;
    public boolean isLeeg;

    // Constructor
    public Containerschip() {
        aantalInSchip = 0;
        // zet 100 containers in het schip
        containersInSchip = new Container[20];
        for(int x = 0; x < 20; x++) {
            // maak containertype random
            int randomContainerTypeIndex = (int)(3.0 * Math.random());
            if(randomContainerTypeIndex == 0) {
                containersInSchip[x] = new StandaardContainer(x);
            }
            else if(randomContainerTypeIndex == 1) {
                containersInSchip[x] = new GekoeldeContainer(x);
            }
            else if(randomContainerTypeIndex == 2) {
                containersInSchip[x] = new VerwarmdeContainer(x);
            }
            aantalInSchip++;
        }
        System.out.println("Het containerschip is vol!");
        isLeeg = false;
    }

    // Methode aangeroepen door Kraan
    public synchronized Container haalContainerUitSchip() {
        if(aantalInSchip > 0) {
            System.out.println("Container " + aantalInSchip + " wordt opgepakt uit het containerschip.");
            aantalInSchip--;
            return containersInSchip[aantalInSchip];
            
        } 
        else {
            System.out.println("Het containerschip is leeg.");
            isLeeg = true;
            return null;
        }
    }
}