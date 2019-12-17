package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Assistant;

public interface AssistantRepository extends JpaRepository<Assistant, Integer> {

}
