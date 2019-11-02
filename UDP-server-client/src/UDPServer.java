
import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9090);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String sentence = new String( receivePacket.getData(), 0, receivePacket.getLength() );
                System.out.println("Received: "+sentence);
                String stringData = "Hello client!";
                sendData = stringData.getBytes();
                InetAddress clientipaddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, clientipaddress, clientPort);
                socket.send(sendPacket);



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
