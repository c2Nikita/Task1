package org.example.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.task.entity.CustomArray;
import org.example.task.exception.ArrayException;
import org.example.task.observer.CustomArrayObserver;
import org.example.task.observer.impl.CustomArrayObserverImpl;
import org.example.task.parser.impl.FileLineParserImpl;
import org.example.task.reader.impl.FileArrayReaderImpl;
import org.example.task.repository.CustomArrayRepository;
import org.example.task.specification.impl.ContainsValueSpecification;
import org.example.task.warehouse.CustomArrayWareHouse;


import java.util.List;

import static org.example.task.entity.CustomArray.newBuilder;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayException {
        Logger logger = LogManager.getLogger();
        FileArrayReaderImpl fileArrayReaderService = new FileArrayReaderImpl();
        FileLineParserImpl fileLineParserService = new FileLineParserImpl();
        CustomArrayObserver customArrayObserver = new CustomArrayObserverImpl();
        CustomArrayWareHouse customArrayWareHouse = CustomArrayWareHouse.getInstance();
        List<String> list = fileArrayReaderService.readFile("data/file.txt");
        int[] array = fileLineParserService.parseToCustomArrayFromStringList(list);
        CustomArray customArray = newBuilder().setArray(array).setId().build();
        customArray.addObserver(customArrayObserver);
        logger.info(customArray.toString());
        CustomArray customArray1 = newBuilder().setArray(array).setId().build();
        customArray1.addObserver(customArrayObserver);

        CustomArrayRepository repository = CustomArrayRepository.getInstance();

        repository.add(customArray);
        repository.add(customArray1);

        List<CustomArray> listik = repository.query(new ContainsValueSpecification(3));
        logger.info(customArrayWareHouse.getArrayStats(3));
        logger.info(listik);

    }
}