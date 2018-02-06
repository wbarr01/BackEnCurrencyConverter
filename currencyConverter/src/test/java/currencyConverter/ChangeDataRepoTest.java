package currencyConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.wb.data.ChangeData;
import com.wb.data.ChangeDataRepo;
import com.wb.data.DBconnection;
import com.wb.dto.Change;
import com.wb.dto.ChangeResponse;

@RunWith(MockitoJUnitRunner.class)
public class ChangeDataRepoTest {


	
	ChangeDataRepo changeDataRepo;
	@Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPreparedStmnt;
    @Mock
    ResultSet mockResultSet;

	
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
	
	@Before
    public void setUp() throws Exception  {
        when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStmnt);
        doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
        when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);

	}
	
	@Test
	public void getChangeRatesTest() throws SQLException{
		String base = "USD";
		changeDataRepo = new ChangeDataRepo();
		changeDataRepo.getChangeRates(mockConn, base);
		verify(mockConn, times(1)).prepareStatement(anyString());
		verify(mockPreparedStmnt,times(1)).setString(anyInt(), anyString());
		verify(mockResultSet, times(1)).getInt(anyString());
		verify(mockResultSet, times(3)).getString(anyString());
		verify(mockResultSet, times(1)).getDouble(anyString());
		verify(mockResultSet, times(2)).next();

	}
	
	@Test
	public void getChangeRateEURTest()throws SQLException{
		String base = "USD";
		String symbols = "EUR";
		changeDataRepo = new ChangeDataRepo();
		changeDataRepo.getChangeRateEUR(mockConn, base, symbols);
		verify(mockConn, times(1)).prepareStatement(anyString());
		verify(mockPreparedStmnt,times(2)).setString(anyInt(), anyString());
		verify(mockResultSet, times(1)).getInt(anyString());
		verify(mockResultSet, times(3)).getString(anyString());
		verify(mockResultSet, times(1)).getDouble(anyString());
		verify(mockResultSet, times(2)).next();

	}

}
