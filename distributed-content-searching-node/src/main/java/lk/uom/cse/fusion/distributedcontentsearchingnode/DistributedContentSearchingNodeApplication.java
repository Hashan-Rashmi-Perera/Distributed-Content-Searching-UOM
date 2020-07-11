package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.BSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class DistributedContentSearchingNodeApplication {

     public static BSClient bsClient;

    public static void main(String[] args) {
    SpringApplication.run(DistributedContentSearchingNodeApplication.class, args);


        try {

            bsClient = new BSClient();


            if(args.length>0)  bsClient.register(args[0],args[1],Integer.parseInt(args[2]));
            else {
                bsClient.register("osura", "localhost", 8081);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//  @Bean
//  public BSClient bsClient() throws IOException {
//    BSClient bsClient = new BSClient();
//    //bsClient.unRegister("hashan", "localhost", 8081);
//
//    return bsClient;
//  }
}
