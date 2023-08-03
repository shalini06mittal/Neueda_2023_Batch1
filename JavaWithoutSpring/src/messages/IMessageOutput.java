package messages;
public interface IMessageOutput {
    public void render();
    public IMessageProvider getiMessageProvider();
    public void setiMessageProvider(IMessageProvider iMessageProvider) ;
}
