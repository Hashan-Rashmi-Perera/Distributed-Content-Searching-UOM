package lk.uom.cse.fusion.distributedcontentsearchingnode.resource;


import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "client")
public class SearchController {

    @Autowired
    SearchService searchService;


    @GetMapping(value="search")
    public Map<String, SearchResult> searchForAFile(@RequestParam String fileName){
        return searchService.searchFile(fileName);
    }
}
