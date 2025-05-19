package com.launchpad.idea_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IdeaRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Product Category is required")
    private String productCategory;

    @NotBlank(message = "Launch cost is required")
    private Float launchCost;

    @NotBlank(message = "Expected ROI is required")
    private Float expectedROI;

    @NotBlank(message = "Trend Alignment is required")
    private Boolean trendAlignment;

    @NotBlank(message = "Customer Validation is required")
    private Boolean customerValidation;

    @NotBlank(message = "Creator Experience level is required")
    private String creatorExperienceLevel;

    @NotNull(message = "User ID is required")
    private Long userId;

    // Getters & setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getProductCategory() {
        return productCategory;
    }

    public Float getLaunchCost() {
        return launchCost;
    }

    public Float getExpectedROI() {
        return expectedROI;
    }

    public Boolean getTrendAlignment() {
        return trendAlignment;
    }

    public Boolean getCustomerValidation() {
        return customerValidation;
    }

    public String getCreatorExperienceLevel() {
        return creatorExperienceLevel;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
