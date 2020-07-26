package lk.uom.cse.fusion.distributedcontentsearchingnode.controllers;


import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.models.requests.FileRef;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    RegisterService registerService;

    @Autowired
    private GNode gNode;

    @Autowired
    private FileRef fileRef;

    @GetMapping(value = "/search")
    public Map<String, SearchResult> searchForAFile(@RequestParam("fileName") String fileName) {
        return registerService.searchFile(fileName);
    }

    @GetMapping(value = "/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFileWithGet(@RequestParam("file") Integer fileOption) {
        gNode.getFile(fileOption);
        File fileDownload = new File(fileRef.update());
        Response.ResponseBuilder response = Response.ok(fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + fileDownload.getName());
        return response.build();
    }
}
