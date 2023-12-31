package com.example.moviemetricsv2.api.service;

import com.example.moviemetricsv2.api.model.MovieClassification;
import com.example.moviemetricsv2.api.model.Permission;
import com.example.moviemetricsv2.api.model.Role;
import com.example.moviemetricsv2.api.repository.IPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final IPermissionRepository permissionRepository;

    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    public Permission findOrCreate(Long id, String name) {
        return permissionRepository.findByNameIgnoreCase(name).orElseGet(() -> permissionRepository.save(
                Permission.builder()
                        .id(id)
                        .name(name)
                        .build()
        ));
    }

    public void createIfNotFound(Long id, String name) {
        if (!permissionRepository.existsByNameIgnoreCase(name))
            permissionRepository.save(
                    Permission.builder()
                            .id(id)
                            .name(name)
                            .build()
            );
    }
}
