package com.modespring.core.webapp;

import com.modespring.core.domain.Node;
import com.modespring.core.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class NodeController extends BaseController {

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
    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, Integer[] id, String[] title, Integer[] parentId, Integer[] delete) throws UnsupportedEncodingException {
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < id.length; i++) {
            Node node = nodeService.getOne(id[i]);
            node.setTitle(title[i]);
            if (parentId[i] > 0) {
                Node parentNode = nodeService.getOne(parentId[i]);
                node.setLevel(parentNode.getLevel() + 1);
                node.setParentNode(parentNode);
            }
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


}
