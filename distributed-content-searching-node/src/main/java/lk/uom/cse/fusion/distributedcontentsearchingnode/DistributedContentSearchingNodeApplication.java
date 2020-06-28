package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.BSClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class DistributedContentSearchingNodeApplication {

  public static void main(String[] args) {
    SpringApplication.run(DistributedContentSearchingNodeApplication.class, args);
  }

  @Bean
  public BSClient bsClient() throws IOException {
    BSClient bsClient = new BSClient();
    //bsClient.unRegister("hashan", "localhost", 8081);
    bsClient.register("hashan", "localhost", 8081);
    return bsClient;
  }
}
