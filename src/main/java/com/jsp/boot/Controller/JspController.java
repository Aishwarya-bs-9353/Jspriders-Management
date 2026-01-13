package com.jsp.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.boot.Entity.JspEntity;
import com.jsp.boot.Repository.JspRepo;

@Controller
public class JspController {
	@Autowired
	JspRepo jspRepo;
	@GetMapping({"/","main"})
	public String loadMain()
	{
		return "main.html";
	}
	
	@GetMapping("add")
	public String loadAdd()
	{
		return "add.html";
	}
	
	@PostMapping("add")
	public String addData(JspEntity jspEntity, RedirectAttributes attributes)
	{
		jspRepo.save(jspEntity);
		attributes.addFlashAttribute("message","data added successfully");
		return "redirect:/main";
	}
	
	@GetMapping("manage")
	public String loadManage(JspEntity jspEntity,ModelMap map)
	{
		List<JspEntity> list = jspRepo.findAll();
		map.put("jsp", list);
		return "manage.html";
	}
	
	@GetMapping("delete")
	public String deleteData(@RequestParam Long id, RedirectAttributes attributes)
	{
		jspRepo.deleteById(id);
		attributes.addFlashAttribute("message","data deleted successfully");
		return "redirect:/manage";
	}
	
	@GetMapping("edit")
	public String editData(@RequestParam Long id, ModelMap map)
	{
		JspEntity jspEntity=jspRepo.findById(id).orElseThrow();
		map.put("edit", jspEntity);
		return "edit.html";
	}
}
