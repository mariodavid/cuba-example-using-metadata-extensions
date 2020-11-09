package com.company.ceume;

import com.company.ceume.entity.Product;
import com.company.ceume.entity.ProductType;
import com.company.ceume.web.screens.product.ProductBrowse;
import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.util.OperationResult;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.proxy.TestServiceProxy;
import de.diedavids.sneferu.ControllableDataServiceProxy;
import de.diedavids.sneferu.UiTestAPI;
import de.diedavids.sneferu.environment.SneferuTestUiEnvironment;
import de.diedavids.sneferu.environment.StartScreen;
import de.diedavids.sneferu.interactions.CloseInputDialogInteraction;
import de.diedavids.sneferu.screen.InputDialogTestAPI;
import de.diedavids.sneferu.screen.StandardLookupTestAPI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Optional;

import static de.diedavids.sneferu.ComponentDescriptors.button;
import static de.diedavids.sneferu.ComponentDescriptors.textInputField;
import static de.diedavids.sneferu.Interactions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EntityDialogFacetTest {

    @RegisterExtension
    public SneferuTestUiEnvironment environment =
            new SneferuTestUiEnvironment(WebTestContainer.Common.INSTANCE)
                    .withScreenPackages(
                            "com.haulmont.cuba",
                            "de.diedavids.cuba.metadataextensions",
                            "com.company.ceume.web"
                    )
                    .withUserLogin("admin")
                    .withMainScreen(MainScreen.class);
    private ControllableDataServiceProxy dataService;

    @BeforeEach
    void setUp() {
        dataService = new ControllableDataServiceProxy(environment.getContainer());
        TestServiceProxy.mock(DataService.class, dataService);
    }

    @Test
    public void aVisitCanBeCreated_whenAllFieldsAreFilled(
            @StartScreen StandardLookupTestAPI<Product, ProductBrowse> productBrowse
    ) {

        // given: entity dialog facet is used
        productBrowse
                .interact(click(button("createLaptopBtn")));

        // and: the entity dialog was opened
        InputDialogTestAPI entityInputDialog = uiTestAPI()
                .openedInputDialog();

        // when:
        OperationResult entityDialogOutcome = entityInputDialog
                .interact(enter(textInputField("name"), "MacBook Pro"))
                .andThenGet(closeEntityDialog());

        // then: input dialog was successfully closed
        assertThat(entityDialogOutcome)
                .isEqualTo(OperationResult.success());

        // and:
        Optional<Product> potentialProduct = fetchPersistedLaptop(ProductType.LAPTOP);

        // and:
        assertThat(potentialProduct)
                .isPresent();

        // and:
        assertThat(potentialProduct.get().getName())
                .isEqualTo("MacBook Pro");
    }

    private UiTestAPI uiTestAPI() {
        return environment.getUiTestAPI();
    }

    private CloseInputDialogInteraction closeEntityDialog() {
        return closeInputDialogWith(InputDialog.INPUT_DIALOG_OK_ACTION);
    }

    private Optional<Product> fetchPersistedLaptop(ProductType productType) {
        return dataService.committed(Product.class, product -> product.getType().equals(productType));
    }

    @AfterEach
    public void closeAllScreens() {
        uiTestAPI().closeAllScreens();
        TestServiceProxy.clear();
    }
}
