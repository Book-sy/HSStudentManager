package cn.stylefeng.guns;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * test类
 * Git to： http://club.hsspace.com:3000/Qing_ning/HSLeaveSystem/
 *
 * @TIME 2020/9/9 8:53
 * @AUTHOR 韩硕~
 */

public class test {

    public static void main(String[] ar) throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "C:\\test\\excEx.xls",true);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");
        map.put("date2", "2014-12-26");
        List<Map<String, String>> blue = new ArrayList<Map<String, String>>();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", (i + 1) + "");
            lm.put("date", f.format(new Date()));
            lm.put("xueyuan","计算机学院");
            lm.put("name","小hs");

            blue.add(lm);
        }
        map.put("blue", blue);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("E:/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("E:/666.xls");
        workbook.write(fos);
        fos.close();
    }

}
