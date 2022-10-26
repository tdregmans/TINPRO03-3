// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

import java.util.Random;

public class App {
    public static void main(String[] arg) {
        Random rand = new Random();

        // genereer 100 nieuwe containers
        Container[] containers = new Container[100];
        for(int x = 0; x < 99; x++) {
            int type = rand.nextInt(2);
            // bepaal het type container (random)
            if(type == 0) {
                containers[x] = new StandaardContainer(x);
            }
            else if(type == 1) {
                containers[x] = new GekoeldeContainer(x);
            }
            else {
                containers[x] = new VerwarmdeContainer(x);
            }
        }

        // laad het schip
        ContainerSchip containerSchip = new ContainerSchip(containers);

        // instancieer kranen en vrachtwagens
        Kraan kraan1 = new Kraan("De Wijnhaven kraan");
        Kraan kraan2 = new Kraan("De Museumplein kraan");

        Vrachtwagen vrachtwagen1 = new Vrachtwagen("De Java vrachtwagen");
        Vrachtwagen vrachtwagen2 = new Vrachtwagen("De Python vrachtwagen");
        Vrachtwagen vrachtwagen3 = new Vrachtwagen("De C# vrachtwagen");
        
        // start kranen en vrachtwagens
        kraan1.start();
        kraan2.start();

        vrachtwagen1.start();
        vrachtwagen2.start();
        vrachtwagen3.start();

        System.out.println("alle kranen en vrachtwagens gestart.");

        System.out.println("Er staan nu " + (5-Kade.aantalLegePlaatsen()) + " container(s) op de Kade.");
    }
}
