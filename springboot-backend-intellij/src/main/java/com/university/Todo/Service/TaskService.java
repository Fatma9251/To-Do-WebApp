package com.university.Todo.Service;

import com.university.Todo.Entity.CustomResponseEntity;
import com.university.Todo.Entity.Task;
import com.university.Todo.Repository.TaskRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
// Dependency Injection -- such that I want to reference the Repo in the Service layer
    private TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public CustomResponseEntity<?> createTask(Task task) {
        taskRepo.save(task);
        return new CustomResponseEntity<>("Task Creation success!", task);
    }

    public CustomResponseEntity<?> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        return new CustomResponseEntity<>("success!", tasks);
    }

    public CustomResponseEntity<?> updateTask(long id, Task task) {
        Optional<Task> task1 = taskRepo.findById(id); // optional: container
        //if(task.getDescription() == null){
            task1.get().setStatus(task.getStatus()); // updating task Status
        //}
        //else{
            task1.get().setDescription(task.getDescription()); // updating task description
        //}
        taskRepo.save(task1.get());
        return new CustomResponseEntity<>("Task Updated Successfully!", task1.get());
    }

    public CustomResponseEntity<?> deleteTask(long id) {
        taskRepo.deleteById(id);
        return new CustomResponseEntity<>("Task Deletion Success", null);
    }
}
