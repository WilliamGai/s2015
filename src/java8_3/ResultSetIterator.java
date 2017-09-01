package java8_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.springframework.dao.DataAccessException;

public class ResultSetIterator implements Iterator {
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection conn;
	private String sql;

	public ResultSetIterator(Connection conn, String sql) {
		super();
		this.conn = conn;
		this.sql = sql;
	}

	public void init() {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void close() {
		try {
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean hasNext(){
		if (ps == null) {
			init();
		}
		try {
			boolean hasMore = rs.next();
			if (!hasMore) {
				close();
			}
			return hasMore;
		} catch (SQLException e) {
			close();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object next() {
		return null;
	}

}
