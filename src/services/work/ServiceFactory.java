package services.work;

import services.Service;

public class ServiceFactory {
    public Service createService(String serviceName){
        switch (serviceName){
            case "к":
                return new ConsoleService();
            case "ф":
                return new FileService();
            case "г":
                return new RandomGeneratorService();
            default:
                return null;
        }
    }
}
