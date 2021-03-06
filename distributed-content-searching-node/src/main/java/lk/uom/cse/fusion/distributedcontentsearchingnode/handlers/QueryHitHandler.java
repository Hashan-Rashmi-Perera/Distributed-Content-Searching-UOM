package lk.uom.cse.fusion.distributedcontentsearchingnode.handlers;

import lk.uom.cse.fusion.distributedcontentsearchingnode.Constants;
import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.ChannelMessage;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.RoutingTable;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.TimeoutManager;
import lk.uom.cse.fusion.distributedcontentsearchingnode.utils.StringEncoderDecoder;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class QueryHitHandler implements AbstractResponseHandler {

    private static final Logger LOG = Logger.getLogger(QueryHitHandler.class.getName());

    private RoutingTable routingTable;

    private BlockingQueue<ChannelMessage> channelOut;

    private TimeoutManager timeoutManager;

    private static QueryHitHandler queryHitHandler;

    private Map<String, SearchResult> searchResutls;

    private long searchInitiatedTime;

    private QueryHitHandler(){

    }

    public static synchronized QueryHitHandler getInstance(){
        if (queryHitHandler == null){
            queryHitHandler = new QueryHitHandler();
        }

        return queryHitHandler;
    }

    @Override
    public synchronized void handleResponse(ChannelMessage message) {
        LOG.fine("Received SEROK : " + message.getMessage()
                + " from: " + message.getAddress()
                + " port: " + message.getPort());

        StringTokenizer stringToken = new StringTokenizer(message.getMessage(), " ");

        String length = stringToken.nextToken();
        String keyword = stringToken.nextToken();
        int filesCount = Integer.parseInt(stringToken.nextToken());
        String address = stringToken.nextToken().trim();
        int port = Integer.parseInt(stringToken.nextToken().trim());

        String addressKey = String.format(Constants.ADDRESS_KEY_FORMAT, address, port);

        int hops = Integer.parseInt(stringToken.nextToken());

        while(filesCount > 0){

            String fileName = StringEncoderDecoder.decode(stringToken.nextToken());

            if (this.searchResutls != null){
                if(!this.searchResutls.containsKey(addressKey + fileName)){
                    this.searchResutls.put(addressKey + fileName,
                            new SearchResult(fileName, address, port, hops,
                                    (System.currentTimeMillis() - searchInitiatedTime)));

                }
            }

            filesCount--;
        }
    }

    @Override
    public void init(RoutingTable routingTable, BlockingQueue<ChannelMessage> channelOut, TimeoutManager timeoutManager) {
        this.routingTable = routingTable;
        this.channelOut = channelOut;
        this.timeoutManager = timeoutManager;
    }

    public void setSearchResutls(Map<String, SearchResult> searchResutls) {
        this.searchResutls = searchResutls;
    }

    public void setSearchInitiatedTime(long currentTimeinMillis){
        this.searchInitiatedTime = currentTimeinMillis;
    }

}
