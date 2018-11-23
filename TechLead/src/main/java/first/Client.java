package first;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private static int serverPort; // здесь обязательно нужно указать порт к которому привязывается сервер.
    private static String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.

    private static Socket socket; // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

    public static int i;
    private static InputStream socketInputStream;
    private static OutputStream socketOutputStream;



    public static void startClient() throws IOException {

        try {
            i=5;
            //serverPort = Integer.parseInt(Utils.getProperty("port"));
            serverPort = 8081;
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.

            socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("add socket: " + address + ":" + serverPort );

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            socketInputStream = socket.getInputStream();
            socketOutputStream = socket.getOutputStream();

            // Конвертируем
            // потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream dataInputStream = new DataInputStream(socketInputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(socketOutputStream);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Введите имя файла, содержимое которого хотите получить. Например myPack.txt");


           // while (true) {
            for (int j=5; j>0; j--){
                System.out.printf("Осталось %d попыток", j);
                System.out.println();
                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Отправка запроса на сервер...");
                try {
                dataOutputStream.writeUTF(line); // отсылаем введенную строку текста серверу.
                dataOutputStream.flush(); // заставляем поток закончить передачу данных.
                line = dataInputStream.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("Содержимое файла: " + line);


                System.out.println();}
                catch (EOFException e) {
                    System.out.println("Вы ввели пустое значение. Так не надо"); //плохо обработано исключение, как лучше, пока не знаю

                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

        System.out.printf("Не знаю,как закрыть потоки из другого метода,поэтому пока закрываю в том же через 5 итераций");
        socket.close();
        socketInputStream.close();
        socketOutputStream.close();

        }

    }
/*
    public static void stopClient() throws IOException {
        System.out.println(i);
        socket.close();
        socketInputStream.close();
        socketOutputStream.close();
    }


*/

