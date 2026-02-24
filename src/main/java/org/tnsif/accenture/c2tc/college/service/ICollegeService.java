package org.tnsif.accenture.c2tc.college.service;

import org.tnsif.accenture.c2tc.college.entity.College;
import org.tnsif.accenture.c2tc.college.entity.Placement;

public interface ICollegeService {

    College addCollege(College college);

    College updateCollege(College college);

    College searchCollege(long id);

    void deleteCollege(long id);

    Placement schedulePlacement(Placement placement);
}
