package CoffeeType;

import logging.AssignmentLogger;

public class Expresso extends Coffee {

    public Expresso() {
        AssignmentLogger.logConstructor(this);
    }

    @Override
    public String getName() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "Espresso";
    }

    @Override
    public int getPreparationTime() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return 2500;
    }

    @Override
    public String getSoundFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "espresso.wav";
    }

    @Override
    public String getImageFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "espresso.jpg";
    }
}

