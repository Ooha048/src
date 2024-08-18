package model;

public class ShiftRequest {
	private Integer empId;
	private ShiftType newShift;
	private ReqStatus status;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public ShiftType getNewShift() {
		return newShift;
	}
	public void setNewShift(ShiftType newShift) {
		this.newShift = newShift;
	}
	public ReqStatus getStatus() {
		return status;
	}
	public void setStatus(ReqStatus status) {
		this.status = status;
	} 
}
