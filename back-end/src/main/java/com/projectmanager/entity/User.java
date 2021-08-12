package com.projectmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    //@Transient
    private String password;

    @Column(name = "is_admin")
    private Boolean admin;

    @Column(name = "is_delete")
    private Boolean delete;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_user", nullable = false)
    private Integer createUser;

    @Column(name = "encrypted_password")
    private String encryptedPassword;

    @OneToMany(mappedBy = "createUser", fetch = FetchType.LAZY)
    private List<Project> projectCreatedList;

//    @OneToMany(mappedBy = "createUser", fetch = FetchType.LAZY)
//    private List<Task> taskCreatedList;

    @OneToMany(mappedBy = "taskManager", fetch = FetchType.LAZY)
    private List<Task> taskManagementList;

    @OneToMany(mappedBy = "assignedUser", fetch = FetchType.LAZY)
    private List<Todo> todoList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ProjectEmployee> projectList;


}
