package careers;

import enums.Qualification;
import enums.Role;
import exceptions.FailedRecruitmentException;
import exceptions.ManagerException;
import models.Applicant;
import models.AsoStore;
import models.Staff;

public class RecruitmentImplementation implements RecruitmentInterface{

    public void hireCashier(Applicant applicant, Staff staff, AsoStore asoStore){

        if(staff.getRole().equals(Role.MANAGER)){

            if(applicant.getQualification().equals(Qualification.MSC)){

                Staff newStaff = new Staff();
                newStaff.setPersonName(applicant.getPersonName());
                newStaff.setPersonLastName(applicant.getPersonLastName());
                newStaff.setPersonAddress(applicant.getPersonAddress());
                newStaff.setGender(applicant.getGender());
                newStaff.setRole(applicant.getRole());

                asoStore.getListofStaff().add(newStaff);
                asoStore.getListOfApplicants().remove(applicant);
            }else{
                throw new FailedRecruitmentException("The Applicant does not meet Minimum Requirement");
            }
        }else{

            throw new ManagerException("Only Managers are allowed to hire a cashier");
//          throw new managerAuthorizationException("You are not allowed to recruit a staff");
        }
    }
}
