package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.comms.BSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@SpringBootApplication
public class DistributedContentSearchingNodeApplication {

     public static BSClient bsClient;

    public static void main(String[] args) {
    SpringApplication.run(DistributedContentSearchingNodeApplication.class, args);


        try {

            if(args.length>0)
                bsClient = new BSClient(args[0],args[1],Integer.parseInt(args[2]));
                else
                    bsClient= new BSClient("osura", "localhost", 8081);


             bsClient.register();

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
