package Modules;

import java.sql.SQLException;

import static Core.DbConnectionScannerAndFormatting.*;

public class Product{
    public static void productCreateWithAttributes(String code,String name,String unit,String type, String price) throws SQLException {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPRODUCT CREATION"+reset);
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println(error+"\nTemplate mismatch (code length should be within 2 to 6 characters)"+reset);
            return;
        }

        if(name.length()<3||name.length()>30){
            System.out.println(error+"\nTemplate mismatch ( Name length should be within 3 to 30 characters)"+reset);
            return;
        }
        query = "select * from unit where unit_name ='"+unit+"' ";
        resultSet = statement.executeQuery(query);
        if(resultSet.next()){
            float parsingPrice = 0;
            try{
                parsingPrice = Float.parseFloat(price);
            }
            catch (Exception e){
                System.out.println(error+"\nTemplate mismatch ( The price should be numeric )"+reset);
            }
            if(price.length()<1){
                System.out.println(error+"\nTemplate mismatch ( Price data cannot be null) "+reset);
                return;
            }
//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//

            query = "insert into products(code,name,unit,type,price) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"')";
            statement.execute(query);
            System.out.println("Product inserted successfully");
        }
        else {
            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre defined units )"+reset);
        }
//        boolean isUnitIsThere = false;
//        for (String unittype : unittypes) {
//
//            if (unittype.equals(unit)) {
//                isUnitIsThere = true;
//                break;
//            }
//        }
//        if(!isUnitIsThere){
//            System.out.println(error+"\nTemplate mismatch ( The Unit value is not matching as per pre defined units)"+reset);
//            return;
//        }





    }

    public static void productCreateWithAttributes(String code,String name,String unit,String type, String price,String stock) throws SQLException {

        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPRODUCT CREATION"+reset);
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println(error+"\nTemplate mismatch ( code length should be within 2 to 6 characters )"+reset);
            return;
        }

        if(name.length()<3||name.length()>30){
            System.out.println(error+"\nTemplate mismatch ( Name length should be within 3 to 30 characters )"+reset);
            return;
        }
        query = "select * from unit where unit_name ='"+unit+"' ";
        resultSet = statement.executeQuery(query);
        if(resultSet.next()){
            float parsingPrice = 0;
            try{
                parsingPrice = Float.parseFloat(price);
            }
            catch (Exception e){
                System.out.println(error+"\nTemplate mismatch ( The price should be numeric )"+reset);
            }
            if(price.length()<1){
                System.out.println(error+"\nTemplate mismatch ( Price data cannot be null )"+reset);
                return;
            }
//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//
            query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"','"+stock+"')";
            statement.execute(query);
            System.out.println("Product inserted successfully");
        }
        else {
            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre defined units )"+reset);
        }
//        boolean isUnitIsThere = false;
//        for (String unittype : unittypes) {
//
//            if (unittype.equals(unit)) {
//                isUnitIsThere = true;
//                break;
//            }
//        }
//        if(!isUnitIsThere){
//            System.out.println(error+"\nTemplate mismatch ( The Unit value is not matching as per pre defined units )"+reset);
//            return;
//        }




    }

    public static void productCreate() throws SQLException {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPRODUCT CREATION"+reset);
       //-------------------------GETTING INPUTS FOR PRODUCT CREATION ----------------------------------------------//
        System.out.print("code : ");
        String code = scanner.nextLine();
        System.out.println("name : ");
        String name = scanner.nextLine();
        System.out.print("unit : ");
        String unit = scanner.nextLine();
        System.out.print("type : ");
        String type = scanner.nextLine();
        System.out.print("price : ");
        String price = scanner.nextLine();
        System.out.print("If no stock just leave it and press Enter");
        System.out.print("Stock : ");
        String stock = scanner.nextLine();
        //------------------------- GETTING INPUTS FOR PRODUCT CREATION ENDS ----------------------------------------------//
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println(error+" \nTemplate mismatch (code length should be within 2 to 6 characters )"+reset);
            return;
        }

        if(name.length()<3||name.length()>30){
            System.out.println(error+"\nTemplate mismatch ( Name length should be within 3 to 30 characters )"+reset);
            return;
        }

        query = "select * from unit where unit_name ='"+unit+"' ";
        resultSet = statement.executeQuery(query);
        if(resultSet.next()){
            float parsingPrice;
            try{
                parsingPrice = Float.parseFloat(price);
            }
            catch (Exception e){
                System.out.println(error+"\nTemplate mismatch ( The price should be numeric )"+reset);
                return;
            }
            if(price.length()<1){
                System.out.println(error+"\nTemplate mismatch ( Price data cannot be null )"+reset);
                return;
            }

//------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//

            query = "insert into products(code,name,unit,type,price,stock) values ('"+code+"','"+name+"','"+unit+"','"+type+"','"+parsingPrice+"','"+stock+"')";
            statement.execute(query);
            System.out.println("Product inserted successfully");
        }
        else {
            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre defined units )"+reset);
        }
//        boolean isUnitIsThere = false;
//        for (String unittype : unittypes) {
//
//            if (unittype.equals(unit)) {
//                isUnitIsThere = true;
//                break;
//            }
//        }
//        if(!isUnitIsThere){
//            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre-defined units )"+reset);
//            return;
//        }


    }

    public static void productCreateHelp() {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPRODUCT CREATION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("""
                create product using the following template
                code, name, unit, type, price, stock
                code - text, min - 2 - 6, mandatory
                name - text, min 3 - 30 char, mandatory
                unitCode - text, kg/l/piece/combo, mandatory
                type - text, between enumerated values, mandatory\s
                price - number, mandatory
                stock - number, default 0""");
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }

    public static void productEditWithAttributes(String code,String name,String unit,String type, String tempPrice,String tempStock) throws SQLException {
//------------------------------------------- VALIDATION -----------------------------------------------------------------------------//
        if(code.length()<2||code.length()>7){
            System.out.println(error+" \nTemplate mismatch ( code length should be within 2 to 6 characters )"+reset);
            return;
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<unittypes.length;i++){
            System.out.println(i);
            if(unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre defined units )"+reset);
            return;
        }
        float parsingPrice;
        try{
            parsingPrice = Float.parseFloat(tempPrice);
        }
        catch (Exception e){
            System.out.println(error+"\nTemplate mismatch ( The price should be numeric )"+reset);
            return;
        }
        if(tempPrice.length()<1){
            System.out.println(error+"\nTemplate mismatch ( Price data cannot be null )"+reset);
            return;
        }



        float stock = Float.parseFloat(tempStock);
        //------------------------------------------- VALIDATION ENDS -----------------------------------------------------------------------------//
        query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+", stock = "+stock+" where code = "+code+" and ( code = "+code+")";
        statement.execute(query);
        System.out.println("Modules.Product edited successfully !!!");
    }

    public static void productEditWithAttributes(String code,String name,String unit,String type, String tempPrice) throws SQLException {
        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(name.length()<3||name.length()>30){
            System.out.println(error+"\nTemplate mismatch ( name length should be within 3 to 30 characters )"+reset);
            return;
        }
        boolean isUnitIsThere = false;
        for(int i = 0;i<unittypes.length;i++){
            System.out.println(i);
            if(unittypes[i].equals(unit)){
                isUnitIsThere = true;
            }
        }
        if(!isUnitIsThere){
            System.out.println(error+"\nTemplate mismatch ( The Unit value is not matching as per pre defined units )"+reset);
            return;
        }

        float parsingPrice;
        try{
            parsingPrice = Float.parseFloat(tempPrice);
        }
        catch (Exception e){
            System.out.println(error+"\nTemplate mismatch ( The price should be numeric )"+reset);
            return;
        }
        if(tempPrice.length()<1){
            System.out.println(error+"\nTemplate mismatch ( Price data cannot be null )"+reset);
            return;
        }

//-------------------------------------------VALIDATION ENDS-----------------------------------------------------------------------------//


        query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+" where code = "+code+" and ( code = "+code+")";
        statement.execute(query);
        System.out.println(successful+"Modules.Product edited successfully !!!"+reset);


    }

    public static void productListHelp() {
        System.out.println("""
                \t\tList product with the following options
                product list - will list all the products default to maximum upto 20 products
                product list -p 10 - pageable list shows 10 products as default
                product list -p 10 3 - pagable list shows 10 products in 3rd page, ie., product from 21 to 30
                product list -s searchtext - search the product with the given search text in all the searchable attributes
                product list -s <attr>: searchtext - search the product with the given search text in all the given attribute
                product list -s <attr>: searchtext -p 10 6 - pagable list shows 10 products in 6th page with the given search text in the given attribute""");

    }

    public static void productEditHelp() {
        System.out.println("""
                Edit product using following template. Copy the product data from the list, edit the attribute values.\s
                id: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>

                You can also restrict the product data by editable attributes. Id attribute is mandatory for all the edit operation.
                id: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>

                You can not give empty or null values to the mandatory attributes.
                id: <id - 6>, name: , unitcode: null
                
                
                id - number, mandatory
                name - text, min 3 - 30 char, mandatory
                unitcode - text, kg/l/piece/combo, mandatory
                type - text, between enumerated values, mandatory
                costprice - numeric, mandatory""");

    }

    public static void productDeleteHelp() {
        System.out.println("""
                delete product using the following template
                productid - numeric, existing
                product delete -c <code>""");

    }

    public static void productCount() throws SQLException {

        query = "select * from products";
        resultSet = statement.executeQuery(query);
        int count = 0;
        while(resultSet.next()){
            count+=1;
        }
        System.out.println("Total count of the product : " + count);


    }

    public static void productEdit() throws SQLException {
        System.out.println("Entered into product edit");
        System.out.print("code : ");
        String code = scanner.nextLine();
        System.out.print("name : ");
        String name = scanner.nextLine();
        System.out.print("unit : ");
        String unit = scanner.nextLine();
        System.out.print("type : ");
        String type = scanner.nextLine();
        System.out.print("price : ");
        String price = scanner.nextLine();
        System.out.print("If no stock just leave it and press Enter");
        System.out.print("Stock : ");
        String stock = scanner.nextLine();

        //-------------------------------------------VALIDATION-----------------------------------------------------------------------------//
        if(name.length()<3||name.length()>30){
            System.out.println(error+"\nTemplate mismatch ( Name length should be within 3 to 30 characters)"+reset);
            return;
        }
        boolean isUnitIsThere = false;
        for (String unittype : unittypes) {

            if (unittype.equals(unit)) {
                isUnitIsThere = true;
                break;
            }
        }
        if(!isUnitIsThere){
            System.out.println(error+"Template mismatch ( The Unit value is not matching as per pre defined units)"+reset);
            return;
        }

        float parsingPrice;
        try{
            parsingPrice = Float.parseFloat(price);
        }
        catch (Exception e){
            System.out.println(error+"\nTemplate mismatch ( The price should be numeric)"+reset);
            return;
        }
        if(price.length()<1){
            System.out.println(error+"\nTemplate mismatch ( Price data cannot be null)"+reset);
            return;
        }
        //-------------------------------------------VALIDATION ENDS-----------------------------------------------------------------------------//
        if(stock.isEmpty()){
            query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+parsingPrice+" where code = "+code+" and ( code = "+code+")";
            statement.execute(query);
        }else{
            query = "update products set name = '"+name+"', unit = '"+unit+"', type = '"+type+"', price = "+price+", stock = "+stock+" where code = "+code+" and ( code = "+code+")";
            statement.execute(query);
        }

        System.out.println(successful+"Modules.Product edited successfully"+reset);


    }

    public static void productDelete(String code) throws SQLException {
        System.out.println("Are you sure want to delete the product ? y/n");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")) {
            query = "select * from products where code = "+code;
            resultSet = statement.executeQuery(query);
            int resultCount = 0;
            while(resultSet.next()){
                resultCount+=1;
            }
            if(resultCount<1){
                System.out.println(error+"\nproduct doesn't exist"+reset);
            }else {
                query = "delete from products where code = '" + code + "'";
                statement.execute(query);
                System.out.println(successful+"Modules.Product deleted successfully"+reset);
            }

        }


    }

    public static void productListWithAttributes(String attribute,String searchText) throws SQLException {
        System.out.println("product list with "+searchText+"\nlist with attr");
        
        query = "select * from products where "+attribute+" = '"+searchText+"' order by code asc";
        resultSet = statement.executeQuery(query);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format(title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+reset);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while(resultSet.next()){
            String code =resultSet.getString("code");
            String name = resultSet.getString("name");
            String unit = resultSet.getString("unit");
            String type = resultSet.getString("type");
            String price = resultSet.getString("price");
            String stock = resultSet.getString("stock");
            System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
        }
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);


    }

    public static void productListWithAttributesAndPaging(String attribute,String searchText,String limitItems,String page) throws SQLException {
        System.out.println("product list with "+searchText+"\nlist with attr and paging");
        query = "select * from products where "+attribute+" = '"+searchText+"' order by code asc";
        //product list -s type: chocolate -p 5 2
        resultSet = statement.executeQuery(query);
        int pageLimit = Integer.parseInt(limitItems);
        int pageNo = Integer.parseInt(page);
        int tempEndItemNo = pageLimit*pageNo;
        int tempInitialItemNo = tempEndItemNo-pageLimit;
        int isTableColumnEnabled = 0;
        int tempItemsCount = 1;
        System.out.println(String.format("%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK"));
        while(resultSet.next()){
            tempItemsCount +=1;
            String code =resultSet.getString("code");
            String name = resultSet.getString("name");
            String unit = resultSet.getString("unit");
            String type = resultSet.getString("type");
            String price = resultSet.getString("price");
            String stock = resultSet.getString("stock");

            if(tempItemsCount>tempInitialItemNo+1 && tempItemsCount<=tempEndItemNo+1 ){
                isTableColumnEnabled +=1;
                if(isTableColumnEnabled==1){
                    System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                    System.out.println(String.format(title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+reset);
                    System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                }
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }

        }

        if(isTableColumnEnabled==1){
            System.out.println(error+"WARNING : Requested page doesn't exist !"+reset);
        }

    }

    public static void productListDefault() throws SQLException {
        query = "select * from products  order by code asc limit 20";
        resultSet = statement.executeQuery(query);

        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println(String.format(title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        while(resultSet.next()){
                String code =resultSet.getString("code");
                String name = resultSet.getString("name");
                String unit = resultSet.getString("unit");
                String type = resultSet.getString("type");
                String price = resultSet.getString("price");
                String stock = resultSet.getString("stock");
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }

        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);


    }

    public static void productListDefaultWithListCount(String defaultItemCount) throws SQLException {
        query = "select * from products order by code asc limit "+defaultItemCount;
        resultSet = statement.executeQuery(query);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println(String.format(title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        while(resultSet.next()){
            String code =resultSet.getString("code");
            String name = resultSet.getString("name");
            String unit = resultSet.getString("unit");
            String type = resultSet.getString("type");
            String price = resultSet.getString("price");
            String stock = resultSet.getString("stock");
            System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
        }
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }

    public static void productListDefaultWithListCountAndPageNo(String limitItems,String page) throws SQLException {
        query = "select * from products order by code asc";
        resultSet = statement.executeQuery(query);
        int pageLimit = Integer.parseInt(limitItems);
        int pageNo = Integer.parseInt(page);
        int tempEndItemNo = pageLimit*pageNo;
        int tempInitialItemNo = tempEndItemNo-pageLimit;
        int tempItemsCount = 1;
        int isTableColumnEnabled = 0;
        while(resultSet.next()){
            tempItemsCount +=1;
            String code =resultSet.getString("code");
            String name = resultSet.getString("name");
            String unit = resultSet.getString("unit");
            String type = resultSet.getString("type");
            String price = resultSet.getString("price");
            String stock = resultSet.getString("stock");
            if(tempItemsCount>tempInitialItemNo+1 && tempItemsCount<=tempEndItemNo+1 ){
                isTableColumnEnabled +=1;
                if(isTableColumnEnabled==1){
                    System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                    System.out.println(String.format(title+"%20s","CODE")+String.format("%20s","NAME")+String.format("%20s","UNIT")+String.format("%20s","TYPE")+String.format("%20s","PRICE")+String.format("%20s","STOCK")+reset);
                    System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                }
                System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
            }
        }
        if(isTableColumnEnabled==0){
            System.out.println(error+"WARNING : Requested page doesn't exist !"+reset);
        }
    }

    public static void productGlobalSearchList(String keyword) throws SQLException {
        //System.out.println("Did you searched for this ? "+keyword);
        String[] tableColumnsHasStringType = {"name","unit","type"};
        String[] tableColumnsHasNumericType = {"code","price","stock"};
        int tempCode = 0;
        int tempName = 0;
        int tempUnit = 0;
        int tempType = 0;
        int tempPrice = 0;
        int tempStock = 0;
        final String tableTitle = String.format(title + "%20s", "CODE") + String.format("%20s", "NAME") + String.format("%20s", "UNIT") + String.format("%20s", "TYPE") + String.format("%20s", "PRICE") + String.format("%20s", "STOCK") + reset;
        try{

            Float.parseFloat(keyword);
            float parsingPrice;

            for(String columnName : tableColumnsHasNumericType){

                query = "select * from products where "+columnName+" = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    if(columnName.equals("code")){
                        tempCode+=1;
                    } else if (columnName.equals("price")) {
                        tempPrice+=1;
                    }else{
                        tempStock+=1;
                    }
                }
            }
            System.out.println("Found "+tempCode+" in code column");
            System.out.println("Found "+tempName+" in name column");
            System.out.println("Found "+tempUnit+" in unit column");
            System.out.println("Found "+tempType+" in type column");
            System.out.println("Found "+tempPrice+" in price column");
            System.out.println("Found "+tempStock+" in stock column");
            if(tempCode>0){
                System.out.println(line+"Results in : code "+reset);
                query = "select * from products where code = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    parsingPrice = Float.parseFloat(resultSet.getString("price"));
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",parsingPrice)+String.format("%20s",stock));
                }

                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }
            if(tempPrice>0){
                System.out.println(line+"Results in : price "+reset);
                query = "select * from products where price = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    parsingPrice = Float.parseFloat(resultSet.getString("price"));
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",parsingPrice)+String.format("%20s",stock));
                }
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }
            if(tempStock>0){
                System.out.println(line+"Results in : stock "+reset);
                query = "select * from products where stock = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    parsingPrice = Float.parseFloat(resultSet.getString("price"));
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",parsingPrice)+String.format("%20s",stock));
                }
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }
        }
        catch (Exception e){
            for(String columnName : tableColumnsHasStringType){

                query = "select * from products where "+columnName+" = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    if(columnName.equals("name")){
                        tempName+=1;
                    } else if (columnName.equals("unit")) {
                        tempUnit+=1;
                    }else{
                        tempType+=1;
                    }
                }
            }

            System.out.println("Found "+tempCode+" in code column");
            System.out.println("Found "+tempName+" in name column");
            System.out.println("Found "+tempUnit+" in unit column");
            System.out.println("Found "+tempType+" in type column");
            System.out.println("Found "+tempPrice+" in price column");
            System.out.println("Found "+tempStock+" in stock column");

            if(tempName>0){
                System.out.println(line+"Results in : name "+reset);
                query = "select * from products where name = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    String price = resultSet.getString("price");
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
                }
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }
            if(tempUnit>0){
                System.out.println(line+"Results in : unit "+reset);
                query = "select * from products where unit = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    String price = resultSet.getString("price");
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
                }
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }

            if(tempType>0){
                System.out.println(line+"Results in : type "+reset);
                query = "select * from products where type = '"+keyword+"' order by code asc";
                resultSet = statement.executeQuery(query);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                System.out.println(tableTitle);
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
                while(resultSet.next()){
                    String code =resultSet.getString("code");
                    String name = resultSet.getString("name");
                    String unit = resultSet.getString("unit");
                    String type = resultSet.getString("type");
                    String price = resultSet.getString("price");
                    String stock = resultSet.getString("stock");
                    System.out.println(String.format("%20s",code)+String.format("%20s",name)+String.format("%20s",unit)+String.format("%20s",type)+String.format("%20s",price)+String.format("%20s",stock));
                }
                System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
            }

        }

    }
}
