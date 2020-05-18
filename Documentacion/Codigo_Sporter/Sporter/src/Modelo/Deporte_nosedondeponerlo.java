package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Deporte_nosedondeponerlo {
	private Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
	
	public Deporte_nosedondeponerlo(Statement command) throws SQLException {
		
		ResultSet data = command.executeQuery("SELECT * FROM spoter.usuarios_has_deporte;"); 
		while(data.next()) {
			Integer key = data.getInt(1);
			Integer Val = data.getInt(2);
			ArrayList<Integer> i = map.get(key);
			if(i==null) {
				i = new ArrayList<Integer>();
			}
			i.add(Val);
			map.put(key, i);
		}
	}

	public Map<Integer, ArrayList<Integer>> getMap() {
		return map;
	}
}
