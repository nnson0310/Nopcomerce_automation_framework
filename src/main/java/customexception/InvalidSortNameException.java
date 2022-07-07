package customexception;

public class InvalidSortNameException extends RuntimeException {

    public InvalidSortNameException(String sortName) {
        super("Sort name = " + sortName + " is invalid");
    }
}
