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
import com.niuniu.vo.ResponseVO;
import com.niuniu.vo.VideoQueryVO;


@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(path={"/video/{id}"}, method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO<VideoDO> getVideo(@PathVariable("id") int id) {

		VideoDO video = videoService.getById(id);
		
		System.out.println(video);
		
		return new ResponseVO<VideoDO>(0, "", video);
	}
	
	
	@RequestMapping("/video")
	public String forwardVideoPage(Model model) {
		
		List<SpeakerDO> speakers = speakerService.listObject();
		List<SubjectDO> subjects = subjectService.listObject();
		List<CourseDO> courses = courseService.listObject();
		
		model.addAttribute("speakers", speakers);
		model.addAttribute("subjects", subjects);
		model.addAttribute("courses", courses);
		
		return "forward:/WEB-INF/jsp/video.jsp";
	}
	
	@RequestMapping("/videos")
	@ResponseBody
	public ResponseVO<BaseListDTO<VideoDO>> listVideoByQuery(VideoQueryVO queryVO) {
		
		BaseListDTO<VideoDO> dto = videoService.listObject(queryVO);
		
		return new ResponseVO<BaseListDTO<VideoDO>>(0, "", dto);
	}
	
	@RequestMapping(path={"/videos"}, method=RequestMethod.PUT)
	@ResponseBody
	public ResponseVO<String> updateVideo(@RequestBody VideoDO videoDO) {

		videoService.updateObject(videoDO);
		System.out.println("修改成功");
		return new ResponseVO<String>(0, "", "修改成功");
	}
	
	@RequestMapping(path={"/videos/{id}"}, method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseVO<String> removeGoods(@PathVariable("id") String id) {

		String[] idArray = new String[]{id};

		videoService.removeObject(idArray);

		return new ResponseVO<String>(0, "", "删除成功");
	}
	
	
	@RequestMapping(path={"/videos"}, method=RequestMethod.POST)
	@ResponseBody
	public ResponseVO<String> addGoods(@RequestBody VideoDO videoDO) {
		

		videoService.insertObject(videoDO);

		return new ResponseVO<String>(0, "", "添加成功");
	}
}
