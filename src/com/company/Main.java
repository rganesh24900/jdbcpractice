package com.company;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.Scanner;

class Vehicle {
    int amount;
    String name;




}




class VehiclesDao {
    Connection con = null;


    void connection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganesh", "root", "elclassico");

    }


    void addVehicle(Vehicle v) throws SQLException {
        String query = "insert into jdbc1 values(?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, v.name);
        pst.setInt(2, v.amount);
        pst.executeUpdate();
    }


}

class Main {


    public static void main(String[] args) throws Exception {

//JBBC STATEMENTs

        Vehicle v1 = new Vehicle();
        v1.name="Car";
        v1.amount=500;
        Vehicle v2 = new Vehicle();
        v2.amount=200;
        v2.name="Bike";
        VehiclesDao dao = new VehiclesDao();
        dao.connection();


        int i = 0;
        while (i <= 10) {
            System.out.println("Do you want to repair Bike or Car?,if Bike press \"1\" and for Car press \"2\"... :");
            Scanner sc = new Scanner(System.in);
            int vehicle = sc.nextInt();
            switch (vehicle) {
                case 1:
                    dao.addVehicle(v2);

                    System.out.println("Bike is added for repairing");
                    break;

                case 2:

                    dao.addVehicle(v1);
                    System.out.println("Car is added for repairing");

            }
            i++;
        }


    }
}
