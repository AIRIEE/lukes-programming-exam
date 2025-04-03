package CoffeeType;

import logging.AssignmentLogger;

public class Americano extends Coffee {

    public Americano() {
        AssignmentLogger.logConstructor(this);
    }

    @Override
    public String getName() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "Americano";
    }

    @Override
    public int getPreparationTime() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return 4000;
    }

    @Override
    public String getSoundFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "americano.wav";
    }

    @Override
    public String getImageFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "americano.jpg";
    }
}

