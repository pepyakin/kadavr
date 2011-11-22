package org.knott.kadavr.metadata;

/**
 * В основном выбрасывается когда происходит
 * доступ к элементу, который ещё не прошёл процесс связывания.
 * @author Sergey
 */
public class NotLinkedException extends IllegalStateException {

    /**
     * Создать экземпляр {@link NotLinkedException}.
     * @param cause
     */
    public NotLinkedException(Throwable cause) {
        super(cause);
    }

    /**
     * Создать экземпляр {@link NotLinkedException}.
     * @param message
     * @param cause
     */
    public NotLinkedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Создать экземпляр {@link NotLinkedException}.
     * @param s
     */
    public NotLinkedException(String s) {
        super(s);
    }

    /**
     * Создать экземпляр {@link NotLinkedException}.
     */
    public NotLinkedException() {
    }
}
