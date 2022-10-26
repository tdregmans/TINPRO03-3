// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (06-07-2022)

public class VerwarmdeContainer extends Container {
    public VerwarmdeContainer(int id) {
        super(id);
    }

    @Override
    public void containerLossen() {
        System.out.println("Container " + containerId + " wordt losgekoppeld van de verwarmingselementen.");
    }

    @Override
    public void containerLaden() {
        System.out.println("Container " + containerId + " wordt aan de verwarmingselementen gekoppeld.");
    }
}