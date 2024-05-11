package com.example.api.dao;

import java.util.Map;

import com.example.api.models.AddressModel;
import com.example.api.models.Carnet;

public class CarnetsDaoImpl implements CarnetsDao {

    @Override
    public void addAddress(String personne, AddressModel address, Carnet carnet) {
        carnet.ensemble.put(personne, address);
    }

    @Override
    public void removeAddress(String personne, Carnet carnet) {
        carnet.ensemble.remove(personne);
    }

    @Override
    public AddressModel getAddress(String personne, Carnet carnet) {
        return carnet.ensemble.get(personne);
    }

    @Override
    public Map<String, AddressModel> getAddresses(Carnet carnet) {
        return carnet.ensemble;
    }

    @Override
    public Map<String, AddressModel> getAddresses(String search, Carnet carnet) {
        return Map.of(search, carnet.ensemble.get(search));

    }

}