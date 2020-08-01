package lk.uom.cse.fusion.distributedcontentsearchingnode.resource;


import lk.uom.cse.fusion.distributedcontentsearchingnode.core.RoutingTable;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.RoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RoutingTableController {
    @Autowired
    RoutingService routingService;

    @GetMapping("routing-table")
    public RoutingTable getRoutingTable() {

        return routingService.getRoutingTable();
    }
}
