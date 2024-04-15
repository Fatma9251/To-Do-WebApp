package com.university.Todo.Controller;

import com.university.Todo.Entity.CustomResponseEntity;
import com.university.Todo.Entity.Task;
import com.university.Todo.Service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
// Dependency Injection -- such that I want to reference the service in the controller
       private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/create")
    public CustomResponseEntity createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping("/all")
    public CustomResponseEntity listALLTasks(){
        return taskService.getAllTasks();
    }
    @PutMapping("/{id}")
    public CustomResponseEntity updateTask(@PathVariable long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }
    @DeleteMapping("/{id}")
    public CustomResponseEntity deleteTask(@PathVariable long id){
        return taskService.deleteTask(id);
    }
}
