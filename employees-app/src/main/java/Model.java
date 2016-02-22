

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

	
	public String authenticate(String email,String password) {
		
		System.out.println("in Model->authenticate() email = " + email);
		
		//String result = bean.validate();
		String result="success";
		if(result.equals(Constants.SUCCESS))
		{
			Connection con = null;
			PreparedStatement ps_sql = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con==null)
					return "Oops connection not established!";
				else
				{
					ps_sql = con.prepareStatement("select * from person where email = ? and password = ?");
					ps_sql.setString(1, email);
					ps_sql.setString(2, password);
					ps_sql.execute();
					
					rs = ps_sql.getResultSet();
					if(rs.next())
					{
						//authentication successful!
						return Constants.SUCCESS;
					}
					else
					{
						//authentication has failed!
						return "Your email/pass combination is invalid. You get one more chance to get it right and then you will be killed!";
					}
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return "Oops something bad happened "+e.getMessage();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sql);
				JDBCHelper.close(con);
			}
			
		}
		else 
			return result;
		
		
	}
}





