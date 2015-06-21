package com.modespring.core.webapp;

import com.modespring.core.domain.Field;
import com.modespring.core.domain.Model;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.FieldService;
import com.modespring.core.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class FieldManageController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private FieldService fieldService;

    @RequestMapping(value = "model/{modelName}/field", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, @PathVariable String modelName, Field field) {
        Model model = modelService.getByName(modelName);
        List<Field> fieldList = modelService.getFieldList(modelName);
        field = fieldService.create(field);
        fieldList.add(field);
        model.setFieldList(fieldList);
        modelService.update(model);
        modelAndView.setViewName("redirect:/modespring/model/" + modelName + "/field.html");
        return modelAndView;
    }

    @RequestMapping(value = "model/{modelName}/field", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, @PathVariable String modelName, Integer[] id, String[] name, String[] title, Integer[] delete) throws Exception {
        fieldService.updateALL(id, name, title);
        fieldService.deleteAll(delete);
        modelAndView.setViewName("redirect:/modespring/model/" + modelName + "/field.html");
        return modelAndView;
    }

    @RequestMapping(value = "model/{name}/field", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, @PathVariable String name) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("MospNodeName", "model");
        Model model = modelService.getByName(name);
        modelAndView.addObject("currentModel", model);
        List<Field> fieldList = modelService.getFieldList(name);
        modelAndView.addObject("fieldList", fieldList);
        modelAndView.setViewName("/modespring/field");
        return modelAndView;
    }

}
