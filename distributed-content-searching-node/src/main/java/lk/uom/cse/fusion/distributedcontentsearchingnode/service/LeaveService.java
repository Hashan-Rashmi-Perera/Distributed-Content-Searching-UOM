package lk.uom.cse.fusion.distributedcontentsearchingnode.service;

import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private GNode gNode;

    public void leavenDS() {
        gNode.unRegister();
    }
}
