package com.mabotalb.hibernate_jpa_demo;

import com.mabotalb.hibernate_jpa_demo.dao.StudentDAO;
import com.mabotalb.hibernate_jpa_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			readStudent(studentDAO);

			readStudents(studentDAO);

			readStudentsByLastName(studentDAO, "Abotalb");

			updateStudent(studentDAO);

			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students....");

		int rows = studentDAO.deleteAll();

		System.out.println("Number of deleted students = " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 4;

		System.out.println("Delete student with id " + id);

		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve ths student based on the id
		int id = 1;
		Student student = studentDAO.findById(id);

		// Change the first name
		student.setFirstName("Khalid");

		// Update the student
		studentDAO.update(student);

		// Display the updated student
		System.out.println("Updated Student: " + student);
	}

	private void readStudentsByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> students = studentDAO.findByLastName(lastName);

		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> students = studentDAO.findAll();

		// Display the list of students
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating a new student...");
        Student student = new Student("Ali", "Abotalb", "ali.abotalb@gmail.com");

        // Save the student to the database
        System.out.println("Saving the new student...");
        studentDAO.save(student);

        // Display the saved student id
        System.out.println("Saved student id: " + student.getId());

        // read the saved student by id
        System.out.println("Get student by id...");
        Student savedStudent = studentDAO.findById(student.getId());

		// Display the student
		System.out.println("Found student is " + savedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create the student objects
		System.out.println("Creating 3 new student...");
		Student student1 = new Student("Mohammad", "Mahmoud", "mohammad.mahmoud@gmail.com");
		Student student2 = new Student("Ahmed", "Morad", "ahmed.morad@gmail.com");
		Student student3 = new Student("Mahmoud", "Ali", "mahmoud.ali@gmail.com");

		// save the student to the database
		System.out.println("Saving the new students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a new student...");
		Student student = new Student("Mohammad", "Abotalb", "mohamed.abotalb@gmail.com");

		// save the student to the database
		System.out.println("Saving the new student...");
		studentDAO.save(student);

		// display the saved student id
		System.out.println("Saved student id: " + student.getId());
	}

}
