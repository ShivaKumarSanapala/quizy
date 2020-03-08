package com.quizy.quizservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String quizName;
  private String subject;
  private String className;
  private Date quizDate;
  private Date startTime;
  @CreationTimestamp
  private Date createdAt;
  @UpdateTimestamp
  private Date updatedAt;
}
