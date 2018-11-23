package first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int port; // случайный порт (может быть любое число от 1025 до 65535)
    private static ServerSocket serverSocket; // создаем сокет сервера
    private static Socket socket;
    private static InputStream socketInputStream;
    private static OutputStream socketOutputStream;
    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;

    public static void startServer() throws IOException {
        port = Integer.parseInt(Utils.getProperty("port"));

        try {
            serverSocket = new ServerSocket(port); // привязываем сокет к вышеуказанному порту

            System.out.println("Сокет привязан к порту. Нужно запустить клиента.");

            socket = serverSocket.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Есть клиент");
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            socketInputStream = socket.getInputStream();
            socketOutputStream = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            dataInputStream = new DataInputStream(socketInputStream);
            dataOutputStream = new DataOutputStream(socketOutputStream);

            String line = null;
            //while (true) {

                for (int j=5; j>0; j--) {
                    line = dataInputStream.readUTF(); // ожидаем пока клиент пришлет строку текста.
                    System.out.println("Клиент прислал запрос: " + line);
                    String fidBack = FileWorking.readFileFromServerRoot(line);
                    dataOutputStream.writeUTF(fidBack);
                    dataOutputStream.flush(); // заставляем поток закончить передачу данных.
                    System.out.printf("Осталось %d попыток", j);
                    System.out.println();
                }

        } catch (Exception x) {
            x.printStackTrace();
        }
        System.out.printf("Не знаю,как закрыть потоки из другого метода,поэтому пока закрываю в том же через 5 итераций");
        socket.close();
        socketInputStream.close();
        socketOutputStream.close();
        dataOutputStream.close();
    }

    public static void stopServer() throws IOException {

        socket.close();
        socketInputStream.close();
        socketOutputStream.close();
        dataOutputStream.close();


    }
}