package models;
import warehouse.ReadDataFromSheet;

import java.io.IOException;
import java.util.*;

public class AsoStore {
    private String storeName;
    private String storeAddress;
    private String storeOwnner;
    private List<Applicant> listOfApplicants;
    private Product[] listofProducts;
    private List<Staff> listofStaff;
    private PersonalizedQueue customerQueue;

    public AsoStore(String storeName, String storeAddress, String storeOwnner) throws IOException {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeOwnner = storeOwnner;
        this.listOfApplicants = new ArrayList<>();
        this.listofProducts = ReadDataFromSheet.readProductFromExcel();
        this.listofStaff = new ArrayList<>();
        this.customerQueue = new PersonalizedQueue();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public PersonalizedQueue getCustomerQueue(){

        return this.customerQueue;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreOwnner() {
        return storeOwnner;
    }

    public void setStoreOwnner(String storeOwnner) {
        this.storeOwnner = storeOwnner;
    }

    public List<Applicant> getListOfApplicants() {
        return listOfApplicants;
    }

    public void setListOfApplicants(List<Applicant> listOfApplicants) {
        this.listOfApplicants = listOfApplicants;
    }

    public Product[] getListofProducts() {
        return listofProducts;
    }


    public List<Staff> getListofStaff() {
        return listofStaff;
    }

    public void setListofStaff(List<Staff> listofStaff) {
        this.listofStaff = listofStaff;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AsoStore{");
        sb.append("storeName='").append(storeName).append('\'');
        sb.append(", storeAddress='").append(storeAddress).append('\'');
        sb.append(", storeOwnner='").append(storeOwnner).append('\'');
        sb.append(", listOfApplicants=").append(listOfApplicants);
        sb.append(", listofProducts=").append(Arrays.toString(listofProducts));
        sb.append(", listofStaff=").append(listofStaff);
        sb.append('}');
        return sb.toString();
    }
}
