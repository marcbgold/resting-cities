package org.wecancodeit.restingcities;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestingCitiesController {

	@Resource
	StateRepository stateRepo;

	@Resource
	CityRepository cityRepo;

	@RequestMapping("/states")
	public Iterable<State> findAllStates() {
		return stateRepo.findAll();
	}

	@RequestMapping("/states/{abbreviation}")
	public State findOneState(@PathVariable String abbreviation) {
		return stateRepo.findByAbbreviationIgnoreCase(abbreviation);
	}

	// @RequestMapping("/show-courses")
	// public String findAllCourses(Model model) {
	// model.addAttribute("courses", courseRepo.findAllByOrderByNameAsc());
	// model.addAttribute("instructors", instructorRepo.findAll());
	// return "courses";
	// }
	//
	// @RequestMapping("/show-courses-by-id")
	// public String findAllCoursesSortedByName(Model model) {
	// model.addAttribute("courses", courseRepo.findAll());
	// model.addAttribute("instructors", instructorRepo.findAll());
	// return "courses";
	// }
	//
	// @RequestMapping("/course")
	// public String findOneCourse(@RequestParam(value = "id") Long id, Model model)
	// {
	// model.addAttribute("course", courseRepo.findOne(id));
	// return "course";
	// }
	//
	// @RequestMapping("/instructor")
	// public String findCoursesByInstructor(@RequestParam(value = "instructorId")
	// Long instructorId, Model model) {
	// if (instructorRepo.findOne(instructorId) != null) {
	// Instructor selectedInstructor = instructorRepo.findOne(instructorId);
	// model.addAttribute("instructor", selectedInstructor);
	// model.addAttribute("courses", courseRepo.findByInstructorId(instructorId));
	// return "instructor";
	// }
	// return "redirect:/show-courses";
	// }
	//
	// @RequestMapping("/add-course")
	// public String addCourse(String name, String description, Instructor
	// instructor) {
	// if (courseRepo.findByNameIgnoreCase(name) == null && instructor.getId() !=
	// null) {
	// courseRepo.save(new Course(name, description, instructor));
	// }
	// return "redirect:/show-courses";
	// }
	//
	// @RequestMapping("/delete-course")
	// public String deleteCourse(Long id) {
	// if (courseRepo.findOne(id) != null) {
	// courseRepo.delete(id);
	// }
	// return "redirect:/show-courses";
	// }

}
