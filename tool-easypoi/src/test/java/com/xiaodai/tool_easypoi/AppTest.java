package com.xiaodai.tool_easypoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.xiaodai.tool_easypoi.model.PerClone;
import com.xiaodai.tool_easypoi.model.Person;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testDownExcel(){
    
    	List<Person> dataSet=new ArrayList<Person>();
    	Person person=new Person("xiaodai", 20, new Date(), 1);
    	Person person1=new Person("xiaodai", 20, new Date(), 1);
    	Person person2=new Person("xiaodai", 20, new Date(), 1);
    	Person person3=new Person("xiaodai", 20, new Date(), 1);
    	Person person4=new Person("xiaodai", 20, new Date(), 1);
    	System.out.println(new Date());
    	
    	dataSet.add(person);
    	dataSet.add(person1);
    	dataSet.add(person2);
    	dataSet.add(person3);
    	dataSet.add(person4);
    	//导出数据成对应的excel
    	Workbook workbook=ExcelExportUtil.exportExcel(new ExportParams("个人信息查看", "sheet工作薄"), Person.class, dataSet);
   	 try {
				 FileOutputStream fos=new FileOutputStream("D:/test/test01.xls");
    		try {
					workbook.write(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
   
    public void testUpExcel(){
    	ImportParams params=new ImportParams();
    	params.setTitleRows(1);
    	params.setHeadRows(1);
    	List<Person> list= ExcelImportUtil.importExcel(new File("D:/test/test01.xls"), Person.class, params);
    	for (Person person : list) {
				System.out.println(person.getName()+"---"+person.getAge());
			}
    }
    
    public void testExcelTemplate(){
      TemplateExportParams params = new TemplateExportParams(
          "d:/test/template.xls", true);
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("date", "2014-12-25");
      map.put("money", 2000000.00);
      map.put("upperMoney", "贰佰万");
      map.put("company", "执笔潜行科技有限公司");
      map.put("bureau", "财政局");
      map.put("person", "JueYue");
      map.put("phone", "1879740****");
      List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
      for (int i = 0; i < 4; i++) {
          Map<String, String> lm = new HashMap<String, String>();
          lm.put("id", i + 1 + "");
          lm.put("zijin", i * 10000 + "");
          lm.put("bianma", "A001");
          lm.put("mingcheng", "设计");
          lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
          lm.put("quancheng", "开源项目");
          lm.put("sqje", i * 10000 + "");
          lm.put("hdje", i * 10000 + "");

          listMap.add(lm);
      }
      map.put("maplist", listMap);

      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      FileOutputStream fos;
			try {
				fos = new FileOutputStream("D:/test/template01.xls");
				workbook.write(fos);
	      fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
