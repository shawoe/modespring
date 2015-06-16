package com.modespring.core.webapp;

import com.alibaba.fastjson.JSONObject;
import com.modespring.core.domain.Article;
import com.modespring.core.domain.Field;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.FieldService;
import com.modespring.core.service.NodeService;
import com.modespring.core.webapp.access.BaseController;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shawoe on 2015/5/22.
 */
@Controller
@RequestMapping
public class ArticleController extends BaseController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private FieldService fieldService;

    @RequestMapping(value = "uploadAjax", method = RequestMethod.POST)
    @ResponseBody
    public String uploadAjax(ModelAndView modelAndView, HttpSession session, @RequestParam("file") MultipartFile[] file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        for (MultipartFile cur_file : file) {
            if (cur_file.isEmpty()) {
                map.put("msg", "文件未上传，请选择你要上传的文件");
            } else {
                String realPath = session.getServletContext().getRealPath("/images");
                String fileName = cur_file.getOriginalFilename();
                if(fileName.indexOf('.') != -1){
                    String fileExt = fileName.substring(fileName.lastIndexOf('.'));
                    DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
                    String newFileName = cur_file.getSize() + "-"  + format.format(new Date())+ fileExt;
                    map.put("success", true);
                    map.put("file_path", "/images/" + newFileName);
                    try {
                        FileUtils.copyInputStreamToFile(cur_file.getInputStream(), new File(realPath, newFileName));

                    } catch (IOException e) {
                        e.printStackTrace();
                        map.put("success", false);
                        map.put("msg", "文件未成功上传");
                    }
                }
            }
        }
        return objectMapper.writeValueAsString(new JSONObject(map));
    }

    @RequestMapping(value = "{nodeName}/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName, @PathVariable Integer id) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.addObject("site", Context.getSite());
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
    public ModelAndView write(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.addObject("site", Context.getSite());
        Node node = nodeService.getByName(nodeName);
        modelAndView.addObject("node", node);
        modelAndView.setViewName("write");
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/write", method = RequestMethod.POST)
    public ModelAndView writeAction(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName, Article article,@RequestParam MultipartFile[] titleImageFile, String fieldName[], String fieldTitle[], String fieldValue[]) throws IOException {
        modelAndView.addObject("nodeList", Context.getNodeList());
        List<Field> fieldList = new ArrayList<>();
        if (fieldName != null) {
            for (int i = 0; i < fieldName.length; i++) {
                Field field = new Field();
                field.setName(fieldName[i]);
                field.setTitle(fieldTitle[i]);
                field.setValue(fieldValue[i]);
                fieldList.add(field);
            }
        }
        fieldList = fieldService.createALL(fieldList);
        Node node = nodeService.getByName(nodeName);
        article.setNode(node);
        article.setValueList(fieldList);
        // 这段代码我一定会重构的！
        for (MultipartFile cur_file : titleImageFile) {
            if (cur_file.isEmpty()) {
                System.out.println("文件未上传，请选择你要上传的文件");
            } else {
                String realPath = session.getServletContext().getRealPath("/images");
                String fileName = cur_file.getOriginalFilename();
                if(fileName.indexOf('.') != -1){
                    String fileExt = fileName.substring(fileName.lastIndexOf('.'));
                    DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
                    String newFileName = cur_file.getSize() + "-"  + format.format(new Date())+ fileExt;
                    article.setTitleImage("/images/" + newFileName);
                    try {
                        FileUtils.copyInputStreamToFile(cur_file.getInputStream(), new File(realPath, newFileName));
                        article.setTitleImage("/images/" + newFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        article = articleService.create(article);
        modelAndView.setViewName("redirect:/" + nodeName + "/" + article.getId() + ".html");
        return modelAndView;
    }
}
