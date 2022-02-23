package application;
import exceptions.applicantExistException;
import models.AsoStore;
import models.Applicant;

public interface Application {

    void apply (Applicant applicant, AsoStore asoStore) throws applicantExistException;
}
