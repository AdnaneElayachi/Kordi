package com.example.kord.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kord.connexion.Connexion;
import com.example.kord.models.Address;
import com.example.kord.models.Users;
import com.example.kord.repository.CRUD;

public class UserImpliment implements CRUD<Users> {
    @Override
    public List<Users> getAll() {

        String req="select * from users";
        List<Users> users=new ArrayList<Users>();

        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
                users.add(new Users(rs.getInt("idUsers"),rs.getString("name"),rs.getString("lastName"),rs.getString("emailUsers"),rs.getString("passwordUsers")));
            }
            return users;

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Users getById(int id) {
        String req = "SELECT * FROM users WHERE idUsers = ?";
        Users users = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                users=new Users(rs.getInt("idUsers"),rs.getString("name"),rs.getString("lastName"),rs.getString("emailUsers"),rs.getString("passwordUsers"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    public static  Users getIDfk(int id) {
        String req = "SELECT * FROM users WHERE idUsers = ?";
        Users users = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                users=new Users(rs.getInt("idUsers"),rs.getString("name"),rs.getString("lastName"),rs.getString("emailUsers"),rs.getString("passwordUsers"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean add(Users variable) {

        String req="insert into users values(null,?,?,?,?)";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setString(1,variable.getLastName());
            ps.setString(2,variable.getLastName());
            ps.setString(3,variable.getEmailUsers());
            ps.setString(4,variable.getPaswordUsers());



            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {

           
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Users variable) {
        String req="update users set name=?,lastName=?,emailUsers=?,passwordUsers=?  where idUsers=?  ";

        try {
            PreparedStatement ps=Connexion.getCon().prepareStatement(req);

            if(ps.executeUpdate()==1) {

                ps.setString(1,variable.getLastName());
                ps.setString(2,variable.getLastName());
                ps.setString(3,variable.getEmailUsers());
                ps.setString(4,variable.getPaswordUsers());
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
    public boolean delete(Users variable) {
        String req="delete from users where idUsers  = ?";
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
