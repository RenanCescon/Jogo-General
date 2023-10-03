import java.io.Serializable;
import java.util.Random;
import java.io.Serializable;

public class Dado implements Serializable {
    private int sideUp;

    public Dado() {sideUp = 1;}

    public void roll(){
        Random r = new Random();
        int i = r.nextInt(6);
        sideUp = i + 1;
    }

    public int getSideUp(){return sideUp;}
}
