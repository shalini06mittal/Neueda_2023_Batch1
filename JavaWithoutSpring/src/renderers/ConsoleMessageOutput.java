package renderers;

import messages.IMessageOutput;
import messages.IMessageProvider;

public class ConsoleMessageOutput implements IMessageOutput {

    private IMessageProvider iMessageProvider;

    @Override
    public void render() {
        System.out.println("Message to be sent on the console");
        System.out.println(iMessageProvider.getMessage());
    }

    public IMessageProvider getiMessageProvider() {
        return iMessageProvider;
    }

    public void setiMessageProvider(IMessageProvider iMessageProvider) {
        this.iMessageProvider = iMessageProvider;
    }

}
