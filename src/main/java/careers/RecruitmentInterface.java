package careers;

import models.Applicant;
import models.AsoStore;
import models.Staff;

public interface RecruitmentInterface {

    void hireCashier(Applicant applicant, Staff staff, AsoStore asoStore);
}
