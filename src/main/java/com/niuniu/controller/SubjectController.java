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
import com.niuniu.enitity.VideoDO;
import com.niuniu.service.CourseService;
import com.niuniu.service.SpeakerService;
import com.niuniu.service.SubjectService;
import com.niuniu.service.VideoService;
import com.niuniu.vo.QueryVO;
import com.niuniu.vo.ResponseVO;
import com.niuniu.vo.VideoQueryVO;



@Controller
public class SubjectController {
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(path={"/subject/{id}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO<SubjectDO> getSubject(@PathVariable("id") int id) {

		SubjectDO subject = subjectService.getById(id);
		
		System.out.println(subject);
		
		return new ResponseVO<SubjectDO>(0, "", subject);
	}
	
	
	@RequestMapping("/subject")
	public String forwardSubjectPage(Model model) {
		
		List<SpeakerDO> speakers = speakerService.listObject();
		List<SubjectDO> subjects = subjectService.listObject();
		List<CourseDO> courses = courseService.listObject();
		
		model.addAttribute("speakers", speakers);
		model.addAttribute("subjects", subjects);
		model.addAttribute("courses", courses);
		
		return "forward:/WEB-INF/jsp/subject.jsp";
	}
	
	@RequestMapping("/subjects")
	@ResponseBody
	public ResponseVO<BaseListDTO<SubjectDO>> listSubjectByQuery(QueryVO queryVO) {
		
		BaseListDTO<SubjectDO> dto = subjectService.listObject(queryVO);
		System.out.println(dto);
		return new ResponseVO<BaseListDTO<SubjectDO>>(0, "", dto);
	}
	
	@RequestMapping(path={"/subjects/{id}"}, method=RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateSubject(@PathVariable("id")Integer id, @RequestBody SubjectDO subjectDO) {

		subjectService.updateObject(subjectDO);
		System.out.println("修改成功");
		return new ResponseVO<String>(0, "", "修改成功");
	}
	
	@RequestMapping(path={"/subjects/{id}"}, method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeGoods(@PathVariable("id") String id) {

		String[] idArray = new String[]{id};

		subjectService.removeSome(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}
	
	
	@RequestMapping(path={"/subjects"}, method=RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addGoods(@RequestBody SubjectDO subjectDO) {
		

		subjectService.insertObject(subjectDO);

		return new ResponseVO<String>(0, "", "添加成功");
	}
}
