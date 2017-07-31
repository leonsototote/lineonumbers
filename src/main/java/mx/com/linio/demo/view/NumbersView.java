package mx.com.linio.demo.view;

import mx.com.linio.demo.control.services.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by macbookpro on 15/07/17.
 */
@Controller
@RequestMapping("/")
public class NumbersView {

    @Autowired
    private NumbersService numbersService;

    @GetMapping
    public ModelAndView list() {

        return new ModelAndView("layout","numbers",numbersService.generateLinioSerie());
    }

}
