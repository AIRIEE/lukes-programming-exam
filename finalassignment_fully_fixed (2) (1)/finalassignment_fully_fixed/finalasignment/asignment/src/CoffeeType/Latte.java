package CoffeeType;

import logging.AssignmentLogger;

public class Latte extends Coffee {

    public Latte() {
        AssignmentLogger.logConstructor(this);
    }

    @Override
    public String getName() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "Latte";
    }

    @Override
    public int getPreparationTime() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return 3000;
    }

    @Override
    public String getSoundFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "latte.wav";
    }

    @Override
    public String getImageFile() {
        AssignmentLogger.logMethodEntry(this);
        AssignmentLogger.logMethodExit(this);
        return "latte.jpg";
    }
}

