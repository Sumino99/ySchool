package org.yarlithub.yschool.repository.model.obj.yschool.iface;
import java.util.Date;
import java.util.Set;
import org.yarlithub.yschool.repository.model.obj.yschool.ClassroomModule;
import org.yarlithub.yschool.repository.model.obj.yschool.Grade;
import org.yarlithub.yschool.repository.model.obj.yschool.Subject;


/** 
 * Object interface mapping for hibernate-handled table: module.
 * @author autogenerated
 */

public interface IModule {



    /**
     * Return the value associated with the column: classroomModule.
	 * @return A Set&lt;ClassroomModule&gt; object (this.classroomModule)
	 */
	Set<ClassroomModule> getClassroomModules();
	
	/**
	 * Adds a bi-directional link of type ClassroomModule to the classroomModules set.
	 * @param classroomModule item to add
	 */
	void addClassroomModule(ClassroomModule classroomModule);

  
    /**  
     * Set the value related to the column: classroomModule.
	 * @param classroomModule the classroomModule value you wish to set
	 */
	void setClassroomModules(final Set<ClassroomModule> classroomModule);

    /**
     * Return the value associated with the column: gradeIdgrade.
	 * @return A Grade object (this.gradeIdgrade)
	 */
	Grade getGradeIdgrade();
	

  
    /**  
     * Set the value related to the column: gradeIdgrade.
	 * @param gradeIdgrade the gradeIdgrade value you wish to set
	 */
	void setGradeIdgrade(final Grade gradeIdgrade);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: isOptional.
	 * @return A Boolean object (this.isOptional)
	 */
	Boolean isIsOptional();
	

  
    /**  
     * Set the value related to the column: isOptional.
	 * @param isOptional the isOptional value you wish to set
	 */
	void setIsOptional(final Boolean isOptional);

    /**
     * Return the value associated with the column: modifiedTime.
	 * @return A Date object (this.modifiedTime)
	 */
	Date getModifiedTime();
	

  
    /**  
     * Set the value related to the column: modifiedTime.
	 * @param modifiedTime the modifiedTime value you wish to set
	 */
	void setModifiedTime(final Date modifiedTime);

    /**
     * Return the value associated with the column: subjectIdsubject.
	 * @return A Subject object (this.subjectIdsubject)
	 */
	Subject getSubjectIdsubject();
	

  
    /**  
     * Set the value related to the column: subjectIdsubject.
	 * @param subjectIdsubject the subjectIdsubject value you wish to set
	 */
	void setSubjectIdsubject(final Subject subjectIdsubject);

	// end of interface
}