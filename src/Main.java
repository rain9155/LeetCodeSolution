import medium.leetcode89.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> ret = solution.grayCode(3);
        for(int num : ret){
            System.out.println(num);
        }

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
