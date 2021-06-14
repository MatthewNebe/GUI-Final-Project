import java.util.EventObject;
public class DetailEvent extends EventObject
{
    private String text; //creates text variable
    public DetailEvent(Object source, String text)
    {
        super(source);
        this.text = text;

    }

    public String getText() //get text method
    {
        return text;
    }
}