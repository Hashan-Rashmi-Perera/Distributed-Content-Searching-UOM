package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ChannelMessage;

public interface AbstractResponseHandler extends AbstractMessageHandler {

    void handleResponse(ChannelMessage message);
}
