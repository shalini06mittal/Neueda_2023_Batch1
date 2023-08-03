package providers;

import messages.IMessageProvider;

import java.util.Scanner;

public class ScannerMessageProvider implements IMessageProvider {


    @Override
    public String getMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message");
        String message = sc.nextLine();
        return message;
    }
}
