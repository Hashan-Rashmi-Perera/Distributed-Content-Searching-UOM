package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ChannelMessage;

public interface AbstractRequestHandler extends AbstractMessageHandler {

    void sendRequest(ChannelMessage message);
}
