// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (06-07-2022)

public class StandaardContainer extends Container {
    public StandaardContainer(int id) {
        super(id);
    }

    @Override
    public void containerLossen() {
        System.out.println("Container " + containerId + " wordt gelost.");
    }

    @Override
    public void containerLaden() {
        System.out.println("Container " + containerId + " wordt geladen.");
        
    }
}