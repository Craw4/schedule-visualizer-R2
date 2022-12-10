package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.observable.MyObserver;
import edu.hanover.schedulevisualizer.ui.draganddrop.DragAndDropController;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropTarget;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class UnassignedCourseList extends VBox implements MyObserver<List<Course>>, DropTarget {

    void addCourse(Course course) {
        getChildren().add(CourseEntry.forCourse(course));
    }

    public void update(List<Course> courses) {
        Platform.runLater(() -> displayData(courses));
    }

    private void displayData(List<Course> courses) {
        courses.forEach(this::displayCourse);
    }

    private void displayCourse(Course course) {
        course.getTimeslot().ifUnassignedSlotDo(() -> addCourse(course));
    }

    public void setAsDropTarget() {
        DragAndDropController.getInstance().setupDropTarget(this);
    }

    public void clearDropTargetSignal() {
        setBorder(Border.EMPTY);
    }

    public void signalValidDropTarget() {
        setBorder(Border.stroke(Color.BLUEVIOLET));
    }

    public String getTimeslotId() {
        return Context.getInstance().makeUnassignedTimeslot().getId();
    }

    public Node getNode() {
        return this;
    }
}
