package com.modespring.core.webapp;

import com.alibaba.fastjson.JSONObject;
import com.modespring.core.common.FileUploadUtil;
import com.modespring.core.domain.Article;
import com.modespring.core.domain.Field;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.NodeService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shawoe on 2015/5/22.
 */
@Controller
@RequestMapping
public class ArticleController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "uploadAjax", method = RequestMethod.POST)
    @ResponseBody
    public String uploadAjax(HttpSession session, @RequestParam("file") MultipartFile[] file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        for (MultipartFile cur_file : file) {
            String realPath = session.getServletContext().getRealPath("/images");
            try {
                String fileName = FileUploadUtil.uploadFile(cur_file, realPath);
                map.put("success", true);
                map.put("file_path", "/images/" + fileName);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("msg", "文件未成功上传");
            }
        }
        return objectMapper.writeValueAsString(new JSONObject(map));
    }

    @RequestMapping(value = "{nodeName}/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, @PathVariable String nodeName, @PathVariable Integer id) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        Article article = articleService.getOne(id);
        modelAndView.addObject("article", article);
        Node node = nodeService.getByName(nodeName);
        modelAndView.addObject("node", node);
        String template = node.getTemplate();
        if (template == null || template.isEmpty()) {
            modelAndView.setViewName("/article");
        } else {
            modelAndView.setViewName(template);
        }
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/write", method = RequestMethod.GET)
    public ModelAndView write(ModelAndView modelAndView, @PathVariable String nodeName) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        Node node = nodeService.getByName(nodeName);
        modelAndView.addObject("node", node);
        modelAndView.setViewName("write");
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/write", method = RequestMethod.POST)
    public ModelAndView writeAction(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName, Article article, @RequestParam MultipartFile titleImageFile, String fieldName[], String fieldTitle[], String fieldValue[]) throws Exception {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        List<Field> fieldList = articleService.addFieldValue(fieldName, fieldTitle, fieldValue);
        Node node = nodeService.getByName(nodeName);
        article.setNode(node);
        article.setName(articleService.createUniqueName(node));
        article.setValueList(fieldList);
        String realPath = session.getServletContext().getRealPath("/images");
        String fileName = FileUploadUtil.uploadFile(titleImageFile, realPath);
        article.setTitleImage("/images/" + fileName);
        article = articleService.create(article);
        modelAndView.setViewName("redirect:/" + nodeName + "/" + article.getId() + ".html");
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, @PathVariable String nodeName, @PathVariable Integer id) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        Node node = nodeService.getByName(nodeName);
        modelAndView.addObject("node", node);
        Article article = articleService.getOne(id);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editAction(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName, @PathVariable Integer id, Article article, @RequestParam MultipartFile titleImageFile, String fieldName[], String fieldTitle[], String fieldValue[]) throws Exception {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        List<Field> fieldList = articleService.addFieldValue(fieldName, fieldTitle, fieldValue);
        Node node = nodeService.getByName(nodeName);
        article.setNode(node);
        article.setName(articleService.createUniqueName(node));
        article.setValueList(fieldList);
        if (!titleImageFile.isEmpty()) {
            String realPath = session.getServletContext().getRealPath("/images");
            String fileName = FileUploadUtil.uploadFile(titleImageFile, realPath);
            article.setTitleImage("/images/" + fileName);
        }
        article = articleService.create(article);
        modelAndView.setViewName("redirect:/" + nodeName + "/" + article.getId() + ".html");
        return modelAndView;
    }

}
