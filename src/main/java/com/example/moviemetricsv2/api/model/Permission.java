package com.example.moviemetricsv2.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "permissions")
public class Permission {
    @Id
    private Long id;

    @Column(length = 32)
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;
}
