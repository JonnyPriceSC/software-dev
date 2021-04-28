package src.artemisLite;

public class Contract {

	private int contractId;
	private String contractName;
	private int baseCost;
	private int baseRent;
	private int adjustmentMinor1;
	private int adjustmentMinor2;
	private int adjustmentMinor3;
	private int adjustmentMajor;
	private int minorCost1;
	private int minorCost2;
	private int minorCost3;
	private int majorCost;
	private int minorRent1;
	private int minorRent2;
	private int minorRent3;
	private int majorRent;
	private int ownerId = 5;
	private int currentLevel = 0;
	private int currentCost;
	private int currentRent;
	private int currentAdjustment = 0;

	public Contract(int contractId, String contractName, int baseCost, int baseRent, int adjustmentMinor1,
			int adjustmentMinor2, int adjustmentMinor3, int adjustmentMajor, int minorCost1, int minorCost2,
			int minorCost3, int majorCost, int minorRent1, int minorRent2, int minorRent3, int majorRent) {

		this.contractId = contractId;
		this.contractName = contractName;
		this.baseCost = baseCost;
		this.baseRent = baseRent;
		this.adjustmentMinor1 = adjustmentMinor1;
		this.adjustmentMinor2 = adjustmentMinor2;
		this.adjustmentMinor3 = adjustmentMinor3;
		this.adjustmentMajor = adjustmentMajor;
		this.minorCost1 = minorCost1;
		this.minorCost2 = minorCost2;
		this.minorCost3 = minorCost3;
		this.majorCost = majorCost;
		this.minorRent1 = minorRent1;
		this.minorRent2 = minorRent2;
		this.minorRent3 = minorRent3;
		this.majorRent = majorRent;
		this.currentCost = baseCost;
		this.currentRent = baseRent;

	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public int getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(int baseCost) {
		this.baseCost = baseCost;
	}

	public int getAdjustmentMinor1() {
		return adjustmentMinor1;
	}

	public void setAdjustmentMinor1(int adjustmentMinor1) {
		this.adjustmentMinor1 = adjustmentMinor1;
	}

	public int getBaseRent() {
		return baseRent;
	}

	public void setBaseRent(int baseRent) {
		this.baseRent = baseRent;
	}

	public int getAdjustmentMinor2() {
		return adjustmentMinor2;
	}

	public void setAdjustmentMinor2(int adjustmentMinor2) {
		this.adjustmentMinor2 = adjustmentMinor2;
	}

	public int getAdjustmentMinor3() {
		return adjustmentMinor3;
	}

	public void setAdjustmentMinor3(int adjustmentMinor3) {
		this.adjustmentMinor3 = adjustmentMinor3;
	}

	public int getAdjustmentMajor() {
		return adjustmentMajor;
	}

	public void setAdjustmentMajor(int adjustmentMajor) {
		this.adjustmentMajor = adjustmentMajor;
	}

	public int getMinorCost1() {
		return minorCost1;
	}

	public void setMinorCost1(int minorCost1) {
		this.minorCost1 = minorCost1;
	}

	public int getMinorCost2() {
		return minorCost2;
	}

	public void setMinorCost2(int minorCost2) {
		this.minorCost2 = minorCost2;
	}

	public int getMinorCost3() {
		return minorCost3;
	}

	public void setMinorCost3(int minorCost3) {
		this.minorCost3 = minorCost3;
	}

	public int getMajorCost() {
		return majorCost;
	}

	public void setMajorCost(int majorCost) {
		this.majorCost = majorCost;
	}

	public int getMinorRent1() {
		return minorRent1;
	}

	public void setMinorRent1(int minorRent1) {
		this.minorRent1 = minorRent1;
	}

	public int getMinorRent2() {
		return minorRent2;
	}

	public void setMinorRent2(int minorRent2) {
		this.minorRent2 = minorRent2;
	}

	public int getMinorRent3() {
		return minorRent3;
	}

	public void setMinorRent3(int minorRent3) {
		this.minorRent3 = minorRent3;
	}

	public int getMajorRent() {
		return majorRent;
	}

	public void setMajorRent(int majorRent) {
		this.majorRent = majorRent;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(int currentCost) {
		this.currentCost = currentCost;
	}

	public int getCurrentRent() {
		return currentRent;
	}

	public void setCurrentRent(int currentRent) {
		this.currentRent = currentRent;
	}

	public int getCurrentAdjustment() {
		return currentAdjustment;
	}

	public void setCurrentAdjustment(int currentAdjustment) {
		this.currentAdjustment = currentAdjustment;
	};
	
	
	

}