package com.roditeli.restservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roditeli.api.service.IThemeService;
import com.roditeli.model.Theme;

@Controller
public class ThemeRestService {
	@Autowired
	private IThemeService service;

	private Map<String, Object> rezult;

	private static final String OBJECT = "object";
	private static final String MESSAGE = "message";
	private static final String THEME_NOT_FOUND = "Theme not found";
	private static final String ERROR = "Error, try it again";

	@RequestMapping(value = "/themes/{rubricId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getThemeCurrentRubric(
			@PathVariable("rubricId") int rubricId) {

		rezult = new HashMap<String, Object>();
		List<Theme> list = service.getThemeCurrentRubric(rubricId);
		if (list != null) {
			rezult.put(OBJECT, list);
		} else {
			rezult.put(MESSAGE, THEME_NOT_FOUND);
		}
		return rezult;
	}

	@RequestMapping(value = "/theme/", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> createTheme(
			@RequestBody Theme theme) {

		boolean isCompleted = service.create(theme);
		if (!isCompleted) {
			rezult = new HashMap<String, Object>();
			rezult.put(MESSAGE, ERROR);
		}
		return rezult;

	}

	@RequestMapping(value = "/themes/{userId}/{rubriId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> getThemeRubricUser(
			@PathVariable("userId") int userId,
			@PathVariable("rubricId") int rubricId) {

		rezult = new HashMap<String, Object>();
		List<Theme> list = service.getThemeRubricForUser(userId, rubricId);

		if (list != null) {
			rezult.put(OBJECT, list);
		} else {
			rezult.put(MESSAGE, THEME_NOT_FOUND);
		}
		return rezult;
	}

}
