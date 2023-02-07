package br.com.attornatus.exception;

import java.util.List;

public class PessoaException extends RuntimeException{

    private List<String> violations;

    public PessoaException() {
        super();
    }

    public PessoaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PessoaException(String message) {
        super(message);
    }

    public PessoaException(Throwable cause) {
        super(cause);
    }

    public PessoaException(List<String> violations) {
        super();
        this.violations = violations;
    }

    public PessoaException(List<String> violations, Throwable cause) {
        super(cause);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

}
