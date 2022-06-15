package ru.gb.krasnoperov.homework2s6n;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new EchoClient().start();
    }

    private void start() {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);

            while (true){
                String message = scanner.nextLine();
                sendMessage(message);
                if("/end".equalsIgnoreCase(message)){
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void sendMessage(String message) {

        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1",8189);
        in = new DataInputStream(socket.getInputStream());
        out= new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {

                try {
                    while (true){
                        String message  = in.readUTF();
                        if("/end".equalsIgnoreCase(message)){
                            break;
                        }
                        System.out.println("Сообщение от сервера: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    сloseConnection();
                }

        }).start();
    }

    private void сloseConnection() {
        if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket!=null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
