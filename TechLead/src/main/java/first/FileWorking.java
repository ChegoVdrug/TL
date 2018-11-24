package first;
//класс получает путь относительно коневого каталога, читает из конфига корневой каталог, возвращает запрашиваемый файл или поток

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileWorking {

    public static boolean isFilePresent(String name, String dir) {
        String path = dir + "/" + name;
        System.out.println(path);
        File file = new File(path);
        System.out.println(path + " есть такой файл? " + file.exists());
        return file.exists();

    }

    public static String readFileFromServerRoot(String name) throws IOException {
        String result = "";
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream;

        if (isFilePresent(name, Utils.getProperty("WEB_SERVER_ROOT")) == true) {
            try {
                fileInputStream = new FileInputStream(Utils.getProperty("WEB_SERVER_ROOT") + "/" + name);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                int i;

                System.out.printf("File size: %d bytes \n", bufferedInputStream.available());
                while ((i = bufferedInputStream.read()) != -1) {

                    result = result + ((char) i);
                    System.out.print((char) i);
                    System.out.printf(" ( код ASCII %d ) \n", i);
                }
            } finally {
                if (fileInputStream != null)
                    fileInputStream.close();
            }
        } else {
            result = "Ошибка!Такого файла не существует.";
        }
        return result;
    }
}
