package org.yarlithub.yschool.ySchoolSetUp.Loader;

import org.yarlithub.yschool.Reader.Reader;


/**
 * Created with IntelliJ IDEA.
 * User: jayrksih
 * Date: 8/13/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassroomLoader {

    public boolean load(Reader reader) {

        /**
         * In initialization document 4th scheet is class information.
         */
        reader.setSheet(3);

        for (int i = 1; i <= reader.getLastRowNumber(); i++) {
            reader.setRow(i);

//
//            DataLayerYschoolLite dataLayerYschoolLite = DataLayerYschoolLiteImpl.getInstance();
//            ClassroomDao classroomDao = HibernateYschoolLiteDaoFactory.getClassroomDao();
//
//            Classroom classroom = YschoolLiteDataPoolFactory.getClassroom();
//
//            classroom.setGrade(grade);
//            classroom.setDivision(division);
//            classroom.setYear(date);
//
//            classroomDao.save(classroom);
//            dataLayerYschoolLite.flushSession();


        }
        return true;
    }
}