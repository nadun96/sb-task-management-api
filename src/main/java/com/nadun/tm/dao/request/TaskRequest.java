package com.nadun.tm.dao.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    private Long id;
    private String title;
    private String description;
    private Long assignedTo;
    private Long assignedBy;
}
