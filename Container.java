// Technische Informatica

// Programmeren 3 - TINPRO03-3 
// Inleveropdracht: het containerschip
// Student: Thijs Dregmans (1024272)
// Deadline: 10-04-2022

public abstract class Container {
    private int volgNummer;
    private boolean available = false;

    public Container(int volgNummer) {
        this.volgNummer = volgNummer;
        this.available = false;
    }

    public int getVolgNummer() {
        return this.volgNummer;
    }

    public synchronized Container get() {
        while(!available) {
            try {
                wait();
                System.out.println(this.toString());
            }
            catch (InterruptedException e) {}
        }
        available = false;
        notify();
        return this;
    }

    public synchronized void put() {
        while(available) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        available = true;
        notify();
    }
}