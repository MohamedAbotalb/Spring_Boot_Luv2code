package com.mabotalb.jpa_advanced_mappings;

import com.mabotalb.jpa_advanced_mappings.dao.AppDAO;
import com.mabotalb.jpa_advanced_mappings.entity.Course;
import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedMappingsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);

			findInstructor(appDAO);

			deleteInstructor(appDAO);

			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);

			createInstructorWithCourses(appDAO);
			
			findInstructorWithCourses(appDAO);

			findCoursesForInstructor(appDAO);

			findInstructorWithCoursesJoinFetch(appDAO);

			updateInstructor(appDAO);

			updateCourse(appDAO);

			deleteInstructor(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting Course with id: " + id);
		appDAO.deleteCourseById(id);

		System.out.println("Course deleted successfully!");
	}

	private void updateCourse(AppDAO appDAO) {

		int id = 10;

		System.out.println("Find Course with id " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course with id: " + id);
		course.setTitle("Updated Course");

		appDAO.update(course);

		System.out.println("Course updated successfully!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor with id: " + id);
		instructor.setLastName("Ali");

		appDAO.update(instructor);

		System.out.println("Instructor updated successfully!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("The instructor: " + instructor);

		System.out.println("The associated courses for the instructor: " + instructor.getCourses());

		System.out.println("Success!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding courses for instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("The instructor: " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// Set the courses to the associated instructor
		instructor.setCourses(courses);

		System.out.println("The associated courses: " + instructor.getCourses());

		System.out.println("Success!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		
		int id = 1;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("The instructor: " + instructor);
		System.out.println("The instructor's courses: " + instructor.getCourses());

		System.out.println("Success!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Mohamed", "Abotalb", "mohamed.abotalb@gmail.com");

		InstructorDetail details = new InstructorDetail("youtube.com/youtube", "coding");

		instructor.setInstructorDetail(details);

		// Create some courses
		Course course1 = new Course("Spring Boot 3, The Complete Guide");
		Course course2 = new Course("Spring Data JPA, The Complete Guide");

		// Add courses to the instructor
		instructor.add(course1);
        instructor.add(course2);

        // Save the instructor with courses
		// NOTE: this will also save the courses because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
        appDAO.save(instructor);

        System.out.println("Success!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 2;

		System.out.println("Deleting Instructor Detail with id " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Deleted!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int id = 2;
		InstructorDetail detail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: " + detail);

		System.out.println("The associated instructor: " + detail.getInstructor());

		System.out.println("Success!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;

        System.out.println("Deleting Instructor with id " + id);

        appDAO.deleteInstructorById(id);

        System.out.println("Deleted!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding Instructor with id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Found instructor " + instructor);
		System.out.println("The associated details only" + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Mohamed", "Abotalb", "mohamed.abotalb@gmail.com");

		InstructorDetail details = new InstructorDetail("youtube.com/youtube", "coding");

		instructor.setInstructorDetail(details);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Success!");
	}
}
