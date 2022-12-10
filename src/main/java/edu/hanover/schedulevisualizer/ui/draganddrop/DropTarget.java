package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.Node;

public interface DropTarget {
    void clearDropTargetSignal();
    void signalValidDropTarget();

    String getTimeslotId();

    Node getNode();
}
