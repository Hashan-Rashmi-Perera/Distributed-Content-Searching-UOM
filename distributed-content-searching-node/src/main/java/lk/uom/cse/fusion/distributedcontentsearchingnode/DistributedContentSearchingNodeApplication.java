/**
 * url: https://github.com/Hashan-Rashmi-Perera/Distributed-Content-Searching-UOM
 */
package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lk.uom.cse.fusion.distributedcontentsearchingnode.models.requests.FileRef;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@SpringBootApplication
public class DistributedContentSearchingNodeApplication {

  public static void main(String[] args) {
    SpringApplication.run(DistributedContentSearchingNodeApplication.class, args);
  }

  @Bean
  @Scope("singleton")
  public GNode gNode() throws Exception {
    String uniqueID = UUID.randomUUID().toString();
    return new GNode("node" + uniqueID);
  }

  @Bean
  @Scope("singleton")
  public FileRef fileRef() throws Exception {
    return new FileRef();
  }
}
