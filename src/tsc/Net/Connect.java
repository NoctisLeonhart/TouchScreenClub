package tsc.Net;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tsc.Functions.TSCConfig;

/**
 * Created by Noctis on 23.07.2014.
 */
public class Connect {

    private static Thread AcceptPacketThread;
    private static Socket socket = null;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static InputStream sin;
    private static OutputStream sout;
    private static boolean SendStatus = false;
    private TSCConfig configuration = new TSCConfig();


    public Connect(){

    }

    public byte[] getPacket(String firstName, String lastName,
                            String email, String address, String city,
                            String state, String country,
                            String dateOfBirth, String phNumber,
                            boolean agree_swch,String lang){
        return (firstName+";"+lastName+";"+email+";"+address+";"+city+";"+state+";"+country+";"+dateOfBirth+";"
        +phNumber+";"+String.valueOf(agree_swch)+";"+lang+";"+getIP()+";"+getMacAddress()).getBytes();
    }

    public boolean sendData(final byte[] Packet){
        try {
            SendStatus = false;
            socket = new Socket(configuration.getIP(), configuration.getPort());
            sin = socket.getInputStream();
            sout = socket.getOutputStream();
        }catch (Exception ex){
   //         JOptionPane.showMessageDialog(null,"Error connecting to server");
            return false;
        }
        in = new DataInputStream(sin);
        out = new DataOutputStream(sout);
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            public void run() {
                try {
                    out.write(Packet);
                    if (readRequest(in).equals("<OK>"))
                        SendStatus = true;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error sending packet. The server can not accept the packet.");
                    SendStatus = false;
                }
                notifyAll();
            }});
        return SendStatus;
    }

    private int bufferLength(byte[] buffer){
        for(int i = buffer.length-1; i > 0; i--)
            if(buffer[i] != 0x00)
                return i+1;
        return 0;
    }

    private String readRequest(DataInputStream in) throws IOException {
        byte[] Buffer = new byte[1024];
        in.read(Buffer);
        Buffer = SpaceDelete(Buffer,bufferLength(Buffer));
        return new String(Buffer, "UTF-8");
    }

    private byte[] SpaceDelete(byte[] buffer, int Bufferlength){
        byte[] fixbuffer = new byte[Bufferlength];
        for(int i = 0;i<Bufferlength;i++)
            fixbuffer[i] = buffer[i];
        return fixbuffer;
    }

    private String getMacAddress(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        }catch (SocketException ex){
        }catch (UnknownHostException uEx){
        }
        return "Unknown";
    }

    private String getIP(){
        try {
            InetAddress IP=InetAddress.getLocalHost();
        return IP.getHostAddress();
        } catch (UnknownHostException e) {
        }
        return "";
    }

}

