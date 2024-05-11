package com.example.api.models;

import java.util.Map;
import java.util.HashMap;

public class Carnet {
    public int id;
    public String nom;
    public Map<String, AddressModel> ensemble;

    public Carnet() {
        this.ensemble = new HashMap<String, AddressModel>();
    }

    public Carnet(String nom) {
        this.nom = nom;
        this.ensemble = new HashMap<String, AddressModel>();
    }

}