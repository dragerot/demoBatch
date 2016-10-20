package com.example.services;



import com.example.domain.Melding;
import com.example.domain.Transaksjon;

import java.util.List;

public interface AvvikService {
    List<Melding>  hentMeldinger();
 }
