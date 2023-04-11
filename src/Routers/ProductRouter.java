package Routers;

import java.sql.SQLException;

import static Core.DbConnectionScannerAndFormatting.error;
import static Core.DbConnectionScannerAndFormatting.reset;
import static Modules.Product.*;

public class ProductRouter{
    public static void productRoute(String[] cmdBySpaceAndComma, String[] cmdBySpace) throws SQLException {
        int lengthOfCmdBySpace = cmdBySpace.length;
        if(lengthOfCmdBySpace<3){
                try{
                    switch (cmdBySpace[1]) {
                        case "create" -> productCreate();
                        case "count" -> productCount();
                        case "edit" -> productEdit();
                        case "list" -> productListDefault();
                    }
                }
                catch (Exception e){
                    System.out.println(error+"WARNING : Command not found !!!"+reset);
                }
        }
        else {

                if(cmdBySpace[2].equals("help")){
                    switch (cmdBySpace[1]) {
                        case "create" -> productCreateHelp();
                        case "list" -> productListHelp();
                        case "edit" -> productEditHelp();
                        case "delete" -> productDeleteHelp();
                    }
                } else if (cmdBySpaceAndComma[1].equals("create")) {
                    try{
                        productCreateWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                    }catch (Exception e){
                        productCreateWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6]);
                    }
                }
                else if (cmdBySpaceAndComma[1].equals("delete")) {
                    productDelete(cmdBySpaceAndComma[2]);
                } else if (cmdBySpaceAndComma[1].equals("edit")) {
                    try{
                        productEditWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                    }
                    catch (Exception e){
                        productEditWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6]);
                    }
                } else if (cmdBySpaceAndComma[1].equals("list")&& cmdBySpaceAndComma[2].equals("-s")) {

                    try{
                        productListWithAttributesAndPaging(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4],cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                    }catch (Exception e){
                        try{
                            productListWithAttributes(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4]);
                        }
                        catch (Exception err){
                            try{
                                productGlobalSearchList(cmdBySpaceAndComma[3]);
                            }
                            catch (Exception error){
                                System.out.println("Something went wrong");
                            }
                        }
                    }
                } else if (cmdBySpaceAndComma[1].equals("list")&& cmdBySpaceAndComma[2].equals("-p")) {
                    try{
                        productListDefaultWithListCountAndPageNo(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4]);
                    }
                    catch (Exception e){
                        productListDefaultWithListCount(cmdBySpaceAndComma[3]);
                    }
                }
                else {
                    System.out.println(error+"WARNING : Command not found !!!"+reset);
                }
        }
    }
}
