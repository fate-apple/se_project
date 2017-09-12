package com.se.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.se.Domain.Business.Information;
import com.se.Domain.Business.Profile;
import com.se.Service.Business.CourseSerivce;
import com.se.Service.Business.DisplayService;
import com.se.Service.Business.Impl.DisplayServiceImpl;
import com.se.Service.Business.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Autowired
	private CourseSerivce courseService;

	@RequestMapping(value="/display/prevInform")
	public  ResponseEntity<?> prevInform() {
        return ResponseEntity.ok(1);
	}
	
	@RequestMapping(value="/display/nextInform")
	public  ResponseEntity<?> nextInform() {
        return ResponseEntity.ok(1);
	}
	
	@RequestMapping(value="/display/class")
	public String initDisplay(Model model){
		List<Period> periods = new ArrayList<Period>();
		periods = periodRepository.findAll();
		model.addAttribute("periods", periods);
		model.addAttribute("display",displayService.findDisplay());
		model.addAttribute("information",informationService.findFirst());
//		model.addAttribute("tmpcourse", courseService.findNextCourse().get(0));
//		model.addAttribute("nextcourse", courseService.findNextCourse().get(1));
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
	
	//修改introduction(未完成)
	@RequestMapping(value="/editDisplay/editIntroduction")
	public String editIntroduction(@RequestParam String content,Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/introduction";
	}
	
	//修改bulletin(未完成) id为1、2、3代表不同content和title
	@RequestMapping(value="/editDisplay/editBulletin")
	public String editBulletin(@RequestParam String content,@RequestParam String title,
			@RequestParam int id,Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/introduction";
	}
	
	@RequestMapping(value="/editDisplay/album")
	public String initEditAlbum(Model model){
		model.addAttribute("display",displayService.findDisplay());
		return "/editDisplay/album";
	}
	
	@RequestMapping(value="/editDisplay/uploadAlbum", method = RequestMethod.POST)
	public  ResponseEntity<?> uploadAlbum(@RequestParam MultipartFile file,@RequestParam int id,
            HttpServletRequest request) throws IllegalStateException, IOException{
		Profile picture = displayService.UploadPictures(file,id);
        return ResponseEntity.ok(picture.getResource());

	}
}