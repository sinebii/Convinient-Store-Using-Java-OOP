package careers;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import exceptions.FailedRecruitmentException;
import exceptions.ManagerException;
import models.Applicant;
import models.AsoStore;
import models.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecruitmentImplementationTest {
    private RecruitmentImplementation recruitmentImplementation;
    private Applicant applicant;
    private Staff staff;
    private Staff staff1;
    private Applicant applicant1;
    private AsoStore asoStore;

    @Before
    public void setUp() throws Exception {
        recruitmentImplementation = new RecruitmentImplementation();
        applicant = new Applicant("Aso","Innazo","Abuja", Gender.MALE,36, Qualification.BSC, Role.CASHIER);
        applicant1 = new Applicant("Aso","Innazo","Abuja", Gender.MALE,20, Qualification.MSC, Role.CASHIER);
        staff = new Staff("Tapiya","Innazo","Lagos",Gender.MALE,Role.CASHIER);
        staff1 = new Staff("Tapiya","Innazo","Lagos",Gender.MALE,Role.MANAGER);
        asoStore = new AsoStore("ASO","Decagon","Decagon");
    }

    @Test
    public void shouldCheckIfItIsTheManagerHiring() {
        assertThrows(ManagerException.class,()->recruitmentImplementation.hireCashier(applicant,staff,asoStore));
    }

    @Test
    public void shouldCheckApplicantQualification() {
        assertThrows(FailedRecruitmentException.class,()->recruitmentImplementation.hireCashier(applicant,staff1,asoStore));
    }

    @Test
    public void shouldCheckIfAnApplicantIsAddedToCashierList(){

        int listOfStaffBeforeAddition = asoStore.getListofStaff().size();
        asoStore.getListofStaff().add(staff);
        int listOfStaffAfterAddition = asoStore.getListofStaff().size();
        assertEquals(1,listOfStaffAfterAddition);

    }

}