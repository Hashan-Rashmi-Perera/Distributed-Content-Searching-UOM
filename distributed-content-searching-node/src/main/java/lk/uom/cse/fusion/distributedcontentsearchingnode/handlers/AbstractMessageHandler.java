package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ChannelMessage;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.RoutingTable;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.TimeoutManager;

import java.util.concurrent.BlockingQueue;

interface AbstractMessageHandler {
    void init (
            RoutingTable routingTable,
            BlockingQueue<ChannelMessage> channelOut,
            TimeoutManager timeoutManager);

}
