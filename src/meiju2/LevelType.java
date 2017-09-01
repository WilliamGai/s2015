package meiju2;


public enum LevelType {
	LEVEL_11	(	11	,	500	),
	LEVEL_12	(	12	,	1000	);

	private final int level;
	private final int lvcompensate;
	private LevelType(int level, int lvcompensate){
		this.level = level;
		this.lvcompensate = lvcompensate;
	}
	public static LevelType getLEVEL_TYPE(int level) {
		for(LevelType t : LevelType.values()){
			if(t.level == level){
				return t;
			}
		}
		return null ;
	}
}
