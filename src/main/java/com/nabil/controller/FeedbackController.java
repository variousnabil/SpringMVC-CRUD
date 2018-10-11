package com.nabil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.nabil.dao.FeedbackDAO;
import com.nabil.pojo.Feedback;

@Controller
public class FeedbackController {

	@Autowired
	FeedbackDAO fdao;

	@RequestMapping("/")
	public RedirectView home() {
		return new RedirectView("/feedback");
	}

	@RequestMapping("/feedback")
	public ModelAndView AllFeedback() {
		ModelAndView mv = new ModelAndView("feedbacks.html");
		mv.addObject("feedbacks", fdao.findAll());
		return mv;
	}

	@RequestMapping("/feedback/add")
	public String addForm() {
		return "add.html";
	}
	

	@RequestMapping("/feedback/addFeedback")
	public RedirectView addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		fdao.save(feedback);
		System.out.println("added feedback : " + feedback);
		return new RedirectView("/feedback");
	}

	@RequestMapping("/feedback/edit")
	public ModelAndView editFeedback() {
		ModelAndView mv = new ModelAndView("update.html");
		mv.addObject("feedbacks",fdao.findAll());
		return mv;
	}
	
	@RequestMapping("/feedback/edit/{id}")
	public ModelAndView updateFeedbackById(@PathVariable(name = "id") Integer idfeedback) {
		ModelAndView mv = new ModelAndView("edit.html");
		mv.addObject("feedback", fdao.findById(idfeedback));
		System.out.println(fdao.findById(idfeedback));
		return mv;
	}

	@RequestMapping("/feedback/edit/editFeedback")
	public RedirectView updateFeedback(@ModelAttribute("feedback") Feedback feedback) {
		fdao.save(feedback);
		System.out.println("updateded feedback : " + feedback);
		return new RedirectView("/feedback");
	}

	@RequestMapping("/feedback/delete/{id}")
	public RedirectView deleteFeedback(@PathVariable(name = "id") Integer idfeedback) {
		fdao.deleteById(idfeedback);
		return new RedirectView("/feedback");
	}

}
