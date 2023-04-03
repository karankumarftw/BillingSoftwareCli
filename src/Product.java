
import javax.management.StandardEmitterMBean;
import java.sql.SQLException;

public class Product {
    public static void createWithAttributes(String code,String name,String unit,String type, String price) throws SQLException {
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2&&code.length()>7){
            System.out.println("code length should be within 2 to 6 characters");
            Operation.getCommand();
        }
        System.out.println(code.length()+"  "+name.length()+"   "+unit);
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }

        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(price);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }
        if(price.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }
//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//


        DbConnection.query = "insert into products(code,name,unit,type,price) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"')";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product inserted successfully");
        Operation.getCommand();
    }

    public static void createWithAttributes(String code,String name,String unit,String type, String price,String stock) throws SQLException {
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println("code length should be within 2 to 6 characters");
            Operation.getCommand();
        }
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }

        if(isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }
        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(price);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }
        if(price.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }
//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//
        DbConnection.query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"','"+stock+"')";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product inserted successfully");
        Operation.getCommand();
    }

    public static void create() throws SQLException {
       //-------------------------GETTING INPUTS FOR PRODUCT CREATION ----------------------------------------------//
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
        //------------------------- GETTING INPUTS FOR PRODUCT CREATION ENDS ----------------------------------------------//
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println("code length should be within 2 to 6 characters");
            Operation.getCommand();
        }
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }

        if(isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }
        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(price);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }
        if(price.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }

//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//

        DbConnection.query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"','"+stock+"')";
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

    public static void editWithAttributes(String code,String name,String unit,String type, String tempPrice,String tempStock) throws SQLException {
//------------------------------------------- VALIDATION -----------------------------------------------------------------------------//
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }
        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(tempPrice);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }
        if(tempPrice.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }



        float stock = Float.parseFloat(tempStock);
        //------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//
        DbConnection.query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+", stock = "+stock+" where code = "+code+" and ( code = "+code+")";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product edited successfully !!!");
        Operation.getCommand();
    }

    public static void editWithAttributes(String code,String name,String unit,String type, String tempPrice) throws SQLException {
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }

        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(tempPrice);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }
        if(tempPrice.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }

//-------------------------------------------VALIDATION ENDS-----------------------------------------------------------------------------//

        //update products set name = 'GoldWinner',unit = 'Packet',type='OIL',price = '34',stock='500' where code = '3';
        DbConnection.query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+" where code = "+code+" and ( code = "+code+")";
        DbConnection.statement.execute(DbConnection.query);
        System.out.println("Product edited successfully !!!");
        Operation.getCommand();
    }

    public static void listHelp() throws SQLException {
        System.out.println("\t\tList product with the following options\n" +
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
        System.out.println("Entered into product edit");
        System.out.print("code : ");
        String code = DbConnection.scanner.nextLine();
        System.out.print("name : ");
        String name = DbConnection.scanner.nextLine();
        System.out.print("unit : ");
        String unit = DbConnection.scanner.nextLine();
        System.out.print("type : ");
        String type = DbConnection.scanner.nextLine();
        System.out.print("price : ");
        String price = DbConnection.scanner.nextLine();
        System.out.print("If no stock just leave it and press Enter");
        System.out.print("Stock : ");
        String stock = DbConnection.scanner.nextLine();

        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(name.length()<3||name.length()>30){
            System.out.println("name length should be within 3 to 30 characters");
            Operation.getCommand();
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<DbConnection.unittypes.length;i++){
            System.out.println(i);
            if(DbConnection.unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println("The Unit value is not matching as per pre defined units");
            Operation.getCommand();
        }
        float parsingPrice = 0;
        try{
            parsingPrice = Float.parseFloat(price);
        }
        catch (Exception e){
            System.out.println("The price should be numeric");
        }

        if(price.length()<1){
            System.out.println("Price data cannot be null");
            Operation.getCommand();
        }
        //-------------------------------------------VALIDATION ENDS-----------------------------------------------------------------------------//
        if(stock.isEmpty()){
            DbConnection.query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+" where code = "+code+" and ( code = "+code+")";
            DbConnection.statement.execute(DbConnection.query);
        }else{
            DbConnection.query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+price+", stock = "+stock+" where code = "+code+" and ( code = "+code+")";
            DbConnection.statement.execute(DbConnection.query);
        }

        System.out.println("Product edited successfully");
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

    public static void listWithAttributes(String attribute,String searchText) throws SQLException {
        System.out.println("product list with "+searchText+"\nlist with attr");
        DbConnection.query = "select * from products where "+attribute+" = '"+searchText+"' order by code asc";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format(DbConnection.title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+DbConnection.reset);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while(DbConnection.resultSet.next()){
            String code =DbConnection.resultSet.getString("code");
            String name = DbConnection.resultSet.getString("name");
            String unit = DbConnection.resultSet.getString("unit");
            String type = DbConnection.resultSet.getString("type");
            String price = DbConnection.resultSet.getString("price");
            String stock = DbConnection.resultSet.getString("stock");
            System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));

        }
        Operation.getCommand();
    }

    public static void listWithAttributesAndPaging(String attribute,String searchText,String limitItems,String page) throws SQLException {
        System.out.println("product list with "+searchText+"\nlist with attr and paging");
        DbConnection.query = "select * from products where "+attribute+" = '"+searchText+"' order by code asc";
        //product list -s type: chocolate -p 5 2
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int pageLimit = Integer.parseInt(limitItems);
        int pageNo = Integer.parseInt(page);
        int tempEndItemNo = pageLimit*pageNo;
        int tempInitialItemNo = tempEndItemNo-pageLimit;

        int tempItemsCount = 1;
        System.out.println(String.format("%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK"));
        while(DbConnection.resultSet.next()){
            tempItemsCount +=1;
            String code =DbConnection.resultSet.getString("code");
            String name = DbConnection.resultSet.getString("name");
            String unit = DbConnection.resultSet.getString("unit");
            String type = DbConnection.resultSet.getString("type");
            String price = DbConnection.resultSet.getString("price");
            String stock = DbConnection.resultSet.getString("stock");

            if(tempItemsCount>tempInitialItemNo+1 && tempItemsCount<=tempEndItemNo+1 ){
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }


        }
        Operation.getCommand();
    }

    public static void listDefault() throws SQLException {
        DbConnection.query = "select * from products order by code asc";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int tempItemsCount = 1;
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        System.out.println(String.format(DbConnection.title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+DbConnection.reset);
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        while(DbConnection.resultSet.next()){
            if(tempItemsCount<=20){
                tempItemsCount+=1;
                String code =DbConnection.resultSet.getString("code");
                String name = DbConnection.resultSet.getString("name");
                String unit = DbConnection.resultSet.getString("unit");
                String type = DbConnection.resultSet.getString("type");
                String price = DbConnection.resultSet.getString("price");
                String stock = DbConnection.resultSet.getString("stock");
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }

        }
    }

    public static void listDefaultWithListCount(String defaultItemCount) throws SQLException {
        DbConnection.query = "select * from products order by code asc";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int tempItemsCount = 1;
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        System.out.println(String.format(DbConnection.title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+DbConnection.reset);
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        while(DbConnection.resultSet.next()){
            String code =DbConnection.resultSet.getString("code");
            String name = DbConnection.resultSet.getString("name");
            String unit = DbConnection.resultSet.getString("unit");
            String type = DbConnection.resultSet.getString("type");
            String price = DbConnection.resultSet.getString("price");
            String stock = DbConnection.resultSet.getString("stock");
            if(tempItemsCount<=Integer.parseInt(defaultItemCount)){
                tempItemsCount+=1;
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }

        }
    }

    public static void listDefaultWithListCountAndPageNo(String limitItems,String page) throws SQLException {
        DbConnection.query = "select * from products order by code asc";
        DbConnection.resultSet = DbConnection.statement.executeQuery(DbConnection.query);
        int pageLimit = Integer.parseInt(limitItems);
        int pageNo = Integer.parseInt(page);
        int tempEndItemNo = pageLimit*pageNo;
        int tempInitialItemNo = tempEndItemNo-pageLimit;
        int tempItemsCount = 1;
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        System.out.println(String.format(DbConnection.title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+DbConnection.reset);
        System.out.println(DbConnection.line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+DbConnection.reset);
        while(DbConnection.resultSet.next()){
            tempItemsCount +=1;
            String code =DbConnection.resultSet.getString("code");
            String name = DbConnection.resultSet.getString("name");
            String unit = DbConnection.resultSet.getString("unit");
            String type = DbConnection.resultSet.getString("type");
            String price = DbConnection.resultSet.getString("price");
            String stock = DbConnection.resultSet.getString("stock");
            if(tempItemsCount>tempInitialItemNo+1 && tempItemsCount<=tempEndItemNo+1 ){
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }
        }
    }

    public static void globalSearchList(){}
}
