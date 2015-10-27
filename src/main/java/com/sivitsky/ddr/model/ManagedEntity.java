package com.sivitsky.ddr.model;

import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base entity class
 */
@MappedSuperclass
public abstract class ManagedEntity implements HasId, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_COLUMN)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the class of an instance or the underlying class of a proxy
     *
     * @param entity entity
     */
    public static Class<?> getClassWithoutProxy(Object entity) {
        return HibernateProxyHelper.getClassWithoutInitializingProxy(entity);
    }

    /**
     * Two entities are equal if they have equal ids and the same class See http://onjava.com/pub/a/onjava/2006/09/13/dont-let-hibernate-steal-your-identity.html
     * See http://stackoverflow.com/questions/7132649/is-this-a-good-equals-hashcode-implementation
     */
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!getClassWithoutProxy(this)
                .equals(getClassWithoutProxy(o))) {
            return false;
        }

        ManagedEntity other = (ManagedEntity) o;//NOSONAR
        // if the id is missing, return false
        if (getId() == null) {
            return false;
        }
        // equivalence by id
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : super.hashCode();
    }

    @Transient
    public boolean isNew() {
        return getId() == null;
    }
}