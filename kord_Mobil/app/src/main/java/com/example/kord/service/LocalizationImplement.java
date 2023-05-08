package com.example.kord.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kord.connexion.Connexion;
import com.example.kord.models.Address;
import com.example.kord.models.Localization;
import com.example.kord.repository.CRUD;


public class LocalizationImplement implements CRUD<Localization> {
    @Override

    public List<Localization> getAll() {
        String req="select * from localization";
        List<Localization> localization=new ArrayList<Localization>();

        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
                localization.add(new Localization(rs.getInt("idLocalization"),AdressImplent.getIDfk(rs.getInt("address"))));
            }
            return localization;

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return localization;
    }


    @Override
    public Localization getById(int id) {
        String req = "SELECT * FROM localization WHERE idLocalization = ?";
        Localization localization = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                localization = new Localization(rs.getInt("idLocalization"),AdressImplent.getIDfk(rs.getInt("address")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localization;
    }

    public static  Localization getIDfk(int id) {
        String req = "SELECT * FROM localization WHERE idLocalization = ?";
        Localization localization = null;

        try {
            PreparedStatement ps = Connexion.getCon().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                localization = new Localization(rs.getInt("idLocalization"),AdressImplent.getIDfk(rs.getInt("address")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return localization;
    }

    @Override
    public boolean add(Localization variable) {
        String req="insert into localization values(null,?)";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setLong(1, variable.getAddress().getId());

            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {


            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Localization variable) {
        String req="update localization set address=? where idLocalization = ?  ";
        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            //ps.setLong(1,obj.getId());
            ps.setLong(1, variable.getAddress().getId());
            ps.setLong(2, variable.getId());

            if(ps.executeUpdate()==1)
            {
                return true;

            }}catch (SQLException e) {


            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Localization variable) {
        String req="delete from localization where idLocalization  =?";
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
