package projects.parkingLot.models;

import projects.parkingLot.enums.GateStatus;
import projects.parkingLot.enums.GateType;

public class Gate extends BaseModel{

    private GateType gateType;
    private int gateNumber;
    private GateStatus gateStatus;
    private String operatorName;

    public Gate() {
    }

    public Gate(GateType gateType, int gateNumber, GateStatus gateStatus, String operatorName) {
        this.gateType = gateType;
        this.gateNumber = gateNumber;
        this.gateStatus = gateStatus;
        this.operatorName = operatorName;
    }

    public GateType getGateType() {
        return gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
