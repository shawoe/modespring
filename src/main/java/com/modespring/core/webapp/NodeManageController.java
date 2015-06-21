package com.modespring.core.webapp;

import com.modespring.core.domain.Model;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.ModelService;
import com.modespring.core.service.NodeService;
import org.apache.commons.configuration.ConfigurationException;
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
public class NodeManageController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("MospNodeName", "node");
        modelAndView.addObject("nodeList", contextService.getNodeList());
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, Node node) throws ConfigurationException {
        nodeService.create(node);
        contextService.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, Integer[] id, String[] name, String[] title, Integer[] delete) throws UnsupportedEncodingException, ConfigurationException {
        nodeService.updateALL(id,name,title);
        try {
            nodeService.deleteAll(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        contextService.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }

    @RequestMapping(value = "node/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, @PathVariable Integer id) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("MospNodeName", "node");
        Node node = nodeService.getOne(id);
        modelAndView.addObject("node", node);
        modelAndView.addObject("nodeList", contextService.getNodeList());
        List<Model> modelList = modelService.getAll();
        modelAndView.addObject("modelList", modelList);
        modelAndView.setViewName("/modespring/nodeDetail");
        return modelAndView;
    }

    @RequestMapping(value = "node/{id}", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable Integer id, Node node) throws ConfigurationException {
        Model model = modelService.getOne(node.getModel().getId());
        node.setLevel(node.getParentNode().getLevel() + 1);
        node.setModel(model);
        nodeService.update(node);
        contextService.flush();
        modelAndView.setViewName("redirect:/modespring/node.html");
        return modelAndView;
    }
}
