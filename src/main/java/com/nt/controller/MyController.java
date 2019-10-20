package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nt.constants.AppConstants;
import com.nt.entity.EmployeeEntity;
import com.nt.model.Employee;
import com.nt.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService service;
	private EmployeeEntity empEntity = null;
	private Employee emp = null;

	/**
	 * This method is used to render to Dashboard
	 * 
	 * @param
	 * @return String
	 */
	@GetMapping(value = "/getDashboard")
	public String getDashboard() {
		return AppConstants.EMPLOYEE_DASHBOARD_VIEW;
	}

	/**
	 * This method is used to load the form with empty model object
	 * 
	 * @param Model
	 * @return String
	 */
	@GetMapping(value = "/loadForm")
	public String loadForm(Model map) {
		emp = new Employee();
		map.addAttribute(AppConstants.EMPLOYEE, emp);
		map.addAttribute("genderList", Arrays.asList("Male", "Female", "Other"));
		return AppConstants.EMPLOYEE_REGISTER_VIEW;
	}

	/**
	 * This method is used to register an employee
	 * 
	 * @param Model, @ModelAtribute
	 * @return String
	 */
	@PostMapping(value = "/addEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp, Model map) {
		empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emp, empEntity);
		map.addAttribute(AppConstants.EMPLOYEE_SUCCESS_MESSAGE, service.saveEmployee(empEntity));
		return AppConstants.EMPLOYEE_REGISTER_VIEW;
	}

	/**
	 * This method is used to show all employee list
	 * 
	 * @param
	 * @return String
	 */
	@GetMapping(value = "/getAll")
	public String getAllEmployee(Model map) {
		map.addAttribute(AppConstants.EMPLOYEE_LIST, service.getAllEmployee());
		return AppConstants.EMPLOYEE_LIST_VIEW;
	}

	/**
	 * This method is used to edit the employee details based on the ID
	 * 
	 * @param Model, @RequestParam
	 * @return String
	 */
	@GetMapping(value = "/editEmployee")
	public String editEmployee(@RequestParam("id") int id, Model map) {
		empEntity = service.getByID(id);
		emp = new Employee();
		BeanUtils.copyProperties(empEntity, emp);
		map.addAttribute(AppConstants.EXISTED_EMPLOYEE, emp);
		map.addAttribute("genderList", Arrays.asList("Male", "Female", "Other"));
		return AppConstants.EMPLOYEE_EDIT_VIEW;
	}

	/**
	 * This method is used to update an employee based on ID
	 * 
	 * @param Model, @ModelAtribute
	 * @return String
	 */
	@PostMapping(value = "/updateEmployee")
	public String updateEmployee(@ModelAttribute("exEmployee") Employee emp, Model map) {
		empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(emp, empEntity);
		service.saveEmployee(empEntity);
		map.addAttribute(AppConstants.EXISTED_EMPLOYEE, emp);
		return "redirect:getAll";
	}

	/**
	 * This method is used to delete an employee based on ID
	 * 
	 * @param Model, @RequestPAram
	 * @return String
	 */
	@GetMapping(value = "/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id, Model map) {
		empEntity = service.getByID(id);
		boolean flag = service.deleteEmployee(empEntity);
		if (flag)
			map.addAttribute(AppConstants.EMPLOYEE_DELETE_MESSAGE, "Deleted");
		else
			map.addAttribute(AppConstants.EMPLOYEE_DELETE_MESSAGE, "Not Deleted");
		return "redirect:getAll";
	}

	/**
	 * This method is used to render to EmployeeId page
	 * 
	 * @param
	 * @return String
	 */
	@GetMapping(value = "/getUserByID")
	public String getUserByID() {
		return AppConstants.EMPLOYEE_BY_ID_VIEW;
	}

	/**
	 * This method is used to render to EmailById page
	 * 
	 * @param
	 * @return String
	 */
	@GetMapping(value = "/mailById")
	public String getEmailById() {
		return AppConstants.EMPLOYEE_EMAIL_BY_ID_VIEW;
	}

	@GetMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee getUserByID(@RequestParam("id") int id) {
		emp = new Employee();
		empEntity = service.getByID(id);
		BeanUtils.copyProperties(empEntity, emp);
		return emp;
	}

	@GetMapping(value = "/getEmailById", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String findEmailbyId(@RequestParam("id") int id) {
		return service.findEmailbyId(id);
	}

	@GetMapping(value = "/getEmails", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> findAllUserEmails() {
		return service.findAllUserEmails();
	}
}