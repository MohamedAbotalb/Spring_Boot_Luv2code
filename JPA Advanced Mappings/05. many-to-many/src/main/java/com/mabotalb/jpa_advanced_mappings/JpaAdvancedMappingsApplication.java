package com.mabotalb.jpa_advanced_mappings;

import com.mabotalb.jpa_advanced_mappings.dao.AppDAO;
import com.mabotalb.jpa_advanced_mappings.entity.*;
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
			
			createCourseAndStudent(appDAO);
			
			findCourseWithStudents(appDAO);

			findStudentWithCourses(appDAO);

			addMoreCoursesForStudent(appDAO);

			deleteCourse(appDAO);

			deleteStudent(appDAO);
			
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting student with id " + id);
		appDAO.deleteStudentById(id);

		System.out.println("Success!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 2;
		Student student = appDAO.findStudentWithCoursesByStudentId(id);

		// Create a new course
		Course course1 = new Course("Advanced Java");
        Course course2 = new Course("Spring Boot");

        // Add courses to the student
        student.addCourse(course1);
        student.addCourse(course2);

        // Update the student with the new courses
        System.out.println("Updating Student: " + student);
        System.out.println("Associated Courses: " + student.getCourses());

		appDAO.update(student);

        System.out.println("Success!");
	}

	private void findStudentWithCourses(AppDAO appDAO) {

		int id = 1;

		Student student = appDAO.findStudentWithCoursesByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("Success!");
	}

	private void findCourseWithStudents(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseWithStudentsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Success!");
	}

	private void createCourseAndStudent(AppDAO appDAO) {

		// Create a course
		Course course = new Course("MySQL The Complete Developer Course");

		// Create a students
		Student student1 = new Student("Mohamed", "Abotalb", "mohamed.abotalb@gmail.com");
		Student student2 = new Student("Ahmed", "Abotalb", "ahmed.abotalb@gmail.com");

		// Add students to the course
		course.addStudents(student1);
		course.addStudents(student2);

		// Save the course with associated students
		System.out.println("Saving course: " + course);
		System.out.println("Associated students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Success!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Delete Course with id " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Success!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Find Course with id " + id);
		Course course = appDAO.findCourseWithReviewsByCourseId(id);

        System.out.println("Course: " + course);
		System.out.println("Course Reviews: " + course.getReviews());

		System.out.println("Success!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// Create a course
		Course course = new Course("Spring Boot with JPA");

		// Create reviews for the course
		Review review1 = new Review("Great course!");
		Review review2 = new Review("Fantastic course!");

		course.addReviews(review1);
		course.addReviews(review2);

        System.out.println("Course: " + course);
		System.out.println("Course Reviews: " + course.getReviews());

		// Save the course
		appDAO.save(course);

		System.out.println("Success!");
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
