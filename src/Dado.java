import java.io.Serializable;
import java.util.Random;

public class Dado implements Serializable {
    private int sideUp;

    public Dado() {sideUp = 1;}

    // sorteia aleatoriamente qual será a face superior do dado
    public void roll(){
        Random r = new Random();
        int i = r.nextInt(6);
        sideUp = i + 1;
    }

    // retorna a face superior do dado
    public int getSideUp(){return sideUp;}
}
