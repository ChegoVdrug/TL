package first;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void startClient() throws IOException {

        int serverPort; //  порт к которому привязывается сервер.
        String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется серверная программа.
        Socket socket = null; // адрес компьютера где будет исполняться и клиент.
        InputStream socketInputStream = null;
        OutputStream socketOutputStream = null;

        try {
            serverPort = Integer.parseInt(Utils.getProperty("port"));
            InetAddress inetAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            socket = new Socket(inetAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("add socket: " + address + ":" + serverPort);
            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            // Создаем поток для чтения из файла
            String messageToServ;

            for (int i = 1; i <= 5; i++) {
                messageToServ = FileWorking.readLineFromFile("requestList.txt", i);
                System.out.println("Отправка запроса на сервер: нужно содержимое файла " + messageToServ);
                try {
                    dataOutputStream.writeUTF(messageToServ); // отсылаем  строку текста серверу.
                    dataOutputStream.flush(); // заставляем поток закончить передачу данных.
                    messageToServ = dataInputStream.readUTF(); // ждем пока сервер отошлет строку текста.
                    System.out.println("Содержимое файла: \n" + messageToServ);
                    System.out.println("-------------THE_END-----------------");
                } catch (EOFException r) {
                    System.out.println("?????????????????????????????");
                }
            }

        } finally {
            try {
                socket.close();
                socketInputStream.close();  //падает здесь, если сервер уже закрыл потоки
                socketOutputStream.close();
            } catch (NullPointerException x) {
                System.out.println("\nСервер уже всё закрыл");

            }
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

