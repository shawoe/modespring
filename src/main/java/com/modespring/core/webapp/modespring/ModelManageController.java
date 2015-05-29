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

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class ModelManageController extends BaseController {

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "model", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("modelList", modelService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "model", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, HttpSession session, Model model) {
        modelService.create(model);
        Context.flush();
        modelAndView.addObject("modelList", modelService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "model", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, Integer[] id, String[] name, String[] title, Integer[] delete) throws UnsupportedEncodingException {
        List<Model> modelList = new ArrayList<Model>();
        for (int i = 0; i < id.length; i++) {
            Model model = modelService.getOne(id[i]);
            model.setName(name[i]);
            model.setTitle(title[i]);
            modelList.add(model);
        }
        modelService.updateALL(modelList);
        for (int i = 0; delete != null && i < delete.length; i++) {
            modelService.delete(delete[i]);
        }
        Context.flush();
        modelAndView.addObject("modelList", modelService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {
        Model model = modelService.getOne(id);
        modelAndView.addObject("currentModel", model);
        modelAndView.setViewName("/modespring/modelDetail");
        return modelAndView;
    }

    @RequestMapping(value = "model/{id}", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id, Model model) {
        modelService.update(model);
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/model.html");
        return modelAndView;
    }
}
