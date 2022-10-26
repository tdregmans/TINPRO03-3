// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

public class ContainerSchip {
    public static Container[] containers;

    public ContainerSchip(Container[] containers) {
        ContainerSchip.containers = containers;
        
    }

    public static boolean isLeeg() {
        int aantal = 0;
        for(Container container : containers) {
            if(container != null) {
                aantal++;
            }
        }
        return aantal == 0;
    }
}
