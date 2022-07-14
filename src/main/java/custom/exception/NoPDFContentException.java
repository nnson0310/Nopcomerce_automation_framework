package custom.exception;

public class NoPDFContentException extends RuntimeException {

    public NoPDFContentException(String pdfName, String pathToFile) {
        super("This " + pdfName + " has no content inside it. Check file content with path = " + pathToFile);
    }
}
