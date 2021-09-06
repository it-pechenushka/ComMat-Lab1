package exceptions;

public class InvalidMatrixLineException extends Exception {
    private int lineNumber;

    public InvalidMatrixLineException(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
