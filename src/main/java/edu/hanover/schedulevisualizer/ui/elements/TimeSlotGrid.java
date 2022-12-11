package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.core.Weekday;
import edu.hanover.schedulevisualizer.observable.MyObserver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSlotGrid extends HBox implements MyObserver<List<Course>> {
    Map< Weekday, DayColumn> dayColumns = new HashMap<>();
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public TimeSlotGrid() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "timeslotgrid-view.fxml"));
        fxmlLoader.setRoot(this);
        addDayColumns();
        TryLoadHolder.tryLoad(fxmlLoader);
    }

    private void addDayColumns() {
        for (Weekday weekday : Weekday.values()) {
            DayColumn dayColumn = DayColumn.forWeekday(weekday);
            getChildren().add(dayColumn);
            dayColumns.put(weekday,dayColumn);
        }
    }

    private void displayData(List<Course> data) {
        data.forEach(this::displayCourse);
    }

    private void displayCourse(Course course) {
        for (Weekday weekday : course.getWeekdays()) {
            dayColumns.get(weekday).addCourse(course);
        }
    }

    public void update(List<Course> courses) {
        Platform.runLater(() -> displayData(courses));
    }
}
