package utils;

public class Coord {
	private int row;
	private int column;
	
	public Coord(int row, int column) {
		this.row = row;
		this.column = column;
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
}
