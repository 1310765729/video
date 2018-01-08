package com.niuniu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niuniu.dto.BaseListDTO;
import com.niuniu.enitity.CourseDO;
import com.niuniu.enitity.SpeakerDO;
import com.niuniu.enitity.SubjectDO;
import com.niuniu.service.CourseService;
import com.niuniu.service.SpeakerService;
import com.niuniu.service.SubjectService;
import com.niuniu.service.VideoService;
import com.niuniu.vo.QueryVO;
import com.niuniu.vo.ResponseVO;

@Controller
public class SpeakerController {
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(path={"/speaker/{id}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO<SpeakerDO> getSpeaker(@PathVariable("id") int id) {

		SpeakerDO speaker = speakerService.getById(id);
		
		System.out.println(speaker);
		
		return new ResponseVO<SpeakerDO>(0, "", speaker);
	}
	
	
	@RequestMapping("/speaker")
	public String forwardSpeakerPage(Model model) {
		
		List<SpeakerDO> speakers = speakerService.listObject();
		List<SubjectDO> subjects = subjectService.listObject();
		List<CourseDO> courses = courseService.listObject();
		
		model.addAttribute("speakers", speakers);
		model.addAttribute("subjects", subjects);
		model.addAttribute("courses", courses);
		
		return "forward:/WEB-INF/jsp/speaker.jsp";
	}
	
	@RequestMapping("/speakers")
	@ResponseBody
	public ResponseVO<BaseListDTO<SpeakerDO>> listSpeakerByQuery(QueryVO queryVO) {
		
		BaseListDTO<SpeakerDO> dto = speakerService.listObject(queryVO);
		System.out.println("speaker讲师"+dto);
		return new ResponseVO<BaseListDTO<SpeakerDO>>(0, "", dto);
	}
	
	@RequestMapping(path={"/speakers/{id}"}, method=RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateSpeaker(@PathVariable("id")Integer id, @RequestBody SpeakerDO speakerDO) {

		speakerService.updateObject(speakerDO);
		System.out.println("修改成功");
		return new ResponseVO<String>(0, "", "修改成功");
	}
	
	@RequestMapping(path={"/speakers/{id}"}, method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeGoods(@PathVariable("id") String id) {

		String[] idArray = new String[]{id};

		speakerService.removeSome(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}
	
	
	@RequestMapping(path={"/speakers"}, method=RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addGoods(@RequestBody SpeakerDO speakerDO) {
		

		speakerService.insertObject(speakerDO);

		return new ResponseVO<String>(0, "", "添加成功");
	}
}
