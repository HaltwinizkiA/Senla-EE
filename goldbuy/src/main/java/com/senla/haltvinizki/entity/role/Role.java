package com.senla.haltvinizki.entity.role;


import com.senla.haltvinizki.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@NamedEntityGraph(name = "role-users", attributeNodes = @NamedAttributeNode("users"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(int id, String name, List<User> userList) {
        this.id = id;
        this.name = name;
        this.users = userList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
