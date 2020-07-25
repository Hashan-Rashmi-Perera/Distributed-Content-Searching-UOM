package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.BSClient;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(99)
public class BootstrapRegisterRunner implements ApplicationRunner {
    @Autowired
    private GNode gNode;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        gNode.init();
    }
}
