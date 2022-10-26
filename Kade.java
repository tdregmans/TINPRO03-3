// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public class Kade {
    static Container[] containersOpkade;
    private static int aantalLegePlekken = 5;
    private static int volgendeContainerIndex = 0;

    // Constructor
    public Kade() {
        containersOpkade = new Container[5];
        for(int x = 0; x < 5; x++){
            containersOpkade[x] = null;
        }
    }

    // Methode aangeroepen Kraan
    public synchronized void containerOpKadePlaatsen(Container tePlaatsenContainer) throws InterruptedException {
        while(aantalLegePlekken == 0) {
            wait();
        }
        if(aantalLegePlekken > 0) {
            containersOpkade[volgendeContainerIndex] = tePlaatsenContainer;
            volgendeContainerIndex++;
            aantalLegePlekken--;
            // notify kranen
            notifyAll();
        }
    }

    // Methode aangeroepen door Vrachtwagen
    public synchronized Container containerVanKadePakken() throws InterruptedException {
        while(aantalLegePlekken == 5) {
            wait();
        }

        if(aantalLegePlekken < 5) {
            int index = volgendeContainerIndex - 1;
            Container tempContainer = containersOpkade[index];
            containersOpkade[index] = null;
            aantalLegePlekken++;
            volgendeContainerIndex--;
            // notify vrachtwagens
            notifyAll();
            return tempContainer;
        } 
        else {
            return null;
        }
    }

    public boolean isLeeg() {
        return volgendeContainerIndex == 0;
    }
}