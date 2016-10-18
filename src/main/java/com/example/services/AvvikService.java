package com.example.services;



import com.example.domain.Transaksjon;

import java.util.List;

public interface AvvikService {
    List<Transaksjon>  hentIkkeBehandledeTransaksjoner();
 }
