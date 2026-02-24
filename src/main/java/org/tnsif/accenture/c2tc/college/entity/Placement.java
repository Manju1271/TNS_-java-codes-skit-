package org.tnsif.accenture.c2tc.college.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name is required")
    @Column(nullable = false)
    private String companyName;

    @NotNull(message = "Drive date is required")
    @FutureOrPresent(message = "Drive date must be today or future")
    @Column(nullable = false)
    private LocalDate driveDate;

    @Positive(message = "Package offered must be positive")
    @Column(nullable = false)
    private double packageOffered;

    @NotBlank(message = "Eligibility criteria is required")
    @Column(nullable = false)
    private String eligibilityCriteria;

    @NotNull(message = "College details are required")
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    public Placement() {
    }

    public Placement(Long id, String companyName, LocalDate driveDate, double packageOffered, String eligibilityCriteria,
            College college) {
        this.id = id;
        this.companyName = companyName;
        this.driveDate = driveDate;
        this.packageOffered = packageOffered;
        this.eligibilityCriteria = eligibilityCriteria;
        this.college = college;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(LocalDate driveDate) {
        this.driveDate = driveDate;
    }

    public double getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(double packageOffered) {
        this.packageOffered = packageOffered;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
