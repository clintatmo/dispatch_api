package sr.dispatch.api.dto;

import java.io.Serializable;
import java.util.Date;

/* * * @author Clint Atmosoerodjo #commander *  */

public class HoofdTaak implements Serializable {

    private String naam;
    private Date dueDate;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}