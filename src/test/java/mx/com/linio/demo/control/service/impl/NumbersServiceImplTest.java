package mx.com.linio.demo.control.service.impl;

import mx.com.linio.demo.control.services.impl.NumbersServiceImpl;
import mx.com.linio.demo.model.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class NumbersServiceImplTest {

    NumbersServiceImpl numbersService = new NumbersServiceImpl();
    Configuration configuration = new Configuration();

    List<Integer> multiple3 = new ArrayList<Integer>();
    List<Integer> multiple5 = new ArrayList<Integer>();
    List<Integer> multiple3and5 = new ArrayList<Integer>();

    @Before
    public void config(){
        Map<Integer,String> configNumbers = new HashMap<Integer,String>();
        configNumbers.put(3,"Lineo");
        configNumbers.put(5,"IT");
        configuration.setConfigurations(configNumbers);
        configuration.setJoinMessage("Lineanos");
        configuration.setMaxLimit(100);
        configuration.setMinLimit(1);
        numbersService.setConfiguration(configuration);

        for(Integer number = 1; number <=100; number++){
            if (number % 3 == 0 && number % 5 == 0){
                multiple3and5.add(number);
            }else if(number % 3 == 0){
                multiple3.add(number);
            }else if(number % 5 == 0){
                multiple5.add(number);
            }
        }

    }

    @Test
    public void generateLinioSerieSize(){
        List<String> serie = numbersService.generateLinioSerie();
        assertEquals("should content 100 elements", 100, serie.size());
        for (String number: serie){
            System.out.println(number);
        }
    }

    @Test
    public void generateLinioSerieMultiple3(){
        List<String> serie = numbersService.generateLinioSerie();
        String message;
        for (Integer index: multiple3){
            message = serie.get(index-1);
            assertEquals("Message incorrect for multiple 3","Lineo",message);
        }
    }

    @Test
    public void generateLinioSerieMultiple5(){
        List<String> serie = numbersService.generateLinioSerie();
        String message;
        for (Integer index: multiple5){
            message = serie.get(index-1);
            assertEquals("Message incorrect for multiple 5","IT",message);
        }
    }

    @Test
    public void generateLinioSeriemultiple3and5(){
        List<String> serie = numbersService.generateLinioSerie();
        String message;
        for (Integer index: multiple3and5){
            message = serie.get(index-1);
            assertEquals("Message incorrect for multiple 3 and 5","Lineanos",message);
        }
    }
}
