package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

import lk.uom.cse.fusion.distributedcontentsearchingnode.Constants;
import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ChannelMessage;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.Neighbour;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.RoutingTable;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.TimeoutManager;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class LeaveHandler implements AbstractRequestHandler {

    private RoutingTable routingTable;
    private BlockingQueue<ChannelMessage> channelOut;
    private static LeaveHandler leaveHandler;

    public synchronized static LeaveHandler getInstance() {
        if (leaveHandler == null){
            leaveHandler = new LeaveHandler();
        }
        return leaveHandler;
    }

    public void sendLeave () {
        String payload = String.format(Constants.LEAVE_FORMAT,
                this.routingTable.getAddress(),
                this.routingTable.getPort());
        String rawMessage = String.format(Constants.MSG_FORMAT, payload.length() + 5,payload);
        ArrayList<Neighbour> neighbours = routingTable.getNeighbours();
        for (Neighbour n: neighbours) {
            ChannelMessage message = new ChannelMessage(n.getAddress(), n.getPort(),rawMessage);
            sendRequest(message);
        }

    }

    @Override
    public void init(RoutingTable routingTable,
                     BlockingQueue<ChannelMessage> channelOut,
                     TimeoutManager timeoutManager) {
        this.routingTable = routingTable;
        this.channelOut = channelOut;
    }

    @Override
    public void sendRequest(ChannelMessage message) {
        try {
            channelOut.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
