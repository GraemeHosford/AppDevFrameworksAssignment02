package graeme.hosford.rob.morgan.assignment2.controller.form;

import javax.validation.constraints.Size;

public class JobForm {

    @Size(min = 5, max = 50)
    private String jobName;

    @Size(min = 1, max = 250)
    private String jobDescription;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
