package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.Entity.Kategorie;
import com.example.visprojekteshop.Repository.KategorieRepository;
import com.example.visprojekteshop.service.KategorieService;

import java.util.List;

public class KategorieServiceImp implements KategorieService {
    private final KategorieRepository kategorieRepository;

    public KategorieServiceImp() {
        this.kategorieRepository = new KategorieRepository();
    }

    @Override
    public List<Kategorie> getAllKategorien() {
        return kategorieRepository.findAll();
    }

    @Override
    public Kategorie getKategorieById(long id) {
        return kategorieRepository.findById(id);
    }

    @Override
    public List<Kategorie> getKategorieByName(String name) {
        return kategorieRepository.findByName(name);
    }
}