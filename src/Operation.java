import java.sql.SQLException;

public class Operation {
    static void getCommand() throws SQLException {
        System.out.print("> ");
        String cmd = DbConnection.scanner.nextLine();
        String[] cmdBySpace = cmd.toLowerCase().split(" ");
//        System.out.println("IN cmdBySpace");
//        for(String items : cmdBySpace){
//            System.out.println(items);
//        }
        String[] cmdBySpaceAndComma = cmd.toLowerCase().split("[ ,]");
//        System.out.println("IN cmdBySpaceAndComma");
//        for(String items : cmdBySpaceAndComma){
//            System.out.println(items);
//        }
        route(cmdBySpaceAndComma,cmdBySpace);
    }
    static void route(String[] cmdBySpaceAndComma,String[] cmdBySpace) throws SQLException {
        int lengthOfCmdBySpace = cmdBySpace.length;
        System.out.println("Length of by Space :"+lengthOfCmdBySpace);
        int lengthOfSpaceAndComma = cmdBySpaceAndComma.length;
        System.out.println("Length of by Space and Comma :"+lengthOfSpaceAndComma);
        if(lengthOfCmdBySpace<3){
            if(cmdBySpace[0].equals("product")) {
                switch (cmdBySpace[1]) {
                    case "create":
                        Product.create();
                        break;
                    case "count":
                        Product.count();
                        break;
                    case "edit":
                        Product.edit();
                        break;
                }
            }
        }
        //product create help X
        //product create code, productname, unitcode, type, costprice, stock X
        //product create :enter X
        //product count X
        //product list help X
        //product list -s type: chocolate -p 5 2 X
        //product edit help X
        //product edit id:<id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price> X
        //product edit :enter X
        //product delete help X
        //product delete <id> X
        if(lengthOfCmdBySpace>2){
            if(cmdBySpace[0].equals("product")){
                if(cmdBySpace[2].equals("help")){
                    switch (cmdBySpace[1]){
                        case "create" : Product.productCreateHelp();
                            break;
                        case "list" : Product.listHelp();
                            break;
                        case "edit" : Product.editHelp();
                            break;
                        case "delete" : Product.deleteHelp();
                            break;
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
                    Product.editWithAttributes();
                } else if (cmdBySpaceAndComma[1].equals("list")) {
                    Product.listWithTypes(cmdBySpaceAndComma[4]);
                }

            }

        }
        getCommand();
        }
    public static void main(String[] args) throws SQLException {
        getCommand();
    }
}
