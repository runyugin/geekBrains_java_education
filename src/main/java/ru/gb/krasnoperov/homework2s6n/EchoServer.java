package ru.gb.krasnoperov.homework2s6n;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {

            System.out.println("Wait client");
            Socket socket = serverSocket.accept();
            System.out.println("Client ON-LINE");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());


            new Thread(() -> {

                while (true){
                    Scanner scanner = new Scanner(System.in);
                    String message = scanner.nextLine();
                    if("/end".equalsIgnoreCase(message)){
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();



            while (true){
                String message = in.readUTF();
                if("/end".equalsIgnoreCase(message)){
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Сообщение от клиента : " + message);
                out.writeUTF("[echo] " + message);
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
