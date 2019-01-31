package ping_pong_project;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multi3 implements Runnable {

    public static DatagramSocket Socket2;
    public static int Port;
    public static int CountPacket = 1;
    public static boolean FlagServer = false;

    public Multi3(int p) {

        this.Port = p;

    }

    @Override
    public void run() {

        try {
            ReceivePacket(Port);
        } catch (IOException ex) {
            Logger.getLogger(Multi3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ReceivePacket(int Prot) throws IOException {

        try {
            Socket2 = new DatagramSocket(Prot);
        } catch (SocketException ex) {
            Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] b1 = new byte[1024];

        DatagramPacket dp = new DatagramPacket(b1, b1.length);

        while (true) {

            try {

                Socket2.receive(dp);

                String str = new String(b1);

                Server_UDP.model2.addRow(new Object[]{CountPacket++, "" + dp.getAddress(), "" + dp.getPort(), "" + dp.getLength()});

                byte[] b2 = str.getBytes();

                DatagramPacket dp1 = new DatagramPacket(b2, b2.length, dp.getAddress(), dp.getPort());
                Socket2.send(dp1);

            } catch (Exception e) {

                break;

            }

        }

    }

    public static void main(String args[]) {

    }

}
