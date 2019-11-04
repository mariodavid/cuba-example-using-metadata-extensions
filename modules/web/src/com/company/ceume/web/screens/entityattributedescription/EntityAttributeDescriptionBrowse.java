package com.company.ceume.web.screens.entityattributedescription;

import com.haulmont.cuba.gui.screen.*;
import com.company.ceume.entity.EntityAttributeDescription;

@UiController("ceume_EntityAttributeDescription.browse")
@UiDescriptor("entity-attribute-description-browse.xml")
@LookupComponent("entityAttributeDescriptionsTable")
@LoadDataBeforeShow
public class EntityAttributeDescriptionBrowse extends StandardLookup<EntityAttributeDescription> {
}