package manageroperations;

import enums.Role;
import exceptions.AddProductsToStoreException;
import models.AsoStore;
import models.Staff;

import java.io.IOException;

import static warehouse.ReadDataFromSheet.readProductFromExcel;

public class ManagerIntImp implements ManagerInt{
    public void addProductsToStore(Staff staff, AsoStore asoStore) throws IOException, AddProductsToStoreException {
        if(staff.getRole().equals(Role.MANAGER)){
            readProductFromExcel();
        }else{
            throw new AddProductsToStoreException("Operation not allowed");
        }

    }
}
