package mx.com.linio.demo.control.services;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by macbookpro on 15/07/17.
 */
@Component
public interface NumbersService {
    List<String> generateLinioSerie();
}
