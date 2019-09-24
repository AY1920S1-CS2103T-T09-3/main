package seedu.address.model.events;

public enum Status {

    WAITING("patient is waiting now"),
    MISSED("patient is waiting now"),
    ACK("patient is arrived"),
    SETTLE("patient is ");

    private String statusMess;

    Status(String status) {
        this.statusMess = status;
    }

    public String getStatusMess() {
        return statusMess;
    }
}
