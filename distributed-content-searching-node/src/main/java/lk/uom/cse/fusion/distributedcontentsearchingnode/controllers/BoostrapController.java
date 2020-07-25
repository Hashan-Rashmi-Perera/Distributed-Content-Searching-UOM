package lk.uom.cse.fusion.distributedcontentsearchingnode.controllers;


import lk.uom.cse.fusion.distributedcontentsearchingnode.DistributedContentSearchingNodeApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "bs")
public class BoostrapController {

    @GetMapping(value="unregister")
    public void unregisterFromBSServer(){
//
//        try {
//            //DistributedContentSearchingNodeApplication.bsClient.unRegister();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
