package utilities;

import org.testng.annotations.DataProvider;
import utilities.CsvUtils;

import java.util.Iterator;
import java.util.List;

public class CSVReader {

    @DataProvider(name = "loginData")
    public static Iterator<Object[]> loginData() {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/data/login_data.csv";

        List<String[]> csvData = CsvUtils.readCsv(path);

        return csvData.stream()
                .map(row -> new Object[]{
                        row[0], // username
                        row[1], // password
                        row[2]  // expectedMessage
                })
                .iterator();
    }
}

