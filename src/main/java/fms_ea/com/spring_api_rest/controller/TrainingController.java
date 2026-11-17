package fms_ea.com.spring_api_rest.controller;

import fms_ea.com.spring_api_rest.entities.Training;
import fms_ea.com.spring_api_rest.service.TrainingService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

  private final TrainingService trainingService;

  public TrainingController(TrainingService trainingService) {
    this.trainingService = trainingService;
  }

  @GetMapping
  public List<Training> findAll() {
    return trainingService.findAll();
  }

  @GetMapping("/{id}")
  public Training findOne(@PathVariable Long id) {
    return trainingService.findById(id).orElse(null);
  }

  @PostMapping
  public Training create(@RequestBody Training training) {
    return trainingService.create(training);
  }

  @PutMapping("/{id}")
  public Training update(@PathVariable Long id, @RequestBody Training training) {
    return trainingService.update(id, training).orElse(null);
  }

  @DeleteMapping("/{id}")
  public boolean delete(@PathVariable Long id) {
    return trainingService.deleteById(id);
  }
}
