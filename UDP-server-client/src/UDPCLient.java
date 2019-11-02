
import java.io.*;
import java.net.*;

    public class UDPCLient {


        public static class Main {

            public static void main(String[] args) {
                try {

                DatagramSocket clientSocket = new DatagramSocket(0);
                byte[] sendData = new byte[1024];
                byte[] receiveData = new byte[1024];
                //amount of data = 65535 - 20 IP header - 8 UDP header = 65508 available.

                    //clientSocket.setSoTimeout(3000);
                    InetAddress serverAddress = InetAddress.getByName("localhost");
                    String stringSendData = "Hello Server!";
                    sendData = stringSendData.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,serverAddress, 9090);
                    clientSocket.send(sendPacket);
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);
                    receiveData = receivePacket.getData();
                    String stringReceiveDAta = new String( receiveData, 0, receivePacket.getLength() );
                    System.out.println("From Server: "+stringReceiveDAta);
                    clientSocket.close();


                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

    }

