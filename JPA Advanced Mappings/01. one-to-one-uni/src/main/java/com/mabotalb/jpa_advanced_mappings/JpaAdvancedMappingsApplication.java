package com.mabotalb.jpa_advanced_mappings;

import com.mabotalb.jpa_advanced_mappings.dao.AppDAO;
import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
