package lk.uom.cse.fusion.distributedcontentsearchingnode.comms;

import lk.uom.cse.fusion.distributedcontentsearchingnode.Constants;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Slf4j
public class BSClient {

  private final String BS_IPAddress = "127.0.0.1";
  private final int BS_Port = 55555;

  private final DatagramSocket datagramSocket;

  public BSClient() throws IOException {
    datagramSocket = new DatagramSocket();
  }

  public List<InetSocketAddress> register(String userName, String ipAddress, int port)
      throws IOException {
    String request = String.format(Constants.REG_FORMAT, ipAddress, port, userName);
    request = String.format(Constants.MSG_FORMAT, request.length() + 5, request);
    return processBSResponse(sendOrReceive(request));
  }

  public boolean unRegister(String userName, String ipAddress, int port) throws IOException {
    String request = String.format(Constants.UNREG_FORMAT, ipAddress, port, userName);
    request = String.format(Constants.MSG_FORMAT, request.length() + 5, request);
    return processBSUnregisterResponse(sendOrReceive(request));
  }

  private List<InetSocketAddress> processBSResponse(String response) {
    StringTokenizer stringToken = new StringTokenizer(response, " ");
    String length = stringToken.nextToken();
    String status = stringToken.nextToken();

    if (!Constants.REGOK.equals(status)) {
      throw new IllegalStateException(Constants.REGOK + " not received");
    }
    int nodesCount = Integer.parseInt(stringToken.nextToken());
    List<InetSocketAddress> gNodes = null;
    switch (nodesCount) {
      case 0:
        log.info("Successful - No other nodes in the network");
        gNodes = new ArrayList<>();
        break;
      case 1:
        log.info("No of nodes found : 1");
        gNodes = new ArrayList<>();
        while (stringToken.hasMoreTokens()) {
          gNodes.add(
              new InetSocketAddress(
                  stringToken.nextToken(), Integer.parseInt(stringToken.nextToken())));
        }
        break;
      case 2:
        log.info("No of nodes found : 2");
        gNodes = new ArrayList<>();
        while (stringToken.hasMoreTokens()) {
          gNodes.add(
              new InetSocketAddress(
                  stringToken.nextToken(), Integer.parseInt(stringToken.nextToken())));
        }
        break;
      case 9999:
        log.error("Failed. There are errors in your command");
        break;
      case 9998:
        log.error("Failed, already registered to you, unRegister first");
        break;
      case 9997:
        log.error("Failed, registered to another user, try a different IP and port");
        break;
      case 9996:
        log.error("Failed, can’t register. BS full.");
        break;
      default:
        throw new IllegalStateException("Invalid status code");
    }
    return gNodes;
  }

  private boolean processBSUnregisterResponse(String response) {
    StringTokenizer stringTokenizer = new StringTokenizer(response, " ");
    String length = stringTokenizer.nextToken();
    String status = stringTokenizer.nextToken();
    if (!Constants.UNROK.equals(status)) {
      throw new IllegalStateException(Constants.UNROK + " not received");
    }
    int code = Integer.parseInt(stringTokenizer.nextToken());
    switch (code) {
      case 0:
        log.info("Successfully unregistered");
        return true;
      case 9999:
        log.error(
            "Error while un-registering. "
                + "IP and port may not be in the registry or command is incorrect");
      default:
        return false;
    }
  }

  private String sendOrReceive(String request) throws IOException {
    DatagramPacket sendingPacket = new DatagramPacket(request.getBytes(), request.length(), InetAddress.getByName(BS_IPAddress), BS_Port);
    datagramSocket.setSoTimeout(Constants.TIMEOUT_REG);
    datagramSocket.send(sendingPacket);
    byte[] buffer = new byte[65536];
    DatagramPacket received = new DatagramPacket(buffer, buffer.length);
    datagramSocket.receive(received);
    return new String(received.getData(), 0, received.getLength());
  }
}
