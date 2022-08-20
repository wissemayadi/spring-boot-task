package com.example.springreditclone.controller;


import com.example.springreditclone.DTO.CountType;
import com.example.springreditclone.entity.Task;
import com.example.springreditclone.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping(value = "/api/v1" ,method = RequestMethod.GET)

public class TaskController {

private TaskService taskService;


@GetMapping("/task")
    public List<Task> getTasks(){

    return taskService.getTasks();
}


    @GetMapping("task/vData/percentageCountType")
    public List<CountType> getTaskPercentage(){

        return taskService.getPercentageGroupByType();
    }


@GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id)
{
return taskService.getTaskById(id).
        orElseThrow(
                ()->new EntityNotFoundException("task not found")
        );
}

@PostMapping("/add")
    public Task addTask(@RequestBody Task task){
    return this.taskService.save(task);

}

@PutMapping("/updateTask/{id}")
    public ResponseEntity<?> putTask(@RequestBody Task task,@PathVariable Long id){
    if(taskService.existsById(id)){
    Task task1= taskService.getTaskById(id).
            orElseThrow(
                    ()->new EntityNotFoundException("Request task not founded")
            );
    task1.setTitle(task.getTitle());
    task1.setDescription(task.getDescription());
    task1.setDueDate(task.getDueDate());
    task1.setType(task.getType());
    taskService.save(task);
    return ResponseEntity.ok().body(task1);
    }
    else{
        HashMap<String,String> message = new HashMap<>();
        message.put("message", id+ "task not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}


@DeleteMapping("task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
    if(taskService.existsById(id)){
        taskService.deleteTask(id);
        HashMap<String,String> message = new HashMap<>();
        message.put("message"," Task with id " + id + "delete success");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    else{
        HashMap<String,String> message = new HashMap<>();
        message.put("message", id+ "task not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}




}
