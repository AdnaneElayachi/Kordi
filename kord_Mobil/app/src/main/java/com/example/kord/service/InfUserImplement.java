package com.example.kord.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.kord.connexion.Connexion;
import com.example.kord.models.Address;
import com.example.kord.models.InformationUser;

import com.example.kord.repository.CRUD;

public class InfUserImplement implements CRUD<InformationUser> {
    @Override
    public List<InformationUser> getAll() {

        String req="select * from address";
        List<InformationUser> Iformation=new ArrayList<InformationUser>();

        try {
            PreparedStatement ps= Connexion.getCon().prepareStatement(req);
            ResultSet rs =ps.executeQuery();
            while(rs.next())
            {
                Iformation.add(new InformationUser(rs.getInt("idaddress"),rs.getString("rue"),rs.getString("city"),rs.getString("state"),rs.getString("postal_code")));
            }
            return Iformation;

        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public InformationUser getById(int id) {
        return null;
    }

    @Override
    public boolean add(InformationUser variable) {
        return false;
    }

    @Override
    public boolean update(InformationUser variable) {
        return false;
    }

    @Override
    public boolean delete(InformationUser variable) {
        return false;
    }



}
