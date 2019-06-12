import common.Utils;
import medium.leetcode79.Solution;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] broad = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(broad, "SEE"));


//        String locAddress = "{\"code\":0,\"user\":{\"ip\":\"10.1.1.229\",\"name\":\"rain\"}}";
//        String broadcastAddress = "10.1.1.255";
//        DatagramSocket datagramSocket = null;
//        try {
//            datagramSocket = new DatagramSocket();
//            byte[] data = locAddress.getBytes();
//            DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getByName(broadcastAddress), 9156);
//            datagramSocket.send(datagramPacket);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(datagramSocket != null) datagramSocket.close();
//        }
    }
}
