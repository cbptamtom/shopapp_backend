package com.project.shopapp.controllers;


import com.project.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
//    Get all categories

    @GetMapping("") //http://localhost:8083/api/v1/categories
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok(String.format("getAllCategories, page = %d, limit = %d",page,limit));
    }
    @PostMapping("") //http://localhost:8083/api/v1/categories
    public ResponseEntity<?> insertCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result){
        if(result.hasErrors()){
            List<FieldError> fieldErrorList = result.getFieldErrors();
            List<String> errorMessages = fieldErrorList.stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("insertCategory");
    }
    @PutMapping("/{id}") //http://localhost:8083/api/v1/categories
    public ResponseEntity<String> updateCategories(@PathVariable Long id){
        return ResponseEntity.ok("updateCategories with id = " + id);
    }

    @DeleteMapping("/{id}") //http://localhost:8083/api/v1/categories
    public ResponseEntity<String> deleteCategories(@PathVariable Long id){
        return ResponseEntity.ok("deleteCategories with id = " + id);
    }

}
