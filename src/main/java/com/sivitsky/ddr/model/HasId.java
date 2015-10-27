package com.sivitsky.ddr.model;

public interface HasId {

    String ID_COLUMN = "id";

    /**
     * The id attribute used to uniquelly identify the instance of the subclass
     *
     * @return the unique id (primary key) of the instance
     */
    Long getId();

    /**
     * Setter method which could not be used on attached objects as it would violate the session cache. Usage of this
     * method should be avoided as it could cause severe problems and inconsistent data.
     *
     * @param id which should be used as primary key on the instance
     */
    void setId(Long id);
}