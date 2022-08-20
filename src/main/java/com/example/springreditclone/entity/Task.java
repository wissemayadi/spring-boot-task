package com.example.springreditclone.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")

    private Long id;
    private String title;
    private String type;
    private Date dueDate;
    private String description;



}
