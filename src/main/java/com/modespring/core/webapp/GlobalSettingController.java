package com.modespring.core.webapp;

import com.modespring.core.common.FileUploadUtil;
import com.modespring.core.domain.pojo.Site;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/6/11.
 */
@Controller
@RequestMapping(value = "modespring")
public class GlobalSettingController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "global", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("site", contextService.getSite());
        modelAndView.addObject("MospNodeName", "global");
        modelAndView.setViewName("/modespring/global");
        return modelAndView;
    }

    @RequestMapping(value = "global", method = RequestMethod.POST)
    public ModelAndView set(ModelAndView modelAndView, HttpSession session, Site site, @RequestParam("logoFile") MultipartFile logoFile) throws Exception {
        if (!logoFile.isEmpty()) {
            String realPath = session.getServletContext().getRealPath("/images");
            String logoName = FileUploadUtil.uploadFile(logoFile, realPath);
            site.setLogo("/images/" + logoName);
        }
        siteService.update(site);
        contextService.flush();
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("site", contextService.getSite());
        modelAndView.addObject("MospNodeName", "global");
        modelAndView.setViewName("redirect:/modespring/global.html");
        return modelAndView;
    }

}
