package TY;

public class TYMarks {
    
    public int Theory;
    public int Practicals;

    public TYMarks(int t, int p) {
        Theory = t;
        Practicals = p;
    }

    public String toString() {
        return Theory + "\t\t" + Practicals;
    }

}