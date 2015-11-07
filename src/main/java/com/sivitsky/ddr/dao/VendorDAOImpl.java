package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendorDAOImpl implements VendorDAO {

    private static final Logger logger = LoggerFactory.getLogger(VendorDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public Vendor saveVendor(Vendor vendor) {
        sessionFactory.getCurrentSession().saveOrUpdate(vendor);
        logger.info("Vendor saved successfully, Vendor id=" + vendor.getVendor_id());
        return vendor;
    }

    @SuppressWarnings("unchecked")
    public List<Vendor> listVendor() {
        return sessionFactory.getCurrentSession().createQuery("from vendor")
                .list();
    }

    public void removeVendor(Long id) {
        Vendor vendor = (Vendor) sessionFactory.getCurrentSession().load(
                Vendor.class, id);
        if (null != vendor) {
            sessionFactory.getCurrentSession().delete(vendor);
        }
    }

    public Vendor getVendorById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Vendor vendor = (Vendor) session.load(Vendor.class, new Long(id));
        logger.info("Vendor loaded successfully, Vendor details="+vendor);
        return vendor;
    }

}
