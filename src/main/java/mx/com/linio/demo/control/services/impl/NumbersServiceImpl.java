package mx.com.linio.demo.control.services.impl;

import mx.com.linio.demo.control.services.NumbersService;
import mx.com.linio.demo.model.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by macbookpro on 15/07/17.
 */
@Component
public class NumbersServiceImpl implements NumbersService {

    @Autowired
    private Configuration configuration;

    @Override
public List<String> generateLinioSerie() {

        Integer commonMultiple = getCommonMultiple(configuration.getConfigurations().keySet());

        List<String> lineoSerie = new ArrayList<String>();

        String lineoNumber;
        for(Integer index = configuration.getMinLimit(); index <= configuration.getMaxLimit(); index++) {

            lineoNumber = index.toString();

            for (Integer key : configuration.getConfigurations().keySet()) {
                lineoNumber = evaluateModule(index, key, configuration.getConfigurations().get(key), lineoNumber);
            }

            lineoNumber = evaluateModule(index, commonMultiple, configuration.getJoinMessage(), lineoNumber);

            lineoSerie.add(lineoNumber);

        }

        return lineoSerie;
    }

    private String evaluateModule(int number, int module, String messageSuccess, String messageFail){

        if(number % module == 0){

            return messageSuccess;

        }

        return messageFail;

    }

    private Integer getCommonMultiple(Set<Integer> numbers){
        Integer result = 1;
        for(Integer number: numbers){
            result = result * number;
        }
        return result;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
