package com.rabbit.application.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.rabbit.application.models.DailyTask;

@Entity
@Table(name = "days")
public class Day {  // Renamed to singular "Day" as it represents one day
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "title", nullable = false)  // Changed "name" to "title" for clarity
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "day")
    private List<DailyTask> tasks = new ArrayList<>();

    public Day() {}

    public Day(String title, Client client) {
        this.title = title;
        this.client = client;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<DailyTask> getTasks() { return tasks; }
    public void setTasks(List<DailyTask> tasks) { this.tasks = tasks; }
}