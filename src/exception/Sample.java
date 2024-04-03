  package exception;

public class Sample extends RuntimeException {
    public Sample(String errorMsg) {
        super(errorMsg);
    }
}