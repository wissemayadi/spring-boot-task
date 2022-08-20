package com.example.springreditclone.service;


import com.example.springreditclone.DTO.CountType;
import com.example.springreditclone.entity.Task;
import com.example.springreditclone.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks(){

//        return taskRepository.findAll();
        return taskRepository.getAllTaskByDueDate();

    }
    public Optional<Task>getTaskById(Long id){
   return  taskRepository.findById(id);
    }

    public Task  save(Task task){
   return taskRepository.saveAndFlush(task);
    }

    public boolean existsById(Long id){
        return taskRepository.existsById(id);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);

    }

    public List<CountType> getPercentageGroupByType(){
        return taskRepository.getPercentageGroupByType();
    }

}
