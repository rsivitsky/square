package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Description;
import java.util.List;

public interface DescriptionService {

    public void addDescription(Description description);

    public List<Description> listDescription();

    public void removeDescription(Integer id);

}
