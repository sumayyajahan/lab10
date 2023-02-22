package com.example.lab10new.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import java.text.NumberFormat;

@ControllerAdvice
public class GlobalBindingInitializer {
    @InitBinder
    public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
        //binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
    }
}
