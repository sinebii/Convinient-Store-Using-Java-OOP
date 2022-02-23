package application;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import exceptions.applicantExistException;
import models.Applicant;
import models.AsoStore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationImplementationTest {
    private ApplicationImplementation applicationImplementation;
    private Application application;
    private AsoStore asoStore;
    private Applicant applicant;
    @Before
    public void setUp() throws Exception {
        applicationImplementation = new ApplicationImplementation();
        asoStore = new AsoStore("Decagon","Edo Techpark","Decagon Ins");
        applicant = new Applicant("Tapiya","Dan","Abuja Nigeria",Gender.MALE,23,Qualification.MSC,Role.CASHIER);
    }

    @Test
    public void shouldAddApplicantToListOfApplicantsInTheStoreAfterApplication() throws applicantExistException {

        applicationImplementation.apply(applicant,asoStore);
        int listOfStaffAfterAddition = asoStore.getListOfApplicants().size();
        assertEquals(1,listOfStaffAfterAddition);
    }

    @Test
    public void shouldThrowApplicantAlreadyAppliedException() throws applicantExistException {
        applicationImplementation.apply(applicant,asoStore);
       assertThrows(applicantExistException.class,()->applicationImplementation.apply(applicant,asoStore));

    }
}