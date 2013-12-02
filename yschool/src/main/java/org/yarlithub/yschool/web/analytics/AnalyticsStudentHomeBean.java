package org.yarlithub.yschool.web.analytics;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.yarlithub.yschool.analytics.core.OLSubjectPrediction;
import org.yarlithub.yschool.repository.model.obj.yschool.ClassroomSubject;
import org.yarlithub.yschool.repository.model.obj.yschool.Student;
import org.yarlithub.yschool.service.AnalyticsService;
import org.yarlithub.yschool.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.arima.classanalyzer.core.CFinal.predictNextTerm;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Krish
 * Date: 11/2/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean
@Scope(value = "session")
@Controller
public class AnalyticsStudentHomeBean implements Serializable {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AnalyticsService analyticsService;
    @Autowired
    private AnalyticsController analyticsController;
    private Student student;
    private DataModel secondarySubjects;
    private DataModel<ClassroomSubject> oLSubjects;
    private DataModel<ClassroomSubject> oLSubjectsEleven;
    private DataModel<OLSubjectPrediction> olSubjectPredictions;
    private DataModel aLSubjects;
    private CartesianChartModel linearModel;
    private CartesianChartModel linearModelTermMarks;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DataModel<OLSubjectPrediction> getOlSubjectPredictions() {
        return olSubjectPredictions;
    }

    public void setOlSubjectPredictions(DataModel<OLSubjectPrediction> olSubjectPredictions) {
        this.olSubjectPredictions = olSubjectPredictions;
    }

    public DataModel getoLSubjects() {
        return oLSubjects;
    }

    public void setoLSubjects(DataModel oLSubjects) {
        this.oLSubjects = oLSubjects;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void setLinearModel(CartesianChartModel linearModel) {
        this.linearModel = linearModel;
    }

    private void createLinearModelTermMarks(OLSubjectPrediction olSubjectPrediction) {
        linearModelTermMarks = new CartesianChartModel();

        LineChartSeries termMarks = new LineChartSeries();


        termMarks.setLabel("Term Marks");

        if (olSubjectPrediction.getTermMarks().get(0) != -.1) {
            termMarks.set(1, olSubjectPrediction.getTermMarks().get(0));
        }
        if (olSubjectPrediction.getTermMarks().get(1) != -.1) {
            termMarks.set(2, olSubjectPrediction.getTermMarks().get(1));
        }
        if (olSubjectPrediction.getTermMarks().get(2) != -.1) {
            termMarks.set(3, olSubjectPrediction.getTermMarks().get(2));
        }
        if (olSubjectPrediction.getTermMarks().get(3) != -.1) {
            termMarks.set(4, olSubjectPrediction.getTermMarks().get(3));
        }
        if (olSubjectPrediction.getTermMarks().get(4) != -.1) {
            termMarks.set(5, olSubjectPrediction.getTermMarks().get(4));
        }

        if (olSubjectPrediction.getTermMarks().get(5) != -.1) {
            termMarks.set(6, olSubjectPrediction.getTermMarks().get(5));
        }


        linearModelTermMarks.addSeries(termMarks);
        // linearModel.addSeries(series2);
        setLinearModelTermMarks(linearModelTermMarks);

    }

    private CartesianChartModel createLinearModelTermMarksForOlSub(OLSubjectPrediction olSubjectPrediction) {
        CartesianChartModel model = new CartesianChartModel();

        LineChartSeries termMarks = new LineChartSeries();


        termMarks.setLabel("Term Marks");

        if (olSubjectPrediction.getTermMarks().get(0) >= 0) {
            termMarks.set(1, olSubjectPrediction.getTermMarks().get(0));
        }
        if (olSubjectPrediction.getTermMarks().get(1) >= 0) {
            termMarks.set(2, olSubjectPrediction.getTermMarks().get(1));
        }
        if (olSubjectPrediction.getTermMarks().get(2) >= 0) {
            termMarks.set(3, olSubjectPrediction.getTermMarks().get(2));
        }
        if (olSubjectPrediction.getTermMarks().get(3) >= 0) {
            termMarks.set(4, olSubjectPrediction.getTermMarks().get(3));
        }
        if (olSubjectPrediction.getTermMarks().get(4) >= 0) {
            termMarks.set(5, olSubjectPrediction.getTermMarks().get(4));
        }

        if (olSubjectPrediction.getTermMarks().get(5) >= 0) {
            termMarks.set(6, olSubjectPrediction.getTermMarks().get(5));
        }


        LineChartSeries upperBound = new LineChartSeries();


        upperBound.setLabel("Upper Bound");


        upperBound.set(2, olSubjectPrediction.getTermMarksUpper().get(0));
        upperBound.set(3, olSubjectPrediction.getTermMarksUpper().get(1));
        upperBound.set(4, olSubjectPrediction.getTermMarksUpper().get(2));
        upperBound.set(5, olSubjectPrediction.getTermMarksUpper().get(3));
        upperBound.set(6, olSubjectPrediction.getTermMarksUpper().get(4));


        LineChartSeries lowerBound = new LineChartSeries();


        lowerBound.setLabel("Lower Bound");


        lowerBound.set(2, olSubjectPrediction.getTermMarksLower().get(0));
        lowerBound.set(3, olSubjectPrediction.getTermMarksLower().get(1));
        lowerBound.set(4, olSubjectPrediction.getTermMarksLower().get(2));
        lowerBound.set(5, olSubjectPrediction.getTermMarksLower().get(3));
        lowerBound.set(6, olSubjectPrediction.getTermMarksLower().get(4));


        model.addSeries(upperBound);
        model.addSeries(termMarks);
        model.addSeries(lowerBound);
        return model;
    }

    public CartesianChartModel getLinearModelTermMarks() {
        return linearModelTermMarks;
    }

    public void setLinearModelTermMarks(CartesianChartModel linearModelTermMarks) {
        this.linearModelTermMarks = linearModelTermMarks;
    }

    public boolean preloadStudent() {

        this.student = analyticsService.getStudenById(5);
        //  this.student=analyticsController.getStudent();
        this.oLSubjects = new ListDataModel(analyticsService.getOLSubjects(student));
        this.oLSubjectsEleven = new ListDataModel(analyticsService.getOLSubjectsEleven(student));


        List<OLSubjectPrediction> olSubjectPredictions = new ArrayList<>();

        double termMark = 0.0;

        Iterator<ClassroomSubject> olsubjectIterator = oLSubjects.iterator();
        Iterator<ClassroomSubject> olsubjectElevenIterator = oLSubjectsEleven.iterator();
        OLSubjectPrediction olSubjectPrediction = null;

        while (true) {
            List<Double> termMarks = new ArrayList<Double>();

            ClassroomSubject olSubject = null;
            ClassroomSubject olsubjectEleven = null;

            if (olsubjectIterator.hasNext() && olsubjectElevenIterator.hasNext()) {
                olSubject = olsubjectIterator.next();
                olsubjectEleven = olsubjectElevenIterator.next();

            } else {

                break;

            }

            ArrayList<Integer> previousTermMarks = new ArrayList<>();
            ArrayList<Integer> predictedTermMarksLower = new ArrayList<>();
            ArrayList<Integer> predictedTermMarksUpper = new ArrayList<>();
            ArrayList<Integer> range = new ArrayList<>();

            for (int term = 1; term <= 3; term++) {
                termMark = analyticsService.getTermMarksForOLSub(this.student, olSubject, term);
                if (termMark >= 0 && termMark <= 100) {

                    termMarks.add(termMark);
                    int mark = (int) termMark;

                    previousTermMarks.add(mark);
                    try {
                        // range = predictNextTerm(null, 2008, 10, term, olSubject.getSubjectIdsubject().getName(), student.getId(), previousTermMarks);


                        if (term < 3) {
                            range = predictNextTerm(null, 2008, 10, term + 1, olSubject.getSubjectIdsubject().getName(), student.getId(), previousTermMarks);
                        }

                        if (term == 3) {
                            range = predictNextTerm(null, 2009, 11, 1, olSubject.getSubjectIdsubject().getName(), student.getId(), previousTermMarks);

                        }

                    } catch (Exception e) {

                    }


                    predictedTermMarksLower.add(range.get(0));
                    predictedTermMarksUpper.add(range.get(1));


                } else if (termMark == -1) {
                    termMarks.add(-0.1);
                } else if (termMark == -2) {
                    termMarks.add(-0.2);
                } else if (termMark == -3) {
                    termMarks.add(-0.3);
                }

            }


            for (int term = 1; term <= 3; term++) {
                termMark = analyticsService.getTermMarksForOLSub(this.student, olsubjectEleven, term);
                if (termMark >= 0 && termMark <= 100) {
                    termMarks.add(termMark);

                    int mark = (int) termMark;

                    previousTermMarks.add(mark);
                    try {
                        if (term < 3) {
                            range = predictNextTerm(null, 2009, 11, term + 1, olSubject.getSubjectIdsubject().getName(), student.getId(), previousTermMarks);
                        }

                        if (term == 3) {
                            //range = predictNextTerm(null, 2008, 11, 1, olSubject.getSubjectIdsubject().getName(), student.getId(), previousTermMarks);

                        }

                    } catch (Exception e) {

                    }


                    predictedTermMarksLower.add(range.get(0));
                    predictedTermMarksUpper.add(range.get(1));
                } else if (termMark == -1) {
                    termMarks.add(-0.1);
                } else if (termMark == -2) {
                    termMarks.add(-0.2);
                } else if (termMark == -3) {
                    termMarks.add(-0.3);
                }

            }

            olSubjectPrediction = new OLSubjectPrediction();
            olSubjectPrediction.setOlSubject(olSubject);
            olSubjectPrediction.setTermMarks(termMarks);
            olSubjectPrediction.setTermMarksUpper(predictedTermMarksUpper);
            olSubjectPrediction.setTermMarksLower(predictedTermMarksLower);


//            createLinearModelTermMarks(olSubjectPrediction);
//            olSubjectPrediction.setLinearModelTermMarks(linearModelTermMarks);

            olSubjectPredictions.add(olSubjectPrediction);


        }

        this.olSubjectPredictions = new ListDataModel<OLSubjectPrediction>(olSubjectPredictions);

        Iterator<OLSubjectPrediction> iterator = olSubjectPredictions.iterator();
        while (iterator.hasNext()) {
            OLSubjectPrediction olSubjectPrediction_tmp = iterator.next();

            olSubjectPrediction_tmp.setLinearModelTermMarks(createLinearModelTermMarksForOlSub(olSubjectPrediction_tmp));
        }

        return true;
    }


}

