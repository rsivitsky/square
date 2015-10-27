package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.PartDAO;
import com.sivitsky.ddr.model.Part;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PartServiceImpl implements PartService {

    //    @Autowired
    private PartDAO partDAO;

    @Transactional
    public void addPart(Part part) {
        partDAO.addPart(part);
    }

    @Transactional
    public List<Part> listPart() {

        return partDAO.listPart();
    }

    @Transactional
    public void removePart(Integer id) {
        partDAO.removePart(id);
    }

}
