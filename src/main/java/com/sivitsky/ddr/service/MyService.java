package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private ConversionService conversionService;

    @Autowired
    public MyService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void doIt() {
        this.conversionService.convert(String.class, Role.class);
    }
}