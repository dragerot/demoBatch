package com.example.services;

import com.example.domain.Melding;

import java.io.InputStream;

/**
 * Created by toanders on 19.10.2016.
 */
public interface ParseXMLService {
    Melding transform(InputStream xml);
}
