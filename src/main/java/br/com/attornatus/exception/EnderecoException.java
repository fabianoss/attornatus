package br.com.attornatus.exception;

import java.util.List;

public class EnderecoException extends RuntimeException{

    private List<String> violations;

    public EnderecoException() {
        super();
    }

    public EnderecoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnderecoException(String message) {
        super(message);
    }

    public EnderecoException(Throwable cause) {
        super(cause);
    }

    public EnderecoException(List<String> violations) {
        super();
        this.violations = violations;
    }

    public EnderecoException(List<String> violations, Throwable cause) {
        super(cause);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

}
