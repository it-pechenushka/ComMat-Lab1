package services.work;

import exceptions.InvalidMatrixLineException;
import exceptions.WrongSizeException;
import method.GaussMethod;
import services.Service;
import services.message.FileMessageService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileService implements Service{
    private static final String TYPE_NAME = "файл";
    private FileMessageService ms;
    private int size;
    private double matrixA[][];
    private double matrixB[];
    private Scanner reader;
    private int register;

    public FileService(){
        ms = new FileMessageService();
        ms.selectedTypeMessage(FileService.getTypeName());
    }

    public void initFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean key = false;
        FileReader fr = null;
        
        while (!key) {
            ms.initFileName();
            fr = new FileReader(scanner.nextLine().trim());
            
            while (true) {
                ms.confirmMessage();
                Scanner scanner1 = new Scanner(System.in);
                String ans = scanner1.nextLine().trim();
                if (ans.equals("да")) {
                    key = true;
                    break;
                } else if (ans.equals("нет")) {
                    break;
                } else ms.invalidConfirmMessage();
            }
        }
        
        reader = new Scanner(fr);
    }

    public void parseFile() throws WrongSizeException, InvalidMatrixLineException {
        register = 1;
        size = Integer.parseInt(reader.nextLine().trim());

        if (size > 20 && size < 0)
            throw new WrongSizeException();

        register = 2;
        matrixA = new double[size][size];
        matrixB = new double[size];

        for(int i = 0; i < size; i++) {
            String supMatrix[] = reader.nextLine().trim().split(" ");

            if(supMatrix.length == size + 1) {
                for (int j = 0; j < size; j++) matrixA[i][j] = Double.parseDouble(supMatrix[j]);

                matrixB[i] = Double.parseDouble(supMatrix[size]);


            } else throw new InvalidMatrixLineException(i + 1);
        }
    }

    @Override
    public void doing() {
        ms.getWriteInstruction();
        
        while (true){
            try {
                initFile();
                parseFile();
                break;
            } catch (FileNotFoundException e) {
                ms.fileNotFoundMessage();
            } catch (WrongSizeException e) {
                ms.wrongSizeMessage();
            } catch (InvalidMatrixLineException e) {
                ms.invalidMatrixLineMessage(e.getLineNumber());
            } catch (NumberFormatException e){
                switch (register){
                    case 1:
                        ms.invalidFormatSizeMessage();
                        break;
                    case 2:
                        ms.invalidFormatMatrixMessage();
                        break;
                    default: break;
                }
            } catch (NoSuchElementException e){
                switch (register){
                    case 1:
                        ms.notSetSizeMessage();
                        break;
                    case 2:
                        ms.notSetMatrixElementMessage();
                        break;
                    default: break;
                }
            }
        }

        ms.showSizeMessage(size);
        ms.showMatrixMessage(matrixA, matrixB, false);

        new GaussMethod(matrixA, matrixB, size).solve();
    }

    public static String getTypeName() {
        return TYPE_NAME;
    }

}
