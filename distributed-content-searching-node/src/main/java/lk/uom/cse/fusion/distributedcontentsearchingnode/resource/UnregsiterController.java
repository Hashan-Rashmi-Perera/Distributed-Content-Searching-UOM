package lk.uom.cse.fusion.distributedcontentsearchingnode.resource;

import lk.uom.cse.fusion.distributedcontentsearchingnode.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UnregsiterController {

    @Autowired
    LeaveService leaveService;

    @GetMapping("unregister")
    public String unregisterNode() {
        leaveService.leavenDS();
        return "Success fully left!";
    }
}
