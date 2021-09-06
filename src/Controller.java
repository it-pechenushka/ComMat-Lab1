import services.Service;
import services.message.MessageService;
import services.work.ServiceFactory;

import java.util.Scanner;

/**
 * Here you can choose a way to read input data. From console, file
 * or you can use random generator to set values.
 * @author ilusha
 * @version 1.1
 */
public class Controller {
    private String dataEntryMethod;
    private boolean correctDataStatus;
    private MessageService messageService;

    public Controller(){
        this.messageService = new MessageService();
        messageService.doing();
    }

    public void start(){
        enterDataEntryMethod();
        correctDataStatus = isCorrectDataStatus();

        while (!correctDataStatus){
            messageService.printWrongInputDataTypeMessage();
            enterDataEntryMethod();
            correctDataStatus = isCorrectDataStatus();
        }

        ServiceFactory factory = new ServiceFactory();
        Service service = factory.createService(dataEntryMethod);
        service.doing();
    }

    private void enterDataEntryMethod(){
        Scanner inp = new Scanner(System.in);

        messageService.printDataEntryMethodMessage();
        dataEntryMethod = inp.nextLine().trim().toLowerCase();
    }

    private boolean isCorrectDataStatus(){
        return dataEntryMethod.equals("к") || dataEntryMethod.equals("ф") || dataEntryMethod.equals("г");
    }
}
