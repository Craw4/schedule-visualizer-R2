package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.Node;

public interface DropTarget {
    void clearValidDropTargetSignal();
    void signalValidDropTarget();

    String getTimeslotId();

    Node getNode();
}
