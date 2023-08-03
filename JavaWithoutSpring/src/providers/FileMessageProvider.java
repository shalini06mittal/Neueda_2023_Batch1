package providers;

import messages.IMessageProvider;

import java.util.Scanner;

public class FileMessageProvider implements IMessageProvider {

    @Override
    public String getMessage() {
        return "Read message from FILE!!!";
    }
}
