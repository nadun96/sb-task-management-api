package com.nadun.tm.controller;

import com.nadun.tm.dto.TaskRequest;
import com.nadun.tm.entity.Task;
import com.nadun.tm.entity.TaskStatus;
import com.nadun.tm.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
        //@Params( title , description , assignedTo )
    }

    //TODO: Fix Teams
    @GetMapping("/team/{teamId}")
    public List<Task> getMyTeamTasks(@PathVariable Long teamId) {
        return taskService.findTasksByTeamId(teamId);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getMyTasks(@PathVariable Long userId) {
        return taskService.findTasksByUserId(userId);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    @PutMapping("/status")
    public Task updateTaskStatus(@RequestParam Long taskId, @RequestParam TaskStatus newStatus) {
        return taskService.updateTaskStatus(taskId, newStatus);
    }

}
