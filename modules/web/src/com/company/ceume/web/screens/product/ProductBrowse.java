package com.company.ceume.web.screens.product;

import com.company.ceume.entity.Product;
import com.company.ceume.entity.ProductType;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.metadataextensions.EntityDialogFacet;

import javax.inject.Inject;

@UiController("ceume_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {

    @Inject
    protected Notifications notifications;
    @Inject
    protected Metadata metadata;
    @Inject
    protected CollectionContainer<Product> productsDc;
    @Inject
    protected DataContext dataContext;


    private Product newLaptopProduct;



    @Install(to = "createLaptopDialog", subject = "entityProvider")
    protected Product laptopProductEntityProvider() {
        newLaptopProduct = metadata.create(Product.class);
        newLaptopProduct.setType(ProductType.LAPTOP);
        return newLaptopProduct;
    }


    @Subscribe("createLaptopDialog")
    public void onInputDialogClose(EntityDialogFacet.CloseEvent closeEvent) {

        if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
            dataContext.merge(newLaptopProduct);
            productsDc.getMutableItems().add(newLaptopProduct);
            dataContext.commit();

            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Laptop " + newLaptopProduct.getName() + " successfully created")
                    .show();

            getScreenData().loadAll();
        }

        newLaptopProduct = null;
    }
}