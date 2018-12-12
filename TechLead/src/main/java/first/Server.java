package first;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void startServer() throws IOException {

        int port; // случайный порт (может быть любое число от 1025 до 65535)
        ServerSocket serverSocket; // создаем сокет сервера
        Socket socket = null;
        InputStream socketInputStream= null;
        OutputStream socketOutputStream = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

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
            for (int i = 0; i <= 5; i++) {
                String line;
                line = dataInputStream.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("Клиент прислал запрос: " + line);
                String fidBack = FileWorking.getTextFromFileInRoot(line);
                dataOutputStream.writeUTF(fidBack);
            }
            dataOutputStream.flush(); // заставляем поток закончить передачу данных.
            System.out.println();



        } finally {
            socket.close();
            socketInputStream.close();
            socketOutputStream.close();
            dataInputStream.close();
            dataOutputStream.close();
        }
    }

  /*  public static void stopServer() throws IOException {

        socket.close();
        socketInputStream.close();
        socketOutputStream.close();
        dataOutputStream.close();


    }
    */
}