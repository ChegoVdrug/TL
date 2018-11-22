package first;
import java.io.IOException;

public class Test {


    public static void main (String... args) throws IOException {

        FileWorking myPack = new FileWorking();
        myPack.readFileFromServerRoot("myPack.txt");


    }
}
