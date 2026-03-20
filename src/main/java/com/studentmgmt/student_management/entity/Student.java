package com.studentmgmt.student_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 25, message = "Age must be at most 25")
    @Column(nullable = false)
    private Integer age;

    @NotNull(message = "Marks 1 is required")
    @Min(value = 0, message = "Marks must be between 0 and 100")
    @Max(value = 100, message = "Marks must be between 0 and 100")
    @Column(nullable = false)
    private Integer marks1;

    @NotNull(message = "Marks 2 is required")
    @Min(value = 0, message = "Marks must be between 0 and 100")
    @Max(value = 100, message = "Marks must be between 0 and 100")
    @Column(nullable = false)
    private Integer marks2;

    @NotNull(message = "Marks 3 is required")
    @Min(value = 0, message = "Marks must be between 0 and 100")
    @Max(value = 100, message = "Marks must be between 0 and 100")
    @Column(nullable = false)
    private Integer marks3;

    @NotNull(message = "Marks 4 is required")
    @Min(value = 0, message = "Marks must be between 0 and 100")
    @Max(value = 100, message = "Marks must be between 0 and 100")
    @Column(nullable = false)
    private Integer marks4;

    @NotNull(message = "Marks 5 is required")
    @Min(value = 0, message = "Marks must be between 0 and 100")
    @Max(value = 100, message = "Marks must be between 0 and 100")
    @Column(nullable = false)
    private Integer marks5;

    // Computed fields — stored for convenience, derived on save
    @Column(nullable = false)
    private Double percentage;

    @Column(nullable = false)
    private String division;

    @PrePersist
    @PreUpdate
    public void computeResults() {
        this.percentage = Math.round(((marks1 + marks2 + marks3 + marks4 + marks5) / 5.0) * 10.0) / 10.0;
        if (this.percentage >= 60) {
            this.division = "First Division";
        } else if (this.percentage >= 50) {
            this.division = "Second Division";
        } else {
            this.division = "Fail";
        }
    }
}
