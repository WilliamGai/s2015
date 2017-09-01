package java8_3;

import java.sql.ResultSet;
import java.sql.SQLException;

/*①创建一个函数接口*/
@FunctionalInterface
public interface ResultSetProcessor {
	public void process(ResultSet resultSet, long currentRow) throws SQLException;
}
