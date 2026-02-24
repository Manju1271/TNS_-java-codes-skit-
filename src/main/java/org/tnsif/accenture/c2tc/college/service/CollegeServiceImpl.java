package org.tnsif.accenture.c2tc.college.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.tnsif.accenture.c2tc.college.entity.College;
import org.tnsif.accenture.c2tc.college.entity.Placement;
import org.tnsif.accenture.c2tc.college.repository.CollegeRepository;
import org.tnsif.accenture.c2tc.college.repository.PlacementRepository;

@Service
@Transactional
public class CollegeServiceImpl implements ICollegeService {

    private final CollegeRepository collegeRepository;
    private final PlacementRepository placementRepository;

    public CollegeServiceImpl(CollegeRepository collegeRepository, PlacementRepository placementRepository) {
        this.collegeRepository = collegeRepository;
        this.placementRepository = placementRepository;
    }

    @Override
    public College addCollege(College college) {
        college.setId(null);
        return collegeRepository.save(college);
    }

    @Override
    public College updateCollege(College college) {
        Long id = college.getId();
        if (id == null) {
            throw new IllegalArgumentException("College id is required for update");
        }

        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));

        existingCollege.setCollegeName(college.getCollegeName());
        existingCollege.setLocation(college.getLocation());
        existingCollege.setUniversity(college.getUniversity());
        existingCollege.setContactEmail(college.getContactEmail());

        return collegeRepository.save(existingCollege);
    }

    @Override
    @Transactional(readOnly = true)
    public College searchCollege(long id) {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));
    }

    @Override
    public void deleteCollege(long id) {
        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));
        collegeRepository.delete(existingCollege);
    }

    @Override
    public Placement schedulePlacement(Placement placement) {
        if (placement.getCollege() == null || placement.getCollege().getId() == null) {
            throw new IllegalArgumentException("College id is required to schedule placement");
        }

        Long collegeId = placement.getCollege().getId();
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + collegeId));

        placement.setId(null);
        placement.setCollege(college);

        Placement savedPlacement = placementRepository.save(placement);
        college.getPlacements().add(savedPlacement);

        return savedPlacement;
    }
}
