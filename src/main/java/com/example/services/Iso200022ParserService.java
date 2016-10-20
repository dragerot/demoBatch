package com.example.services;

import com.example.domain.Melding;

import java.io.InputStream;

public interface Iso200022ParserService {
    String hentMeldingId(InputStream xml);
}
