package com.example.visprojekteshop.service;

import com.example.visprojekteshop.Entity.Kategorie;

import java.util.List;

public interface KategorieService {
    List<Kategorie> getAllKategorien();
    Kategorie getKategorieById(long id);
    List<Kategorie> getKategorieByName(String name);
}