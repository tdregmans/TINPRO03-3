// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public class App {
    public static void main(String[] args) {
        // Kade
        Kade kade = new Kade();
        
        // ContainerSchip
        Containerschip containerSchip = new Containerschip();

        // Kranen
        Kraan kraan1 = new Kraan("ContainerKraan 1", containerSchip, kade);
        Kraan kraan2 = new Kraan("ContainerKraan 2", containerSchip, kade);    

        // Vrachtwagens
        Vrachtwagen vrachtwagen1 = new Vrachtwagen("Vrachtwagen 1", kade, kraan1, kraan2);
        Vrachtwagen vrachtwagen2 = new Vrachtwagen("Vrachtwagen 2", kade, kraan1, kraan2);
        Vrachtwagen vrachtwagen3 = new Vrachtwagen("Vrachtwagen 3", kade, kraan1, kraan2);

        // Start Threads
        kraan1.start();
        kraan2.start();
        vrachtwagen1.start();
        vrachtwagen2.start();
        vrachtwagen3.start();
    } 
}