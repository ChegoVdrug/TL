package first;


import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private static int serverPort; // здесь обязательно нужно указать порт к которому привязывается сервер.
    private static String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа.

    private static Socket socket; // Здесь указан адрес того самого компьютера где будет исполняться и клиент.


    public static void startClient() throws IOException {
        InputStream socketInputStream = null;
        OutputStream socketOutputStream = null;
        try {

            serverPort = Integer.parseInt(Utils.getProperty("port"));
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("add socket: " + address + ":" + serverPort);
            // Конвертируем
            // потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Создаем поток для чтения из файла
            FileReader fileReader = new FileReader("E:/Work/SERVER/requestList.txt");
            String messageToServ = "";

            int c;
            while ((c = fileReader.read()) != -1) {
                messageToServ = messageToServ + ((char) c);
            }

            System.out.println("Отправка запроса на сервер: нужно содержимое файла " + messageToServ);
            try {
                dataOutputStream.writeUTF(messageToServ); // отсылаем  строку текста серверу.
                dataOutputStream.flush(); // заставляем поток закончить передачу данных.
                messageToServ = dataInputStream.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("Содержимое файла: \n" + messageToServ);
                System.out.println("-------------THE_END-----------------");

            } finally {
                socket.close();
                try {
                    socketInputStream.close();  //падает здесь, если сервер уже закрыл потоки
                    socketOutputStream.close();
                } catch (NullPointerException x) {
                    System.out.println("\nСервер уже всё закрыл");

                }
            }
        } catch (ConnectException e) {
            e.printStackTrace();
            System.out.println("\n Ошибка соединения. Сначала нужно запустить сервер");
        }

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

