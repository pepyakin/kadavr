package org.knott.kadavr.metadata;

/**
 * В основном выбрасывается когда происходит
 * доступ к элементу, который ещё не прошёл процесс связывания.
 * @author Sergey
 */
public class NotLinkedException extends IllegalStateException {

    public NotLinkedException(Throwable cause) {
        super(cause);
    }

    public NotLinkedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLinkedException(String s) {
        super(s);
    }

    public NotLinkedException() {
    }
}
