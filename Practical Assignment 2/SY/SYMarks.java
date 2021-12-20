package SY;

public class SYMarks {
    public int ComputerTotal;
    public int MathsTotal;
    public int ElectronicsTotal;

    public SYMarks(int c, int m, int e) {
        ComputerTotal = c;
        MathsTotal = m;
        ElectronicsTotal = e;

    }

    public String toString() {
        return (ComputerTotal + "\t\t" + MathsTotal + "\t\t" + ElectronicsTotal);
    }

}
