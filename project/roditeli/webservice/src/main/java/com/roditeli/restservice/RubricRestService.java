package com.roditeli.restservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roditeli.api.service.IRubricService;
import com.roditeli.model.Rubric;

@Controller
public class RubricRestService {
	@Autowired
	private IRubricService service;
	
	private Map<String, Object> rezult;

	private static final String OBJECT = "object";
	private static final String MESSAGE = "message";
	private static final String ERROR_SEREVR = "Server error";

	public RubricRestService() {
	}

//	@RequestMapping(value = "/rubric/{id}", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody Map<String, Object> getRubricById(
//			@PathVariable("id") int id) {
//
//		rezult = new HashMap<String, Object>();
//
//		Rubric rubric = service.getById(id);
//
//		if (rubric != null) {
//			rezult.put(OBJECT, rubric);
//		} else {
//			rezult.put(MESSAGE, USER_NOT_FOUND);
//		}
//		return rezult;
//
//	}

	@RequestMapping(value = "/rubrics", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getListRubric() {

		rezult = new HashMap<String, Object>();
		List<Rubric> list = service.getAll();

		if (list != null) {
			rezult.put(OBJECT, list);
		} else {
			rezult.put(MESSAGE, ERROR_SEREVR);
		}
		return rezult;
	}

}
