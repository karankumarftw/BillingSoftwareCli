import java.sql.SQLException;

public class Operation {
    static void getCommand() throws SQLException {
        System.out.print("> ");
        String cmd = DbConnection.scanner.nextLine();
        String[] cmdBySpace = cmd.toLowerCase().split(" ");
        String[] cmdBySpaceAndComma = cmd.toLowerCase().split("[ ,]");
        route(cmdBySpaceAndComma,cmdBySpace);
    }
    static void route(String[] cmdBySpaceAndComma,String[] cmdBySpace) throws SQLException {
        int lengthOfCmdBySpace = cmdBySpace.length;
        if(lengthOfCmdBySpace<3){
            if(cmdBySpace[0].equals("product")) {
                try{
                    switch (cmdBySpace[1]) {
                        case "create" -> Product.create();
                        case "count" -> Product.count();
                        case "edit" -> Product.edit();
                        case "list" -> Product.listDefault();
                    }
                }
                catch (Exception e){
                    System.out.println(DbConnection.error+"WARNING : Command not found !!!"+DbConnection.reset);
                }

            }
        }
        else if(lengthOfCmdBySpace>2){
            if(cmdBySpace[0].equals("product")){
                if(cmdBySpace[2].equals("help")){
                    switch (cmdBySpace[1]) {
                        case "create" -> Product.productCreateHelp();
                        case "list" -> Product.listHelp();
                        case "edit" -> Product.editHelp();
                        case "delete" -> Product.deleteHelp();
                    }
                } else if (cmdBySpaceAndComma[1].equals("create")) {
                   try{
                       Product.createWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                   }catch (Exception e){
                       Product.createWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6]);
                   }
                }
                else if (cmdBySpaceAndComma[1].equals("delete")) {
                    Product.delete(cmdBySpaceAndComma[2]);
                } else if (cmdBySpaceAndComma[1].equals("edit")) {
                    System.out.println("entered into product edit section ");
                    try{
                        Product.editWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                    }
                    catch (Exception e){
                        Product.editWithAttributes(cmdBySpaceAndComma[2], cmdBySpaceAndComma[3], cmdBySpaceAndComma[4], cmdBySpaceAndComma[5], cmdBySpaceAndComma[6]);
                    }
                } else if (cmdBySpaceAndComma[1].equals("list")&& cmdBySpaceAndComma[2].equals("-s")) {

                    try{
                        Product.listWithAttributesAndPaging(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4],cmdBySpaceAndComma[6],cmdBySpaceAndComma[7]);
                    }catch (Exception e){
                        try{
                            Product.listWithAttributes(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4]);
                        }
                        catch (Exception err){
                            try{
                                Product.globalSearchList(cmdBySpaceAndComma[3]);
                            }
                            catch (Exception error){
                                System.out.println("Something went wrong");
                            }
                        }
                    }
                } else if (cmdBySpaceAndComma[1].equals("list")&& cmdBySpaceAndComma[2].equals("-p")) {
                    try{
                        Product.listDefaultWithListCountAndPageNo(cmdBySpaceAndComma[3],cmdBySpaceAndComma[4]);
                    }
                    catch (Exception e){
                        Product.listDefaultWithListCount(cmdBySpaceAndComma[3]);
                    }
                }
                else {
                    System.out.println(DbConnection.error+"WARNING : Command not found !!!"+DbConnection.reset);
                }
            }
            else{
                System.out.println(DbConnection.error+"WARNING : Command not found !!!"+DbConnection.reset);
            }
        }
        else{
            System.out.println(DbConnection.error+"WARNING : Command not found !!!"+DbConnection.reset);
        }
        getCommand();
        }
    public static void main(String[] args) throws SQLException {
        getCommand();
    }
}
