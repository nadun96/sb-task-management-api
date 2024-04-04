package com.nadun.tm.service;

import com.nadun.tm.dao.request.TaskRequest;
import com.nadun.tm.entity.Task;
import com.nadun.tm.entity.TaskStatus;
import com.nadun.tm.entity.User;
import com.nadun.tm.repository.ITaskRepository;
import com.nadun.tm.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final IUserRepository userRepository;
    private final ITaskRepository taskRepository;

    @Autowired
    public TaskService(IUserRepository userRepository, ITaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }


    public ResponseEntity<Task> createTask(TaskRequest taskRequest) {
        Task task = new Task();
        try{
            // Get Users
            User assignedTo = userRepository.findById(taskRequest.getAssignedTo())
                    .orElseThrow(() -> new RuntimeException("AssignedToUser not found"));
            // Set Data
            task.setTitle(taskRequest.getTitle());
            task.setDescription(taskRequest.getDescription());
            task.setAssignedTo(assignedTo);
            // Save task
            taskRepository.save(task);

            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }catch (InvalidDataAccessResourceUsageException e){
            return new ResponseEntity<>(task, HttpStatus.BAD_REQUEST);
        }

    }

    public List<Task> findTasksByTeamId(Long teamId) {
        System.out.println("Team tasks by teamId Running");
        return taskRepository.findTasksByTeamId(teamId);
    }

    public List<Task> findTasksByUserId(Long userId) {
        return taskRepository.findTasksByUserId(userId);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTaskStatus(Long taskId, TaskStatus newStatus) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }
}
