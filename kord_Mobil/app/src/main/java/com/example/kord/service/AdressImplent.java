package com.example.kord.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kord.connexion.Connexion;
import com.example.kord.models.Address;

import com.example.kord.repository.CRUD;

public class AdressImplent implements CRUD<Address> {
    List<Address> Addresses=new ArrayList<Address>();
    @Override
    public List<Address> getAll() {
        String req="select * from address";
        List<Address> address=new ArrayList<Address>();

        try {
            PreparedStatement ps=Connexion.getCon().prepareStatement(req);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
                address.add(new Address(rs.getInt("idaddress"),rs.getString("rue"),rs.getString("city"),rs.getString("state"),rs.getString("postal_code")));
            }
            return address;

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public  Address getById(int id) {
        String req = "SELECT * FROM address WHERE idaddress = ?";
        Address address = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                address = new Address(rs.getInt("idaddress"), rs.getString("rue"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }


    public static Address getIDfk(int id) {
        String req = "SELECT * FROM address WHERE idaddress = ?";
        Address address = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                address = new Address(rs.getInt("idaddress"), rs.getString("rue"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public boolean add(Address variable) {
        String req="insert into address values(null,?,?,?,?)";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setString(1,variable.getrue());
            ps.setString(2,variable.getCity());
            ps.setString(3,variable.getState());
            ps.setString(4,variable.getPostal_code());



            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Address variable) {
        String req="update address set rue=?,city=?,stat=?,postal_code=?  where idaddress = ?  ";

        try {
            PreparedStatement ps=Connexion.getCon().prepareStatement(req);

            if(ps.executeUpdate()==1) {

                ps.setString(1,variable.getrue());
                ps.setString(2,variable.getCity());
                ps.setString(3,variable.getState());
                ps.setString(4,variable.getPostal_code());
                ps.setInt(5,variable.getId());

                return true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Address variable) {
        String req="delete from address where idaddress  =?";
        try {
            PreparedStatement ps=Connexion.getCon().prepareStatement(req);
            ps.setLong(1,variable.getId());


            if(ps.executeUpdate()==1) {
                return true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }
}
