package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;
import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDAOImpl implements PartDAO {

    private static final Logger logger = LoggerFactory.getLogger(PartDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Part savePart(Part part) {
        sessionFactory.getCurrentSession().saveOrUpdate(part);
        logger.info("Part updated successfully, Part id=" + part.getPart_id());
        return part;
    }

    @SuppressWarnings("unchecked")
    public List<Part> listPart() {
        return sessionFactory.getCurrentSession().createQuery("from Part").list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> listPartWithDetail() {
       /* return sessionFactory.getCurrentSession().createSQLQuery("select distinct a.part_id as part_id, a.part_name as part_name, a.photo as photo, count(v.part_id) as offer_count, " +
                "min(v.offer_price) as min_price, b.descript_name from offer v left join part a left join description b " +
                "on a.part_id = b.part_id on v.part_id = a.part_id group by a.part_id").list();
                */
        //return sessionFactory.getCurrentSession().getNamedQuery("Part.findAllWithDetail").list();
        return sessionFactory.getCurrentSession().createQuery("select part.part_id as part_id, part.part_name as part_name, MIN (offer.offer_price) as min_price, COUNT (offer.offer_id) as offer_count from Part part join  part.offers offer group by part.part_id").list();
        //рабочий return sessionFactory.getCurrentSession().createQuery("select part.part_id, part.part_name, MIN (offer.offer_price), COUNT (offer.offer_id) from Part part join  part.offers offer group by part.part_id").list();
    }

    @SuppressWarnings("unchecked")
    public List<Part> listPartWithManufactursFilter(Long[] mas_id) {
        return sessionFactory.getCurrentSession().getNamedQuery("Part.findByManufactId").setParameterList("mas_id", mas_id).list();
    }

    @SuppressWarnings("unchecked")
    public List<Part> listPartByManufactIdAndPrice(Long[] mas_id, Float price_from, Float price_to) {
        return sessionFactory.getCurrentSession().getNamedQuery("Part.findByManufactIdAndPrice").setParameterList("mas_id", mas_id)
                .setParameter("price_from", price_from)
                .setParameter("price_to", price_to).list();
    }

    public Part getPartById(Long id) {
        return (Part) this.sessionFactory.getCurrentSession().get(Part.class, id);
    }

    public Part getPartByName(String name) {
        return (Part)sessionFactory.getCurrentSession().createQuery("select v from Part v where v.part_name = :part_name")
                .setParameter("part_name", name).uniqueResult();
    }

    public void removePart(Long id) {
        Part part = (Part) sessionFactory.getCurrentSession().load(Part.class, id);
        if (null != part) {
            sessionFactory.getCurrentSession().delete(part);
        }
    }
}
