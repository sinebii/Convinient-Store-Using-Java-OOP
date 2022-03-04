package manageroperations;

import exceptions.AddProductsToStoreException;
import models.AsoStore;
import models.Staff;

import java.io.IOException;

public interface ManagerInt {
    void addProductsToStore(Staff staff, AsoStore asoStore) throws IOException, AddProductsToStoreException;
}
