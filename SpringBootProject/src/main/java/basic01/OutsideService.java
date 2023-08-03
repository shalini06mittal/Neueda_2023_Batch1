package basic01;

import com.demo.boot.SpringBootProject.util.PrintInfo;
import org.springframework.stereotype.Component;
/**
 * Since this class does not follow the package convention it will not be called
 * automatically by Spring boot. To call it explicitly, you will have to configure
 * using @ComponentScan
 */
@Component
public class OutsideService {
    public OutsideService() {
        PrintInfo.display("Outside package service class constructor", OutsideService.class.getSimpleName());
    }
}
