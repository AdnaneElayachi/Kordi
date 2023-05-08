package com.example.kord.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kord.connexion.Connexion;

import com.example.kord.models.InformationUser;

import com.example.kord.repository.CRUD;

public class InfUserImplement implements CRUD<InformationUser> {
    @Override

    public List<InformationUser> getAll() {

        String req="select * from informationuser";
        List<InformationUser> Iformation=new ArrayList<InformationUser>();

        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
                Iformation.add(new InformationUser(rs.getInt("idInformationUser"),UserImpliment.getIDfk(rs.getInt("user")),
                        LocalizationImplement.getIDfk(rs.getInt("userLocalization")),rs.getLong("phoneNumber"),rs.getString("other_link"),
                        rs.getByte("images")));
            }

            return Iformation;

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Iformation;
    }



    @Override
    public InformationUser getById(int id) {
        String req = "SELECT * FROM informationuser WHERE idInformationUser = ?";
        InformationUser Iformation = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Iformation = new InformationUser(rs.getInt("idInformationUser"),UserImpliment.getIDfk(rs.getInt("user")),
                        LocalizationImplement.getIDfk(rs.getInt("userLocalization")),
                        rs.getLong("phoneNumber"),rs.getString("other_link"),rs.getByte("images"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Iformation;
    }

    @Override
    public boolean add(InformationUser variable) {
        String req="insert into informationuser values(null,?,?,?,?,?)";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setLong(1, variable.getUser().getId());
            ps.setLong(2, variable.getUserLocalization().getId());
            ps.setDouble(3, variable.getPhoneNumber());
            ps.setString(4, variable.getOther_link());
            ps.setByte(5, variable.getImages());
            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {


            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(InformationUser variable) {
        String req="update informationuser set user=?,userLocalization=?,phoneNumber=?,other_link=?,images=? where idLocalization = ? ";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setLong(1, variable.getUser().getId());
            ps.setLong(2, variable.getUserLocalization().getId());
            ps.setDouble(3, variable.getPhoneNumber());
            ps.setString(4, variable.getOther_link());
            ps.setByte(5, variable.getImages());
            ps.setLong(6, variable.getId());
            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {


            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(InformationUser variable) {
        String req="delete from informationuser where idLocalization  =?";
        try {
            PreparedStatement ps=Connexion.getCon().prepareStatement(req);
            ps.setLong(1, variable.getId());


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
