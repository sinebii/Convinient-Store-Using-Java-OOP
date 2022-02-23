package application;

import exceptions.applicantExistException;
import models.Applicant;
import models.AsoStore;

public class ApplicationImplementation implements Application{

    @Override
    public void apply(Applicant applicant, AsoStore asoStore) throws applicantExistException {

        if(asoStore.getListOfApplicants().contains(applicant)){

            throw new applicantExistException("You have applied already");
        }else{

            asoStore.getListOfApplicants().add(applicant);
            System.out.println("Application was successful ");
        }
    }
}
