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
  public BSClient modelMapper() throws IOException {
    return new BSClient();
  }
}
