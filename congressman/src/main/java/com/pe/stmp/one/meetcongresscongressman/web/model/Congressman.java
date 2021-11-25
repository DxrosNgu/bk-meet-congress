package com.pe.stmp.one.meetcongresscongressman.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "congressman")
public class Congressman implements Serializable {

   private static final long serialVersionUID = -5759957145202706414L;

   @Id
   @Column(name = "member_id", nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer memberId;

   @Column(name = "deparment_id")
   private Integer departmentId;

   @Column(name = "condition_id")
   private Integer conditionId;

   @Column(name = "parlgp_id")
   private Integer parliamentaryGroupId;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "middle_name")
   private String middleName;

   @Column(name = "father_name")
   private String fatherName;

   @Column(name = "mother_name")
   private String motherName;

   @Column(name = "quantity_vote")
   private Integer quantityVote;

   @Column(name = "member_photo")
   private String memberPhoto;

   @Column(name = "entered_parl")
   private Date enteredParliamentary;

   @Column(name = "exit_parl")
   private Date finishedParliamentary;

   @Column(name = "created_at")
   private Date createdAt;

   @Column(name = "created_by")
   private String createdBy;

   @Column(name = "updated_at")
   private Date updatedAt;

   @Column(name = "updated_by")
   private String updatedBy;
}
