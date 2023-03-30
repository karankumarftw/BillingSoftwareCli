
import java.sql.SQLException;

public class Product {
    public static void createWithAttributes(String code,String name,String unit,String type, String price) throws SQLException {
        System.out.println("product create With Attributes");
        DbConnection.query = "insert into products(code,name,unit,type,price) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+price+"')";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product inserted successfully");
        Operation.getCommand();
    }
    public static void createWithAttributes(String code,String name,String unit,String type, String price,String stock) throws SQLException {
        System.out.println("product create With Attributes");
        DbConnection.query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+price+"','"+stock+"')";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product inserted successfully");
        Operation.getCommand();
    }
    public static void create() throws SQLException {
        System.out.println("PRODUCT CREATION");
        System.out.print("code : ");
        String code = DbConnection.scanner.nextLine();
        System.out.print("name : ");
        String name = DbConnection.scanner.nextLine();
        System.out.println("unit : ");
        String unit = DbConnection.scanner.nextLine();
        System.out.println("type : ");
        String type = DbConnection.scanner.nextLine();
        System.out.println("price : ");
        String price = DbConnection.scanner.nextLine();
        System.out.println("If no stock just leave it and press Enter");
        System.out.println("Stock : ");
        String stock = DbConnection.scanner.nextLine();
        DbConnection.query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+price+"','"+stock+"')";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product inserted successfully");

        Operation.getCommand();
    }
    public static void productCreateHelp() throws SQLException {
        System.out.println("create product using the following template\n" +
                ">> code, name, unit, type, price, stock\n" +
                "\t\n" +
                "\tcode - text, min - 2 - 6, mandatory\n" +
                "\tname - text, min 3 - 30 char, mandatory\n" +
                "\tunitCode - text, kg/l/piece/combo, mandatory\n" +
                "\ttype - text, between enumerated values, mandatory \n" +
                "\tprice - number, mandatory\n" +
                "\tstock - number, default 0");
        Operation.getCommand();
    }

    public static void listHelp() throws SQLException {
        System.out.println("List product with the following options\n" +
                "product list - will list all the products default to maximum upto 20 products\n" +
                "product list -p 10 - pageable list shows 10 products as default\n" +
                "product list -p 10 3 - pagable list shows 10 products in 3rd page, ie., product from 21 to 30\n" +
                "product list -s searchtext - search the product with the given search text in all the searchable attributes\n" +
                "product list -s <attr>: searchtext - search the product with the given search text in all the given attribute\n" +
                "product list -s <attr>: searchtext -p 10 6 - pagable list shows 10 products in 6th page with the given search text in the given attribute");
        Operation.getCommand();
    }

    public static void editHelp() throws SQLException {
        System.out.println(">> Edit product using following template. Copy the product data from the list, edit the attribute values. \n" +
                ">> id: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>\n" +
                "\n" +
                ">> You can also restrict the product data by editable attributes. Id attribute is mandatory for all the edit operation.\n" +
                ">> id: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>\n" +
                "\n" +
                ">> You can not give empty or null values to the mandatory attributes.\n" +
                ">> id: <id - 6>, name: , unitcode: null\n" +
                ">>\n" +
                " \n" +
                " \tid\t - number, mandatory\t\n" +
                "\tname - text, min 3 - 30 char, mandatory\n" +
                "\tunitcode - text, kg/l/piece/combo, mandatory\n" +
                "\ttype - text, between enumerated values, mandatory \n" +
                "\tcostprice - numeric, mandatory");
        Operation.getCommand();
    }

    public static void deleteHelp() throws SQLException {
        System.out.println(">> delete product using the following template\n" +
                "\t\n" +
                "\t\tproductid - numeric, existing\n" +
                ">> product delete -c <code>");
        Operation.getCommand();
    }

    public static void count() throws SQLException {
        System.out.println("Product count");
        DbConnection.query = "select * from products";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int count = 0;
        while(DbConnection.resultSet.next()){
            count+=1;
        }
        System.out.println("Total count of the product : " + count);
        Operation.getCommand();
    }

    public static void edit() throws SQLException {
        System.out.println("product edit");
        Operation.getCommand();
    }

    public static void delete(String code) throws SQLException {
        System.out.println("Are you sure want to delete the product ? y/n");
        String choice = DbConnection.scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")) {
            try {

                DbConnection.query = "delete from products where code = '" + code + "'";
                DbConnection.statement.execute(DbConnection.query);
                System.out.println("Product deleted successfully");
            } catch (Exception e) {
                System.out.println("product doesn't exist");
            }
        }


        Operation.getCommand();
    }

    public static void editWithAttributes() throws SQLException {
        System.out.println("product edit with attributes");
        Operation.getCommand();
    }

    public static void listWithTypes(String type) throws SQLException {
        System.out.println("product list with "+type+"");
        DbConnection.query = "select * from products where type = '"+type+"'";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);

        while(DbConnection.resultSet.next()){
            System.out.println(DbConnection.resultSet.getString("name"));
            System.out.println(DbConnection.resultSet.getString("type"));
        }
        Operation.getCommand();
    }
    public static void listWithTypesAndPaging(String type,String limitItems,String page) throws SQLException {
        System.out.println("product list with "+type+"");
        DbConnection.query = "select * from products where type = '"+type+"'";
        //product list -s type: chocolate -p 5 2
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int pageLimit = Integer.parseInt(limitItems);
        int pageNo = Integer.parseInt(page);
        int tempEndItemNo = pageLimit*pageNo;
        int tempInitialItemNo = tempEndItemNo-pageLimit;

        int tempItemsCount = 1;
        while(DbConnection.resultSet.next()){
            tempItemsCount +=1;

            if(tempItemsCount>tempInitialItemNo+1 && tempItemsCount<=tempEndItemNo+1 ){
                System.out.println(DbConnection.resultSet.getString("code")+"       "+DbConnection.resultSet.getString("name"));
            }


        }
        Operation.getCommand();
    }
}
