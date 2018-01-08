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
import com.niuniu.vo.CourseQueryVO;
import com.niuniu.vo.QueryVO;
import com.niuniu.vo.ResponseVO;
@Controller
public class CourseController {
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(path={"/course/{id}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO<CourseDO> getCourse(@PathVariable("id") int id) {

		CourseDO course = courseService.getById(id);
		
		
		
		return new ResponseVO<CourseDO>(0, "", course);
	}
	
	
	@RequestMapping("/course")
	public String forwardCoursePage(Model model) {
		
		List<SpeakerDO> speakers = speakerService.listObject();
		List<SubjectDO> subjects = subjectService.listObject();
		List<CourseDO> courses = courseService.listObject();
		
		model.addAttribute("speakers", speakers);
		model.addAttribute("subjects", subjects);
		model.addAttribute("courses", courses);
		
		return "forward:/WEB-INF/jsp/course.jsp";
	}
	
	@RequestMapping("/courses")
	@ResponseBody
	public ResponseVO<BaseListDTO<CourseDO>> listCourseByQuery(CourseQueryVO queryVO) {
		
		BaseListDTO<CourseDO> dto = courseService.listObject(queryVO);
		
		return new ResponseVO<BaseListDTO<CourseDO>>(0, "", dto);
	}
	
	@RequestMapping(path={"/courses/{id}"}, method=RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateCourse(@PathVariable("id")Integer id, @RequestBody CourseDO courseDO) {

		courseService.updateObject(courseDO);
		System.out.println("修改成功");
		return new ResponseVO<String>(0, "", "修改成功");
	}
	
	@RequestMapping(path={"/courses/{id}"}, method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeCourses(@PathVariable("id") String id) {

		String[] idArray = new String[]{id};

		courseService.removeSome(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}
	
	
	@RequestMapping(path={"/courses"}, method=RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addGoods(@RequestBody CourseDO courseDO) {
		

		courseService.insertObject(courseDO);

		return new ResponseVO<String>(0, "", "添加成功");
	}
}
