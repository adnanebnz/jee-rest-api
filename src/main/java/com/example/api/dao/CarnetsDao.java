package com.example.api.dao;

import java.util.Map;

import com.example.api.models.AddressModel;
import com.example.api.models.Carnet;

public interface CarnetsDao {
    public void addAddress(String personne, AddressModel address, Carnet carnet);

    public void removeAddress(String personne, Carnet carnet);

    public AddressModel getAddress(String personne, Carnet carnet);

    public Map<String, AddressModel> getAddresses(Carnet carnet);

    public Map<String, AddressModel> getAddresses(String search, Carnet carnet);
}
