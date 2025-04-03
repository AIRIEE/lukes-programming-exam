package CoffeeType;

import logging.AssignmentLogger;

/**
 * Abstract base class for all coffee types.
 */
public abstract class Coffee {

    public Coffee() {
        AssignmentLogger.logConstructor(this);
    }

    public abstract String getName();
    public abstract int getPreparationTime();      // In milliseconds
    public abstract String getSoundFile();         // e.g. "latte.wav"
    public abstract String getImageFile();         // e.g. "latte.jpg"
}

