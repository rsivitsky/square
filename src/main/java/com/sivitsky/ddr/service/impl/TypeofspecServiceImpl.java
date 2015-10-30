package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.dao.TypeofspecDAO;
import com.sivitsky.ddr.model.Typeofspec;
import com.sivitsky.ddr.service.TypeofspecService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TypeofspecServiceImpl implements TypeofspecService {

    //    @Autowired
    private TypeofspecDAO typeofspecDAO;

    @Transactional
    public void addTypeofspec(Typeofspec typeofspec) {
        typeofspecDAO.addTypeofspec(typeofspec);
    }

    @Transactional
    public List<Typeofspec> listTypeofspec() {

        return typeofspecDAO.listTypeofspec();
    }

    @Transactional
    public void removeTypeofspec(Integer id) {
        typeofspecDAO.removeTypeofspec(id);
    }

}
