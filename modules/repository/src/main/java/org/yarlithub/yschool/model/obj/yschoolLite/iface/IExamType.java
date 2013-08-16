package org.yarlithub.yschool.model.obj.yschoolLite.iface;
import java.util.Set;
import org.yarlithub.yschool.model.obj.yschoolLite.Exam;


/** 
 * Object interface mapping for hibernate-handled table: exam_type.
 * @author autogenerated
 */

public interface IExamType {



    /**
     * Return the value associated with the column: exam.
	 * @return A Set&lt;Exam&gt; object (this.exam)
	 */
	Set<Exam> getExams();
	
	/**
	 * Adds a bi-directional link of type Exam to the exams set.
	 * @param exam item to add
	 */
	void addExam(Exam exam);

  
    /**  
     * Set the value related to the column: exam.
	 * @param exam the exam value you wish to set
	 */
	void setExams(final Set<Exam> exam);

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
     * Return the value associated with the column: typeName.
	 * @return A String object (this.typeName)
	 */
	String getTypeName();
	

  
    /**  
     * Set the value related to the column: typeName.
	 * @param typeName the typeName value you wish to set
	 */
	void setTypeName(final String typeName);

	// end of interface
}