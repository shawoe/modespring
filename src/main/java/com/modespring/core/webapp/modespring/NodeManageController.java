package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.Model;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ModelService;
import com.modespring.core.service.NodeService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class NodeManageController extends BaseController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "node");
        modelAndView.addObject("nodeList", Context.getNodeList());
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, Node node) {
        nodeService.create(node);
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, Integer[] id, String[] name, String[] title, Integer[] delete) throws UnsupportedEncodingException {
        nodeService.updateALL(id,name,title);
        try {
            nodeService.deleteAll(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }

    @RequestMapping(value = "node/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, @PathVariable Integer id) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "node");
        Node node = nodeService.getOne(id);
        modelAndView.addObject("node", node);
        modelAndView.addObject("nodeList", Context.getNodeList());
        List<Model> modelList = modelService.getAll();
        modelAndView.addObject("modelList", modelList);
        modelAndView.setViewName("/modespring/nodeDetail");
        return modelAndView;
    }

    @RequestMapping(value = "node/{id}", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable Integer id, Node node) {
        Model model = modelService.getOne(node.getModel().getId());
        node.setLevel(node.getParentNode().getLevel() + 1);
        node.setModel(model);
        nodeService.update(node);
        Context.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }
}
