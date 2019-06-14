import common.List;
import common.Utils;
import medium.leetcode86.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 4, 3, 2, 5, 2};
        List list = new List();
        list.printList(solution.partition(list.initList(nums), 3));

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
