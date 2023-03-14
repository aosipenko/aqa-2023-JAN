package org.prog.db;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
@Data
public class Persons {

  @Id
  @Column(name = "PersonID", nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long personId;

  @Column(name = "LastName")
  private String lastName;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "Title")
  private String title;

  @Column(name = "Gender")
  private String gender;
}
