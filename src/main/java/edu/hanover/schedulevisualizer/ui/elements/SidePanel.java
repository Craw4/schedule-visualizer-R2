package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.observable.MyObserver;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class SidePanel extends VBox{
    public SidePanel() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "sidepanel-view.fxml"));
        fxmlLoader.setRoot(this);
        TryLoadHolder.tryLoad(fxmlLoader);
    }

}
