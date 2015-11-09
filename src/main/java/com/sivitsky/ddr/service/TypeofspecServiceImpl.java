package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.TypeofspecDAO;
import com.sivitsky.ddr.model.Typeofspec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TypeofspecServiceImpl implements TypeofspecService {

    private TypeofspecDAO typeofspecDAO;

    @Transactional
    public Typeofspec saveTypeofspec(Typeofspec typeofspec) {
        return  typeofspecDAO.saveTypeofspec(typeofspec);
    }

    @Transactional
    public List<Typeofspec> listTypeofspec() {
        return typeofspecDAO.listTypeofspecs();
    }

    @Transactional
    public void removeTypeofspec(Long id) {
        typeofspecDAO.removeTypeofspec(id);
    }

    @Autowired
    public void setTypeofspecDAO(TypeofspecDAO typeofspecDAO) {
        this.typeofspecDAO = typeofspecDAO;
    }

    @Transactional
    public Typeofspec getTypeofspecByID(Long id){
        return typeofspecDAO.getTypeofspecById(id);
    }

}
