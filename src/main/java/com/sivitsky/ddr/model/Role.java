package com.sivitsky.ddr.model;

import javax.persistence.*;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@NamedQueries({@NamedQuery(name="Role.FindById", query="select distinct c from Role c left join fetch c.users t " +
        "where c.role_id = :id"), @NamedQuery(name="Role.findAllWithDetail", query="select distinct c from Role c " +
        "left join fetch c.users")})
public class Role implements Serializable{

    private Long role_id;
    private String role_name;
    private Set<User> users = new HashSet<User>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    public Long getRole_id() {
        return this.role_id;
    }

    @Column(name = "role_name")
    public String getRole_name() {
        return this.role_name;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        user.setRole(this);
        getUsers().add(user);
    }

    public void removeUser(User user){
        getUsers().remove(user);
    }
}
