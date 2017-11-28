package entities;

import entities.Unit;

/**
 * 28.11.2017
 * UnitData
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class UnitData {
    private Unit[] units = {
            new Unit("BLACK", "#000000", 1), //CORRECT UNITS
            new Unit("BLUE", "#0000ff", 1),
            new Unit("GREEN", "#008000", 1),
            new Unit("YELLOW", "#ffff00", 1),
            new Unit("RED", "#ff0000", 1),

            new Unit("BLUE", "#000000", 0), //WRONG BLACK UNITS
            new Unit("GREEN", "#000000", 0),
            new Unit("YELLOW", "#000000", 0),
            new Unit("RED", "#000000", 0),

            new Unit("BLACK", "#0000ff", 0),//WRONG BLUE UNITS
            new Unit("GREEN", "#0000ff", 0),
            new Unit("YELLOW", "#0000ff", 0),
            new Unit("RED", "#0000ff", 0),

            new Unit("BLACK", "#008000", 0),//WRONG GREEN UNITS
            new Unit("BLUE", "#008000", 0),
            new Unit("YELLOW", "#008000", 0),
            new Unit("RED", "#008000", 0),

            new Unit("BLACK", "#ffff00", 0),//WRONG YELLOW UNITS
            new Unit("BLUE", "#ffff00", 0),
            new Unit("GREEN", "#ffff00", 0),
            new Unit("RED", "#ffff00", 0),

            new Unit("BLACK", "#ff0000", 0),//WRONG RED UNITS
            new Unit("BLUE", "#ff0000", 0),
            new Unit("GREEN", "#ff0000", 0),
            new Unit("YELLOW", "#ff0000", 0)};

    public Unit[] getUnits() {
        return units;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }
}
