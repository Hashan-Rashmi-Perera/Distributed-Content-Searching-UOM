package lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ftp;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

@NoArgsConstructor
public class FTPClient {

    public FTPClient(String IpAddress, int port, String fileName) throws Exception {

        long start = System.currentTimeMillis();
        Socket serverSock = new Socket(IpAddress, port);

        System.out.println("Connecting...");
        Thread t = new Thread(new DataReceivingOperation(serverSock, fileName));
        t.start();
        long stop = System.currentTimeMillis();
    }

    public File downloadFile(String IpAddress, int port, String fileName) throws IOException {
        Socket serverSock = new Socket(IpAddress, port);
        System.out.println("Connecting...");
        DataReceivingOperation dataReceivingOperation = new DataReceivingOperation(serverSock, fileName);
        return dataReceivingOperation.downloadFile();
    }
}
