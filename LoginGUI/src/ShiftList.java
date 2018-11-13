import java.util.ArrayList;

public class ShiftList {
	private ArrayList<Shift> shiftList;
	
	public ShiftList() {
		shiftList = new ArrayList<Shift>();
	}
	
	public void AddShift(Shift shift) {
		if(shift instanceof Shift) {
			shiftList.add(shift);
		}
	}
	
	public void EditShift(Shift shift) {
		shiftList.set(shift.getShiftID()-1, shift);
	}
	
	public Shift FindShiftById(int id) {
		Shift temp = null;
		for(int i = 0; i < shiftList.size(); i++) {
			if(shiftList.get(i).getShiftID() == shiftList.get(id).getShiftID()) {
				temp = shiftList.get(i);
			}
		}
		
		return temp;
	}
	
	public String toString() {
		System.out.println("ISSA SHIFT");
		for(int i = 0; i < shiftList.size(); i++) {
			shiftList.get(i);
		}
		return "";
	}
}
