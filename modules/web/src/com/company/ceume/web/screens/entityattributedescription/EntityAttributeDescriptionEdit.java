package com.company.ceume.web.screens.entityattributedescription;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import com.company.ceume.entity.EntityAttributeDescription;
import de.diedavids.cuba.metadataextensions.web.MetadataDataProvider;

import javax.inject.Inject;

@UiController("ceume_EntityAttributeDescription.edit")
@UiDescriptor("entity-attribute-description-edit.xml")
@EditedEntityContainer("entityAttributeDescriptionDc")
@LoadDataBeforeShow
public class EntityAttributeDescriptionEdit extends StandardEditor<EntityAttributeDescription> {


    @Inject
    protected LookupField<MetaClass> entityField;

    @Inject
    protected MetadataDataProvider metadataDataProvider;
    @Inject
    protected LookupField<MetaProperty> entityAttributeField;

    @Subscribe
    protected void onInit(InitEvent event) {
        entityField.setOptionsMap(metadataDataProvider.getEntitiesLookupFieldOptions());
    }

    @Subscribe("entityField")
    protected void onEntityFieldValueChange(HasValue.ValueChangeEvent<MetaClass> event) {

        if (event.getValue() != null) {
            entityAttributeField.setOptionsMap(
                    metadataDataProvider.getAllAttributesLookupFieldOptions(event.getValue())
            );
        }
    }

}