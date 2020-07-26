package lk.uom.cse.fusion.distributedcontentsearchingnode.resource;


import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "client")
public class SearchController {

    @Autowired
    SearchService searchService;


    @GetMapping(value="search")
    public Map<String, SearchResult> searchForAFile(@RequestParam("key") String fileName){
        return searchService.searchFile(fileName);
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity downloadFileWithGet(@RequestParam("file") Integer fileOption) throws IOException {
        File downloadFile = searchService.downloadFile(fileOption);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(downloadFile));
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=" + downloadFile.getName())
                .contentLength(downloadFile.length())
                .body(resource);
        //Response.ResponseBuilder response = Response.ok(fileDownload);
        //response.header("Content-Disposition", "attachment;filename=" + fileDownload.getName());
        //return response.build();
    }
}
