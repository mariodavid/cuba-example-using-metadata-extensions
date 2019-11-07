package com.company.ceume.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.ceume.entity.Customer;

@UiController("ceume_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}