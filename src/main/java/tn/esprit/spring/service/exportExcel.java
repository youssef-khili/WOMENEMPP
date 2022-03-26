package tn.esprit.spring.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Training;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class exportExcel {

    public  ByteArrayInputStream traininglist(List<Training> trainingList) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("TrainingList");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("IdTraining");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Cost");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("MaximumParticipantNumber");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("SessionStartDate");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("SessionEndDate");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(5);
            cell.setCellValue("TrainingName");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(6);
            cell.setCellValue("TrainingType");
            cell.setCellStyle(headerCellStyle);





            // Creating data rows for each customer
            for(int i = 0; i < trainingList.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(trainingList.get(i).getIdTraining());
                dataRow.createCell(1).setCellValue(trainingList.get(i).getCost());
                dataRow.createCell(2).setCellValue(trainingList.get(i).getMaximumParticipantNumber());
                dataRow.createCell(3).setCellValue(String.valueOf(trainingList.get(i).getSessionStartDate()));
                dataRow.createCell(4).setCellValue(String.valueOf(trainingList.get(i).getSessionEndDate()));
                dataRow.createCell(5).setCellValue(String.valueOf(trainingList.get(i).getTrainingName()));
                dataRow.createCell(6).setCellValue(String.valueOf(trainingList.get(i).getTrainingType()));





            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);



            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

