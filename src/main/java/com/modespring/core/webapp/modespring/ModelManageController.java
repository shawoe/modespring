package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.Model;
import com.modespring.core.service.ModelService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class ModelManageController extends BaseController {

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "model", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "model");
        modelAndView.addObject("modelList", modelService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "model", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, Model model) {
        modelService.create(model);
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/model.html");
        return modelAndView;
    }

    @RequestMapping(value = "model", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, Integer[] id, String[] name, String[] title, Integer[] delete) throws UnsupportedEncodingException {
        modelService.updateALL(id,name,title);
        try {
            modelService.deleteAll(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/model.html");
        return modelAndView;
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, @PathVariable Integer id) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "model");
        Model model = modelService.getOne(id);
        modelAndView.addObject("currentModel", model);
        modelAndView.setViewName("/modespring/modelDetail");
        return modelAndView;
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable Integer id, Model model) {
        modelService.update(model);
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/model.html");
        return modelAndView;
    }
}
