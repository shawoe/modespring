package com.modespring.core.webapp;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.NodeService;
import com.modespring.core.webapp.access.BaseController;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

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

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public ModelAndView upload(ModelAndView modelAndView, HttpSession session) {
        return modelAndView;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelAndView uploadAction(ModelAndView modelAndView, HttpSession session, @RequestParam MultipartFile[] file) throws IOException {
        for(MultipartFile myfile : file){
            if(myfile.isEmpty()){
                System.out.println("文件未上传");
            }else{
                System.out.println("文件长度: " + myfile.getSize());
                System.out.println("文件类型: " + myfile.getContentType());
                System.out.println("文件名称: " + myfile.getName());
                System.out.println("文件原名: " + myfile.getOriginalFilename());
                System.out.println("========================================");
                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
                String realPath = session.getServletContext().getRealPath("/WEB-INF/upload");
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
            }
        }
        modelAndView.addObject("message","success");
        return modelAndView;
    }

    @RequestMapping(value = "{name}/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String name, @PathVariable Integer id) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        Article article = articleService.getOne(id);
        modelAndView.addObject("article", article);
        Node node = nodeService.getByName(name);
        modelAndView.addObject("node", node);
        String template = node.getTemplate();
        if (template == null || template.isEmpty()) {
            modelAndView.setViewName("/article");
        } else {
            modelAndView.setViewName(template);
        }
        return modelAndView;
    }

    @RequestMapping(value = "{name}/write", method = RequestMethod.GET)
    public ModelAndView write(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        Node node = nodeService.getByName(name);
        modelAndView.addObject("node", node);
        modelAndView.setViewName("write");
        return modelAndView;
    }

    @RequestMapping(value = "{name}/write", method = RequestMethod.POST)
    public ModelAndView writeAction(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.setViewName("write");
        return modelAndView;
    }
}
