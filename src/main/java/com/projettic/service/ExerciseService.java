package com.projettic.service;

import com.projettic.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> findAll();
    Exercise findById(Exercise exercise);

}
