// Programmeren 3
// TINPRO03-1
// Student: Thijs Dregmans (1024272)
// gelegenheid 2 (07-07-2022)

public abstract class Container {
    // abstract class Container
    public int containerId;

    // Constructor
    public Container(int id) {
        this.containerId = id;
    }

    // abstracte methods
    public abstract void containerLossen();

    public abstract void containerLaden();

    public int getContainerId() {
        return containerId;
    }
}