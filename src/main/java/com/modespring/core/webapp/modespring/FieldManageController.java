package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.Field;
import com.modespring.core.domain.Model;
import com.modespring.core.repository.FieldDao;
import com.modespring.core.service.ModelService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class FieldManageController extends BaseController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private FieldDao fieldDao;

    @RequestMapping(value = "model/{modelName}/field", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, HttpSession session, @PathVariable String modelName, Field field) {
        Model model =  modelService.getByName(modelName);
        List<Field> fieldList = modelService.getFieldList(modelName);
        field = fieldDao.save(field);
        fieldList.add(field);
        model.setFieldList(fieldList);
        model = modelService.update(model);
        modelAndView.setViewName("redirect:/modespring/model/" + modelName + "/field.html");
        return modelAndView;
    }

    @RequestMapping(value = "model/{modelName}/field", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, @PathVariable String modelName, Integer[] id, String[] name, String[] title, Integer[] delete) throws UnsupportedEncodingException {
//        List<Model> modelList = new ArrayList<Model>();
//        for (int i = 0; i < id.length; i++) {
//            Model model = modelService.getOne(id[i]);
//            model.setName(name[i]);
//            model.setTitle(title[i]);
//            modelList.add(model);
//        }
//        modelService.updateALL(modelList);
//        for (int i = 0; delete != null && i < delete.length; i++) {
//            modelService.delete(delete[i]);
//        }
//        Context.flush();
//        modelAndView.addObject("modelList", modelService.getAll());
        modelAndView.setViewName("redirect:/modespring/model/" + modelName + "/field.html");
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "model/{name}/field", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "model");
        Model model = modelService.getByName(name);
        modelAndView.addObject("currentModel", model);
        List<Field> fieldList = modelService.getFieldList(name);
        modelAndView.addObject("fieldList", fieldList);
        modelAndView.setViewName("/modespring/field");
        return modelAndView;
    }

}
