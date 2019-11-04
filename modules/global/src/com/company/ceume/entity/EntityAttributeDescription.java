package com.company.ceume.entity;

import de.diedavids.cuba.metadataextensions.entity.EntityAttributeAwareStandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "CEUME_ENTITY_ATTRIBUTE_DESCRIPTION")
@Entity(name = "ceume_EntityAttributeDescription")
public class EntityAttributeDescription extends EntityAttributeAwareStandardEntity {
    private static final long serialVersionUID = -7146245920304606972L;

    @Column(name = "API_DESCRIPTION")
    protected String apiDescription;

    @Column(name = "DB_DESCRIPTION")
    protected String dbDescription;

    public String getDbDescription() {
        return dbDescription;
    }

    public void setDbDescription(String dbDescription) {
        this.dbDescription = dbDescription;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }
}