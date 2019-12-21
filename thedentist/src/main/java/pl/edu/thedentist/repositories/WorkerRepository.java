package pl.edu.thedentist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.edu.thedentist.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
