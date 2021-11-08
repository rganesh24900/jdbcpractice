package com.company;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.Scanner;

class Vehicle {
    private int amount;
    private String name;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class VehiclesDao {
    Connection con = null;


    void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganesh", "root", "elclassico");

        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    void addVehicle(Vehicle v) {
        try {
            String query = "insert into jdbc1 values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, v.getName());
            pst.setInt(2, v.getAmount());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Main {


    public static void main(String[] args) {


        Vehicle v1 = new Vehicle();
        v1.setName("Car");
        v1.setAmount(500);
        Vehicle v2 = new Vehicle();
        v2.setAmount(200);
        v2.setName("Bike");
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
