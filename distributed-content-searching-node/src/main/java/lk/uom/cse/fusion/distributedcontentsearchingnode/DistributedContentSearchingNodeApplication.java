package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.BSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
@Slf4j
@SpringBootApplication
public class DistributedContentSearchingNodeApplication {

  public static void main(String[] args) {
    SpringApplication.run(DistributedContentSearchingNodeApplication.class, args);
  }

  @Bean
  public BSClient bsClient() throws IOException {
    BSClient bsClient = new BSClient();
    try {
      // bsClient.unRegister("hashan", "localhost", 8081);
      bsClient.register("hashan", "localhost", 8081);
    } catch (Exception e) {
      log.error("Error registering with bootstrap server: ", e);
    } finally {
      return bsClient;
    }
  }
}
