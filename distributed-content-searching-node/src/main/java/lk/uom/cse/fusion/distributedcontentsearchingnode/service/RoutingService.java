package lk.uom.cse.fusion.distributedcontentsearchingnode.service;

import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.RoutingTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutingService {

    @Autowired
    private GNode gNode;

    public RoutingTable getRoutingTable() {
        gNode.printRoutingTable();
        return gNode.getMessageBroker().getRoutingTable();
    }
}
