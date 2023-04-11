package Modules;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static Core.DbConnectionScannerAndFormatting.*;
public class Unit {
    public static void unitCreateHelp() {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT CREATION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("""
                Create unit using the following template,
                name, code, description, is-dividable
                name - text, mandatory with 3 to 30 chars
                code - text, maximum 4 char, mandatory
                description - text
                is-dividable - boolean, mandatory""");
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitCreate() throws SQLException {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT CREATION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("Enter unit name : ");
        String unitName = scanner.nextLine();
        System.out.println("Enter unit code : ");
        String  unitCode = scanner.nextLine();
        System.out.println("Enter description : ");
        String unitDescription = scanner.nextLine();
        System.out.println("is Dividable : (yes/No)");
        String isDividableCheck = scanner.nextLine().toLowerCase();
        boolean isDividable;
        if(isDividableCheck.equals("true")||isDividableCheck.equals("yes")) {
            isDividable = true;
        } else if (isDividableCheck.equals("false")||isDividableCheck.equals("no")) {
            isDividable = false;
        }
        else {
            System.out.println(error+"Template mismatch ( is dividable either should be true/false or yes/no )"+reset);
            return;
        }
        query = "insert into unit(unit_name,unit_code,unit_description,unit_is_dividable) values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,unitName);
        ps.setString(2,unitCode);
        ps.setString(3,unitDescription);
        ps.setBoolean(4,isDividable);
        ps.execute();
        System.out.println(successful+"Unit inserted successfully"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitCreateWithAttributes(String unitName, String unitCode , String unitDescription,String isDividableCheck) throws SQLException {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT CREATION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        boolean isDividable;
        if(isDividableCheck.equals("true")||isDividableCheck.equals("yes")) {
            isDividable = true;
        } else if (isDividableCheck.equals("false")||isDividableCheck.equals("no")) {
            isDividable = false;
        }
        else {
            System.out.println(error+"Template mismatch ( is dividable either should be true/false or yes/no )"+reset);
            return;
        }
        query = "insert into unit(unit_name,unit_code,unit_description,unit_is_dividable) values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,unitName);
        ps.setString(2,unitCode);
        ps.setString(3,unitDescription);
        ps.setBoolean(4,isDividable);
        ps.execute();
        System.out.println(successful+"Unit inserted successfully"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);

    }
    public static void unitListHelp(){
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT LISTING"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("List unit with the following options\n" +
                "unit list - will list all the units");
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitList() throws SQLException {
        query = "select * from unit";
        resultSet = statement.executeQuery(query);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println(String.format(title+"%20s","UNIT NAME")+String.format("%20s","UNIT CODE")+String.format("%20s","DESCRIPTION")+String.format("%20s","IS DIVIDABLE")+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        while(resultSet.next()){
            String unitName = resultSet.getString("unit_name");
            String unitCode =  resultSet.getString("unit_code");
            String unitDescription = resultSet.getString("unit_description");
            boolean isDividable = resultSet.getBoolean("unit_is_dividable");
            System.out.println(String.format("%20s",unitName)+String.format("%20s",unitCode)+String.format("%20s",unitDescription)+String.format("%20s",isDividable));
        }
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitDeleteHelp(){
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT DELETION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("""
                delete unit using the following template
                code
                code - text, min 3 - 30 char, mandatory,existing""");
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitDelete(String unitCode) throws SQLException {
        System.out.println("Are you sure want to delete the product ? y/n");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")|| choice.equalsIgnoreCase("y")) {
            query = "select * from unit where unit_code = '"+unitCode+"'";
            resultSet = statement.executeQuery(query);
            int resultCount = 0;
            while(resultSet.next()){
                resultCount+=1;
            }
            if(resultCount<1){
                System.out.println(error+"unit doesn't exist"+reset);
            }else {
                query = "delete from unit where unit_code = '" + unitCode + "'";
                statement.execute(query);
                System.out.println(successful+"Unit deleted successfully"+reset);
            }

        }
    }
    public static void unitEditHelp(){
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT EDITING"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("""
                Edit unit using the following template
                id: <id - 6>, name: <name-edited>, code: <code>,  description: <description>, is-dividable: <is-dividable>

                You can also restrict the user data by editable attributes. Id attribute is mandatory for all the edit operation.
                id: <id - 6>, name: <name>, code: <code>

                You can not give empty or null values to the mandatory attributes.
                id: <id - 6>, name: , code: null

                name - text, mandatory with 3 to 30 chars
                code - text, maximum 4 char, mandatory
                description - text
                is-dividable - boolean, mandatory""");
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitEdit() throws SQLException {
        System.out.println(line+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUNIT CREATION"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
        System.out.println("Enter unit code : ");
        String  unitCode = scanner.nextLine();
        System.out.println("Enter unit name : ");
        String unitName = scanner.nextLine();
        System.out.println("Enter description : ");
        String unitDescription = scanner.nextLine();
        System.out.println("is Dividable : (yes/No)");
        String isDividableCheck = scanner.nextLine().toLowerCase();
        boolean isDividable;
        if(isDividableCheck.equals("true")||isDividableCheck.equals("yes")) {
            isDividable = true;
        } else if (isDividableCheck.equals("false")||isDividableCheck.equals("no")) {
            isDividable = false;
        }
        else {
            System.out.println(error+"Template mismatch ( is dividable either should be true/false or yes/no )"+reset);
            return;
        }
        query = "update unit set unit_name = ?,unit_description = ?,unit_is_dividable = ? where unit_code = ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,unitName);
        ps.setString(2,unitDescription);
        ps.setBoolean(3,isDividable);
        ps.setString(4, unitCode);
        ps.execute();
        System.out.println(successful+"Unit edited successfully"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
    public static void unitEditWithAttributes(String unitName, String unitCode , String unitDescription,String isDividableCheck) throws SQLException {
        boolean isDividable;
        if(isDividableCheck.equals("true")||isDividableCheck.equals("yes")) {
            isDividable = true;
        } else if (isDividableCheck.equals("false")||isDividableCheck.equals("no")) {
            isDividable = false;
        }
        else {
            System.out.println(error+"Template mismatch ( is dividable either should be true/false or yes/no )"+reset);
            return;
        }
        query = "update unit set unit_name = ?,unit_description = ?,unit_is_dividable = ? where unit_code = ? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,unitName);
        ps.setString(2,unitDescription);
        ps.setBoolean(3,isDividable);
        ps.setString(4, unitCode);
        ps.execute();
        System.out.println(successful+"Unit edited successfully"+reset);
        System.out.println(line+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+reset);
    }
}
