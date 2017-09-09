package com.se.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.se.Domain.Business.Information;
import com.se.Service.Business.DisplayService;
import com.se.Service.Business.Impl.DisplayServiceImpl;
import com.se.Service.Business.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;

@Controller
@RequestMapping("/")
public class DisplayController {
	@Autowired
	private PeriodRepository periodRepository;
	@Autowired
	private DisplayService displayService;
	@Autowired
	private InformationService informationService;
	
	@RequestMapping(value="/display/class")
	public String initDisplay(Model model){
		List<Period> periods = new ArrayList<Period>();
		periods = periodRepository.findAll();
		model.addAttribute("periods", periods);
		model.addAttribute("display",displayService.findDisplay());
		model.addAttribute("information",informationService.findFirst());
		return "/display/class";
	}
	
	@RequestMapping(value="/editDisplay/introduction")
	public String initEditIntroduction(Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/introduction";
	}
	
	@RequestMapping(value="/editDisplay/bulletin")
	public String initEditBulletin(Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/bulletin";
	}
	
	@RequestMapping(value="/editDisplay/album")
	public String initEditAlbum(Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/album";
	}
	
	@RequestMapping(value="/editDisplay/uploadAlbum", method = RequestMethod.POST)
	public  ResponseEntity<?> uploadAlbum(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) throws IllegalStateException, IOException{
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/imgupload/");
        File targetFile = new File(filePath);
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        } 
        file.transferTo(new File(filePath+fileName));
        return ResponseEntity.ok(filePath);

	}
}