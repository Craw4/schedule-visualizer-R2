package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.ui.draganddrop.DragAndDropController;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

import static edu.hanover.schedulevisualizer.ui.elements.DayPattern.MWF;


public class UITimeSlot extends VBox implements DropTarget {

    private DayPattern dayPattern;
    private final Border defaultBorder = Border.stroke(Color.BLACK);
    private String timeslotId;

    public UITimeSlot() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "timeslot-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    static UITimeSlot forDayPattern(DayPattern dayPattern, String slotID, String timeslotId) {
        UITimeSlot uiTimeSlot = new UITimeSlot();
        uiTimeSlot.setDayPattern(dayPattern);
        uiTimeSlot.timeslotId = timeslotId;
        uiTimeSlot.setId(slotID);
        return uiTimeSlot;
    }

    public DayPattern getDayPattern() {
        return dayPattern;
    }

    public void setDayPattern(DayPattern dayPattern) {
        this.dayPattern = dayPattern;
        setPrefHeight(dayPattern == MWF ? 100 : 150);
    }

    void addCourse(Course course) {
        getChildren().add(CourseEntry.forCourse(course));
    }

    @FXML
    public void initialize() {
        DragAndDropController.getInstance().setupDropTarget(this);
    }

    public void signalValidDropTarget() {
        setBorder(Border.stroke(Color.BLUEVIOLET));
    }

    public String getTimeslotId() {
        return timeslotId;
    }

    public void clearDropTargetSignal() {
        setBorder(defaultBorder);
    }

    public Node getNode() {
        return this;
    }
}
