package providers;

import messages.IMessageProvider;

public class StringMessageProvider implements IMessageProvider {

    String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
