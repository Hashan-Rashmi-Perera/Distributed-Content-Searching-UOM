package lk.uom.cse.fusion.distributedcontentsearchingnode.controllers;


import lk.uom.cse.fusion.distributedcontentsearchingnode.core.FileManager;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    RegisterService registerService;

    @Autowired private GNode gNode;



    @GetMapping(value="search")
    public Map<String, SearchResult> searchForAFile(@RequestParam String fileName){


        return registerService.searchFile(fileName);

    }

    @GetMapping(value="download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFileWithGet(@QueryParam("file") int fileOption) {
        String userName = gNode.getUserName();
        String fileSeparator = System.getProperty("file.separator");
        //File file = new File(rootFolder + fileSeparator + fileName);
        String username = "";
        String rootFolder =   "." + fileSeparator + userName;
        File fileDownload = new File(rootFolder + fileSeparator + fileName);
        //File fileDownload = new File(file);

        Response.ResponseBuilder response = Response.ok((Object) fileDownload);
        response.header("Content-Disposition", "attachment;filename=" + fileName);
        return response.build();
    }


 @GetMapping(value="download")
 public void getFile(@RequestParam int fileOption){

     gNode.getFile(fileOption);
 }
}
