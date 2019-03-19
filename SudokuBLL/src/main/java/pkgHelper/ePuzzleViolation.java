package pkgHelper;

public enum ePuzzleViolation {
		DupRow, ContainsZero, DupCol, DupRegion, InvalidValue, MissingZero;
		
		private ePuzzleViolation() {
			
		}
		
		static ePuzzleViolation valueOf(java.lang.String name) {
			ePuzzleViolation valueOf = null;
			for(ePuzzleViolation violation : ePuzzleViolation.values()) {
				if(violation.toString()==name) {
					valueOf = violation;
					break;
				}
			}
		
			
			
			return valueOf;
		}
		
		
		
		

}
