package com.company.ceume.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.ceume.entity.Product;

@UiController("ceume_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}