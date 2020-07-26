package lk.uom.cse.fusion.distributedcontentsearchingnode.service;

import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.core.SearchResult;
import lk.uom.cse.fusion.distributedcontentsearchingnode.exceptions.InvalidInput;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class SearchService {

  @Autowired private GNode gNode;

  public Map<String, SearchResult> searchFile(@NonNull String fileName) {

    if (fileName != null && !fileName.equals("")) {
      gNode.doSearch(fileName);
      return gNode.getSearchManager().getDosearchResults();
    } else {
      throw new InvalidInput();
    }
  }

  public File downloadFile(@NonNull Integer fileOption) throws IOException {
    return gNode.downloadFile(fileOption);
  }
}
