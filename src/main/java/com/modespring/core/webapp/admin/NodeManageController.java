package com.modespring.core.webapp.admin;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.Power;
import com.modespring.core.repository.PowerDao;
import com.modespring.core.service.NodeService;
import com.modespring.core.service.RoleService;
import com.modespring.core.service.UserService;
import com.modespring.core.webapp.BaseController;
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
@RequestMapping(value = "admin")
public class NodeManageController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, HttpSession session, Node node) {
        nodeService.create(node);
        Context.flush();
        modelAndView.addObject("nodeList", Context.getNodeList());
        return modelAndView;
    }

    @RequestMapping(value = "node", method = RequestMethod.POST)
    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, Integer[] id, String[] name, Integer[] delete) throws UnsupportedEncodingException {
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < id.length; i++) {
            Node node = nodeService.getOne(id[i]);
            node.setName(name[i]);
            nodeList.add(node);
        }
        nodeService.updateALL(nodeList);
        for (int i = 0; delete != null && i < delete.length; i++) {
            nodeService.delete(delete[i]);
        }
        Context.flush();
        modelAndView.addObject("nodeList", Context.getNodeList());
        return modelAndView;
    }

    @RequestMapping(value = "node_{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {
        Node node = nodeService.getOne(id);
        modelAndView.addObject("currentNode", node);
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.setViewName("/admin/nodeDetail");
        return modelAndView;
    }

    @RequestMapping(value = "node_{id}", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id, Node node) {
        nodeService.update(node);
        Context.flush();
        modelAndView.setViewName("redirect:/admin/node.html");
        return modelAndView;
    }
}
