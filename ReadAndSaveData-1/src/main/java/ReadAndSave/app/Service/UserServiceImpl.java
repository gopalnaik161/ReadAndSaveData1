package ReadAndSave.app.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ReadAndSave.app.Entity.User;
import ReadAndSave.app.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void ReadExcel() {

		try {
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\gopal naik\\OneDrive\\Documents\\data5.xlsx"));
			File fDir = new File("C:\\Users\\gopal naik\\OneDrive\\Documents\\ANV");
			if (!fDir.exists()) {
				fDir.mkdirs();
			}
			byte[] bytef = new byte[file.available()];
			file.read(bytef);
			Date date = new Date();
			String string = date.toString();
			FileOutputStream file2 = new FileOutputStream("C:\\Users\\gopal naik\\OneDrive\\Documents\\ANV\\data8-"+string+".xlsx");
			file2.write(bytef);
			file2.close();
			XSSFWorkbook workbook = new XSSFWorkbook(new File("C:\\Users\\gopal naik\\OneDrive\\Documents\\ANV\\data8-"+string+".xlsx"));
//			XSSFWorkbook workbook=new XSSFWorkbook(file2);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
//			XSSFSheet sheet2 = workbook2.getSheetAt(0);
			
			
			XSSFRow header_row = sheet.getRow(0);
			
			ArrayList<String> arr = new ArrayList<>();
			
			List<String> expectedHeaders = Arrays.asList("user_Id", "user_name","address","contact_number","admin_id","created_by");
			
			for (int i = 0; i < 6; i++) {
		
				XSSFCell header_cell= header_row.getCell(i);
			    String header = header_cell.getStringCellValue();

				arr.add(header);
			
			}
			if(!expectedHeaders.equals(arr)) {
				throw new Exception("error");
			}
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				if (row.getRowNum() == 0) { 
					continue;
				}
				Iterator<Cell> cellIterator = row.cellIterator();

				ArrayList<Object> object = new ArrayList<>();
				
			
				
				

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					CellType cellType = cell.getCellType();
					
					switch (cellType) {
					
					case NUMERIC:
						double value = cell.getNumericCellValue();
						
					
						      long l = (new Double(value)).longValue();
						        
						      object.add(l);
					
						break;
						
					case STRING:
						 String value2 = cell.getStringCellValue();
						 
						 
						 try {
						      long l2 = Long.parseLong(value2);
						      if (value2.equals(String.valueOf(l2))) {
						        object.add(value2);
						      } else {
						          object.add(l2);
						      }
		 				    } catch (NumberFormatException e) {
						     object.add(value2);		    
						  
				}
						break;
					default:
				}
				}
				System.out.println(object);
				
				
				if (object.size() < 3) {
	
					throw new Exception("user_Id\", \"user_name\",\"address\" is Mandatory fields, please pass"); 
	
				}
				User user = new User();
		        user.setUser_name((String) object.get(1));
				user.setAddress((String) object.get(2).toString());
				user.setContact_number( object.get(3).toString());;
				user.setAdmin_id(object.get(4).toString());
				user.setCreated_by((String) object.get(5));
				
				user.setDate(new Date());
				user.setIs_active("A");
				
//				if(object.get(2)==null) {
//					user.setResult("adress is requied");
//				}
				userRepo.save(user);
			}
			
 	} catch (Exception e) {
 		
 		
 		
			e.printStackTrace();
		}		
	}}
		



