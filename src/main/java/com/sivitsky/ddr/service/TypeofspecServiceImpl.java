package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.TypeofspecDAO;
import com.sivitsky.ddr.model.Typeofspec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeofspecServiceImpl implements TypeofspecService {

    @Autowired
    private TypeofspecDAO typeofspecDAO;

    @Transactional
    public Typeofspec saveTypeofspec(Typeofspec typeofspec) {
        return typeofspecDAO.saveTypeofspec(typeofspec);
    }

    @Transactional
    public List<Typeofspec> listTypeofspec() {
        return typeofspecDAO.listTypeofspecs();
    }

    @Transactional
    public void removeTypeofspec(Long id) {
        typeofspecDAO.removeTypeofspec(id);
    }

    @Transactional
    public Typeofspec getTypeofspecByID(Long id) {
        return typeofspecDAO.getTypeofspecById(id);
    }
}
