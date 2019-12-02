import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/vehicle?useUnicode=true" + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "s3m1n@r1";
    private static Connection connection;

    public static void main(String[]args) throws Exception {
        connection = getDBConnection();
        String plateNumber = getInput();
        //selectPlates();
        closeDBConnection();
    }
    private static Connection getDBConnection() throws Exception {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }
    private static void closeDBConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private static String getInput(){

        System.out.println("Enter Plate Number (ABC-1234) Format to Insert");
        String plate = checkPlate.nextLine();
        char[] p = new char[plate.length()];
        do{
            System.out.println("Please Enter the plate number in the correct format");
            Scanner checkPlate = new Scanner(System.in);
            String plate = checkPlate.nextLine();
            char[] p = new char[plate.length()];
        }while (!(p.length==8 && p[3]=='-' && (Character.isLetter(p[0])&&Character.isLetter(p[1]) && Character.isLetter(p[2])) &&(Character.isDigit(p[4]) && Character.isDigit(p[5]) && Character.isDigit(p[6]) && Character.isDigit(p[7]))))
        //while (){
        //    System.out.println("Please put the plate in the correct format");
        //};  // Read user input
        System.out.println("Plate number is: " + plate);  // Output user input
        return plate;
    }

    public static void selectPlates() throws SQLException {
        String selectSQL = "select * " + "from vehicle_contact " + "group by plate,expDate ";
        ResultSet result = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            result = preparedStatement.executeQuery();
            System.out.println("Result: ");
            while (result.next()) {
                String plate = result.getString("plate");
                Date expDate = result.getDate("expDate");
                System.out.println(plate + " " + expDate);
            }
        } finally {
            if (result != null) {
                result.close();
            }
        }
    }

    public static void insertPlate() throws SQLException{
        String insertTableSQL = "insert into vehicle_contacts \"\n" +
                " + \"(plate,expDate) values \"\n" +
                " + \"(?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL)) {
        String inp = getInput();

    }catch (Exception e){

    }
    }


}
