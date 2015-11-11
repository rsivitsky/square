package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendorDAOImpl implements VendorDAO {

    private static final Logger logger = LoggerFactory.getLogger(VendorDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Vendor saveVendor(Vendor vendor) {
        sessionFactory.getCurrentSession().saveOrUpdate(vendor);
        logger.info("Vendor updated successfully, Vendor id=" + vendor.getVendor_id());
        return vendor;
    }

    @SuppressWarnings("unchecked")
    public List<Vendor> listVendor() {
        return sessionFactory.getCurrentSession().createQuery("from Vendor").list();
    }

    public Vendor getVendorById(Long id) {
        return (Vendor) this.sessionFactory.getCurrentSession().get(Vendor.class, id);
    }

    public void removeVendor(Long id) {
        Vendor vendor = (Vendor) sessionFactory.getCurrentSession().load(Vendor.class, id);
        if (null != vendor) {
            sessionFactory.getCurrentSession().delete(vendor);
        }
    }

}
