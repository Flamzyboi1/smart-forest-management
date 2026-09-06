package com.example.smartforest.controller;

import com.example.smartforest.model.DominantTree;
import com.example.smartforest.repository.DominantTreeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dominant-trees")
public class DominantTreeController {

    private final DominantTreeRepository treeRepo;

    public DominantTreeController(DominantTreeRepository treeRepo) {
        this.treeRepo = treeRepo;
    }

    @GetMapping
    public List<DominantTree> allDominantTrees() {
        return treeRepo.findAll();
    }
}
