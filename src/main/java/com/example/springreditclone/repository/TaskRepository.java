package com.example.springreditclone.repository;

import com.example.springreditclone.DTO.CountType;
import com.example.springreditclone.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Long>
{
 @Query(value = "select * from task order by due_date desc", nativeQuery = true)
    public List<Task>  getAllTaskByDueDate();
  //jpa query

    @Query(value = "select new com.example.springreditclone.DTO.CountType(COUNT(*)/(Select  COUNT(*) FROM Task)*100,type) FROM Task GROUP BY type")

    public  List<CountType> getPercentageGroupByType();
}

