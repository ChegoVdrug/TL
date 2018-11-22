package first;
//класс получает путь относительно коневого каталога, читает из конфига корневой каталог, возвращает запрашиваемый файл или поток
import java.io.FileInputStream;
import java.io.IOException;

public class FileWorking {

    public static void readFileFromServerRoot(String name) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(Utils.getProperty("WEB_SERVER_ROOT") + "/" + name);
        try {
            System.out.printf("File size: %d bytes \n", fileInputStream.available());

            int i = -1;
            while ((i = fileInputStream.read()) != -1) {

                System.out.print((char) i);
                System.out.printf(" ( код ASCII %d ) \n", i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}