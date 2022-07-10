import models.Slot;
import request.operation.FileBasedOperationRequest;
import services.operation.FileBased;
import services.operation.OperationService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Map<Integer, Slot> slotMap = new LinkedHashMap<>();
        //String filePath = "/home/sunil.kumarchawla/Desktop/parking3/src/input/input.txt";
        String filePath = System.getProperty("user.dir") + "/src/input/input.txt";

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String a = System.getProperty("user.dir");

        OperationService operationService = new FileBased();

        FileBasedOperationRequest fileBasedOperationRequest = new FileBasedOperationRequest();
        fileBasedOperationRequest.setFilePath(filePath);
        fileBasedOperationRequest.setSlotMap(slotMap);

        operationService.performOperation(fileBasedOperationRequest);


    }
}