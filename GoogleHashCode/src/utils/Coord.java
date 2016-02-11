package utils;

public class Coord {
	private int row;
	private int column;
	
	public Coord(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Coord(Coord location) {
		this.row = location.row;
		this.column = location.column;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Coord))return false;
	    Coord otherMyClass = (Coord) other;
	    return (this.row == otherMyClass.getRow() && this.column == otherMyClass.getColumn());
	}
	
	public static int distance(Coord a, Coord b){
		int absRow = Math.abs(a.getRow() - b.getRow()); 
		int absColumn = Math.abs(a.getColumn() - b.getColumn());
		int sqr = absRow* absRow + absColumn* absColumn; 
		return (int)Math.ceil(Math.sqrt((double)sqr));		
	}
}
