package Routers;

import java.sql.SQLException;

import static Core.DbConnectionScannerAndFormatting.error;
import static Core.DbConnectionScannerAndFormatting.reset;
import static Modules.Unit.*;

public class UnitRouter {
    public static void unitRouter(String[] cmdBySpaceAndComma, String[] cmdBySpace) throws SQLException {
        int lengthOfCmdBySpace = cmdBySpace.length;
        if(lengthOfCmdBySpace<3){
            switch (cmdBySpace[1]) {
                case "create" -> unitCreate();
                case "edit" -> unitEdit();
                case "list" -> unitList();

                default -> System.out.println(error+"WARNING : Command not found !!!"+reset);
            }

        }
        else {

            if (cmdBySpace[2].equals("help")) {
                switch (cmdBySpace[1]) {
                    case "create" -> unitCreateHelp();
                    case "list" -> unitListHelp();
                    case "edit" -> unitEditHelp();
                    case "delete" -> unitDeleteHelp();
                    default -> System.out.println(error+"WARNING : Command not found !!!"+reset);
                }
            } else if (cmdBySpaceAndComma[1].equals("create")) {
                unitCreateWithAttributes(cmdBySpaceAndComma[2],cmdBySpaceAndComma[3],cmdBySpaceAndComma[4],cmdBySpaceAndComma[5]);

            }
            else if(cmdBySpaceAndComma[1].equals("delete")){
                unitDelete(cmdBySpaceAndComma[2]);
            } else if(cmdBySpaceAndComma[1].equals("edit")){
                unitEditWithAttributes(cmdBySpaceAndComma[2],cmdBySpaceAndComma[3],cmdBySpaceAndComma[4],cmdBySpaceAndComma[5]);
            }
        }
    }
}
