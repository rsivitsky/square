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

    public void addVendor(Vendor vendor) {
        int maxId = sessionFactory.getCurrentSession().createQuery("select max(vendor_id) from Vendor").getFirstResult()==null ? 0:
                sessionFactory.getCurrentSession().createQuery("select max(vendor_id) from Vendor").getFirstResult();
        //vendor.setVendor_id(maxId+1);
        sessionFactory.getCurrentSession().save(vendor);
    }

    @SuppressWarnings("unchecked")
    public List<Vendor> listVendor() {

        return sessionFactory.getCurrentSession().createQuery("from Vendor")
                .list();
    }

    public void removeVendor(Integer id) {
        Vendor vendor = (Vendor) sessionFactory.getCurrentSession().load(
                Vendor.class, id);
        if (null != vendor) {
            sessionFactory.getCurrentSession().delete(vendor);
        }
    }

    public Vendor getVendorById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Vendor vendor = (Vendor) session.load(Vendor.class, new Integer(id));
        logger.info("Vendor loaded successfully, Vendor details="+vendor);
        return vendor;
    }

    public void updateVendor(Vendor vendor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(vendor);
        logger.info("Vendor updated successfully, Vendor Details="+vendor);
    }

}
