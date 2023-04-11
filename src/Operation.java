import java.sql.SQLException;

import static Core.DbConnectionScannerAndFormatting.*;
import static Routers.ProductRouter.productRoute;
import static Routers.UnitRouter.unitRouter;

public class Operation {
    public static void main(String[] args) throws SQLException {
        while(true){
            System.out.print("> ");
            String cmd = scanner.nextLine();
            String[] cmdBySpace = cmd.toLowerCase().split(" ");
            String[] cmdBySpaceAndComma = cmd.toLowerCase().split("[ ,]");
            switch (cmdBySpace[0]){
                case "product" -> productRoute(cmdBySpaceAndComma,cmdBySpace);
                case "unit"-> unitRouter(cmdBySpaceAndComma,cmdBySpace);
                case "quit" -> {
                    System.out.println("GoodBye");System.exit(1);}
                default -> System.out.println(error+"WARNING : Command not found !!!"+reset);
            }

        }
    }
}
