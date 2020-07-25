package lk.uom.cse.fusion.distributedcontentsearchingnode;

import lk.uom.cse.fusion.distributedcontentsearchingnode.core.GNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
@Order(99)
public class BootstrapRegisterRunner implements ApplicationRunner {
  @Autowired private GNode gNode;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Runnable myRunnable = this::run;
    myRunnable.run();
  }

  private void run() {
    gNode.init();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\nChoose what do you want to do below : ");
      System.out.println("1) Do a search");
      System.out.println("2) Print the routing table");
      System.out.println("3) Exit the network");

      System.out.println("\nPlease enter the option : ");

      String commandOption = scanner.nextLine();

      if (commandOption.equals("1")) {
        System.out.println("\nEnter your search query below : ");
        String searchQuery = scanner.nextLine();

        if (searchQuery != null && !searchQuery.equals("")) {
          int results = gNode.doSearch(searchQuery);

          if (results != 0) {

            while (true) {

              try {
                System.out.println("\nPlease choose the file you need to download : ");
                String fileOption = scanner.nextLine();

                int option = Integer.parseInt(fileOption);

                if (option > results) {
                  System.out.println("Please give an option within the search results...");
                  continue;
                }

                gNode.getFile(option);
                break;

              } catch (NumberFormatException e) {
                System.out.println(
                    "Enter a valid integer indicating "
                        + "the file option shown above in the results...");
              }
            }
          }

        } else {
          System.out.println("Please give a valid search query!!!");
        }
      } else if (commandOption.equals("2")) {
        gNode.printRoutingTable();

      } else if (commandOption.equals("3")) {
        gNode.unRegister();
        System.exit(0);

      } else {
        System.out.println("Please enter a valid option...");
      }
    }
  }
}
