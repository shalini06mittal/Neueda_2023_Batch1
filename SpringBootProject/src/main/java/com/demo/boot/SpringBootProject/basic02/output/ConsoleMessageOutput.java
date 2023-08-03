package com.demo.boot.SpringBootProject.basic02.output;


import com.demo.boot.SpringBootProject.basic01.InsideService;
import com.demo.boot.SpringBootProject.basic02.providers.IMessageProvider;
import com.demo.boot.SpringBootProject.util.PrintInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Field Injection uses reflection to set the values of private variables
 * Constructor Injection happens at the time of creating the object itself
 * Setter Injection uses setters to set the value
 * https://www.appsdeveloperblog.com/constructor-vs-field-dependency-injection-in-spring/
 */
@Component
public class ConsoleMessageOutput implements IMessageOutput {
    /**
     * we have added the @Autowired annotation to both the setter and the field.
     * In this case, Spring injects dependency using the setter injection method.
     *
     * If added both on constructor and field then field takes the priority
     * here file referes to the bean name as given
     */
    @Autowired
    @Qualifier("file")
    private IMessageProvider iMessageProvider;
    /**
     * If a class has a single constructor, the @Autowired annotation can be ignored and
     * Spring framework will supply that for you behind the scenes.
     * However, if the class has more than one constructor, any one of them must be annotated with the @Autowired annotation
     * for the parameters you want to injected
     */
//    public ConsoleMessageOutput() {
//        PrintInfo.display("default constructor", ConsoleMessageOutput.class.getSimpleName());
//    }
    //@Autowired

    public ConsoleMessageOutput(  IMessageProvider iMessageProvider) {
        this.iMessageProvider = iMessageProvider;
        PrintInfo.display("constructor", ConsoleMessageOutput.class.getSimpleName());
        System.out.println(this.iMessageProvider);
    }

    @Override
    public void render() {
        System.out.println(iMessageProvider.getMessage());
    }

    public IMessageProvider getiMessageProvider() {
        return iMessageProvider;
    }

    /**
     * setter autowired overrides the constructor injection
     * @Qualifier overrides the @Primnary annotation
     * @param iMessageProvider
     */
   // @Autowired
    //@Qualifier("scannerMessageProvider")
    public void setiMessageProvider(IMessageProvider iMessageProvider) {
        PrintInfo.display("setter", ConsoleMessageOutput.class.getSimpleName());
        this.iMessageProvider = iMessageProvider;
    }

}
